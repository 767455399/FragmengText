package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.CommonUserApi;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.api.student.StudentUserApi;
import cn.pocketwallet.pocketwallet.api.worker.WorkerUserApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.cache.TokenCache;
import cn.pocketwallet.pocketwallet.cache.UserInfoCache;
import cn.pocketwallet.pocketwallet.model.LoginUserInfoResponseModel;
import cn.pocketwallet.pocketwallet.model.StudentUserInfoModel;
import cn.pocketwallet.pocketwallet.model.UserIdentityModel;
import cn.pocketwallet.pocketwallet.model.WorkerUserBasicInfoModel;
import cn.pocketwallet.pocketwallet.service.AccountService;
import cn.pocketwallet.pocketwallet.util.PhoneNumberUtils;
import cn.pocketwallet.pocketwallet.util.StringUtil;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.util.http.HttpClient;
import cn.pocketwallet.pocketwallet.widget.dialog.IdentityDialog;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private Button loginRegisterButton;
    private Button loginForgetPasswordButton;
    private CheckBox loginEyeCheckBox;
    private Button loginButton;


    private EditText loginPhoneNumberEditText;
    private EditText loginPasswordEditText;

    private IdentityDialog identityDialog = null;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_login);
        loginRegisterButton = (Button) findViewById(R.id.loginRegisterButton);
        loginForgetPasswordButton = (Button) findViewById(R.id.loginForgetPasswordButton);
        loginEyeCheckBox = (CheckBox) findViewById(R.id.loginEyeCheckBox);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginPhoneNumberEditText = (EditText) findViewById(R.id.loginPhoneNumberEditText);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    }

    @Override
    protected void setListeners() {
        loginRegisterButton.setOnClickListener(listener);
        loginForgetPasswordButton.setOnClickListener(listener);
        loginEyeCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        loginButton.setOnClickListener(listener);
    }

    @Override
    protected void loadData() {

    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            loginPasswordEditText.setSelection(loginPasswordEditText.length());
        }
    };

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.loginRegisterButton) {
                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.SignInActivity.class));
            }
            if (v.getId() == R.id.loginForgetPasswordButton) {
                Intent intent = new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.this, RetrieveLoginPasswordActivity.class);
                startActivity(intent);
            }

            if (v.getId() == R.id.loginButton) {
                validateAccount();
            }
        }
    };


    private void validateAccount() {
        String phone = StringUtil.removeSpace(loginPhoneNumberEditText.getText().toString());
        String password = loginPasswordEditText.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showWarningToast(getString(R.string.phone_is_null));
        } else {
            if (PhoneNumberUtils.isMobileNO(phone)) {
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.showWarningToast(getString(R.string.phone_password_wrong));
                } else {
                    login(phone, password);
                }
            } else {
                ToastUtil.showWarningToast(getString(R.string.phone_format_wrong));
            }
        }
    }

    private void login(final String phone, final String password) {
        showLoadingDialog();
        UserInfoCache.savePhone(phone);
        Retrofit accountRetrofit = new Retrofit.Builder()
                .client(HttpClient.getInstance())
                .baseUrl(Urls.ACCOUNT_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<LoginUserInfoResponseModel> observable = accountRetrofit.create(AccountService.class).login(phone, password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginUserInfoResponseModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ApiErrorUtil.handleError(e);
                        TokenCache.clearToken();
                        CommonUserApi.setIsLogin(false);
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onNext(LoginUserInfoResponseModel model) {
                        getIdentity();
                    }
                });
    }


    private void getStudentUserInfo() {
        showLoadingDialog();
        StudentUserApi.getUserInfo(new Subscriber<StudentUserInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                TokenCache.clearToken();
                CommonUserApi.setIsLogin(false);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(StudentUserInfoModel model) {
                studentEnter(model);
            }
        });
    }

    private void getWorkerUserInfo() {
        showLoadingDialog();
        WorkerUserApi.getUserBasicInfo(new Subscriber<WorkerUserBasicInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                TokenCache.clearToken();
                CommonUserApi.setIsLogin(false);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(WorkerUserBasicInfoModel model) {
                workerEnter(model);
            }
        });
    }

    //上班族进入
    private void studentEnter(StudentUserInfoModel model) {
        CommonUserApi.setIsLogin(true);
        UserInfoCache.saveStudentUserInfo(model);
        UserInfoCache.savePhone(model.getPhone());
        UserInfoCache.saveUserName(model.getUserName());
        UserInfoCache.saveAvatar(model.getAvatar());
        ToastUtil.showSuccessToast(getString(R.string.login_success));
        dismissLoadingDialog();
        if (identityDialog != null) {
            identityDialog.dismiss();
        }
        cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.this.finish();
    }

    //学生进入
    private void workerEnter(WorkerUserBasicInfoModel model) {
        CommonUserApi.setIsLogin(true);
        UserInfoCache.saveWorkerUserInfo(model);
        UserInfoCache.savePhone(model.getPhone());
        UserInfoCache.saveUserName(model.getUserName());
        UserInfoCache.saveAvatar(model.getAvatar());
        ToastUtil.showSuccessToast(getString(R.string.login_success));
        dismissLoadingDialog();
        if (identityDialog != null) {
            identityDialog.dismiss();
        }
        cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.this.finish();
    }


    private void getIdentity() {
        CommonUserApi.getUserIdentity(new Subscriber<UserIdentityModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                TokenCache.clearToken();
                CommonUserApi.setIsLogin(false);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(UserIdentityModel userIdentityModel) {
                dismissLoadingDialog();
                CommonUserApi.setCurrentUserIdentity(userIdentityModel.getUserType());
                if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.UNDEFINE) {
                    showIdentityDialog();
                } else if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.STUDENT) {
                    getStudentUserInfo();
                } else if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.WORKER) {
                    getWorkerUserInfo();
                }
            }
        });
    }


    private void showIdentityDialog() {
        identityDialog = new IdentityDialog(cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.this, new IdentityDialog.Listener() {
            @Override
            public void onIdentityConfirm(CommonUserApi.UserIdentity identity) {
                setIdentity(identity);
            }
        });
        identityDialog.show();
    }

    private void setIdentity(final CommonUserApi.UserIdentity identity) {
        showLoadingDialog();
        CommonUserApi.setUserIdentity(identity, new Subscriber<Void>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(Void aVoid) {
                if (identity == CommonUserApi.UserIdentity.STUDENT) {
                    getStudentUserInfo();
                } else if (identity == CommonUserApi.UserIdentity.WORKER) {
                    getWorkerUserInfo();
                }
                CommonUserApi.setCurrentUserIdentity(identity);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        loginPhoneNumberEditText.setText(UserInfoCache.getPhone());
        loginPhoneNumberEditText.setSelection(loginPhoneNumberEditText.length());
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(this);
    }

}
