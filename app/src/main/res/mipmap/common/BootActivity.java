package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.os.Handler;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.AppApi;
import cn.pocketwallet.pocketwallet.api.common.CommonUserApi;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.api.student.StudentUserApi;
import cn.pocketwallet.pocketwallet.api.worker.WorkerUserApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.cache.TokenCache;
import cn.pocketwallet.pocketwallet.cache.UserInfoCache;
import cn.pocketwallet.pocketwallet.model.CheckUpdateResponseModel;
import cn.pocketwallet.pocketwallet.model.LoginStatusModel;
import cn.pocketwallet.pocketwallet.model.StudentUserInfoModel;
import cn.pocketwallet.pocketwallet.model.UserIdentityModel;
import cn.pocketwallet.pocketwallet.model.WorkerUserBasicInfoModel;
import cn.pocketwallet.pocketwallet.service.AccountService;
import cn.pocketwallet.pocketwallet.util.DeviceUtil;
import cn.pocketwallet.pocketwallet.util.http.HttpClient;
import cn.pocketwallet.pocketwallet.widget.dialog.ForceUpdateDialog;
import cn.pocketwallet.pocketwallet.widget.dialog.NormalUpdateDialog;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BootActivity extends BaseActivity {

    private static final String TAG = "BootActivity";
    private static final long DELAY = 1000;

    private Handler handler = new Handler();


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_boot);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
        MobclickAgent.openActivityDurationTrack(false);
        checkUpdate();
    }

    private void checkUpdate() {
        AppApi.checkUpdate(DeviceUtil.getVersionCode(this), new Subscriber<CheckUpdateResponseModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getLoginStatus();
            }

            @Override
            public void onNext(CheckUpdateResponseModel model) {
                showUpdateDialog(model);
            }
        });
    }

    private void showUpdateDialog(CheckUpdateResponseModel checkUpdateResponseModel) {
        if (checkUpdateResponseModel.getIsNewest()) {
            getLoginStatus();
        } else {
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append(getString(R.string.current_version)).append(DeviceUtil.getVersionName(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this)).append("\n");
            stringBuffer.append(getString(R.string.the_latest_version)).append(checkUpdateResponseModel.getVersionName()).append("\n");
            stringBuffer.append(getString(R.string.update_description)).append(checkUpdateResponseModel.getDescribe()).append("\n");
            stringBuffer.append(getString(R.string.update_log)).append(checkUpdateResponseModel.getLog());
            if (checkUpdateResponseModel.getIsForce()) {
                new ForceUpdateDialog(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this, stringBuffer.toString(), checkUpdateResponseModel.getUrl(), new ForceUpdateDialog.Listener() {
                    @Override
                    public void onLeftButtonClick() {
                        cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this.finish();
                    }

                    @Override
                    public void onRightButtonClick() {

                    }
                }).show();
            } else {
                new NormalUpdateDialog(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this, stringBuffer.toString(), checkUpdateResponseModel.getUrl(), new NormalUpdateDialog.Listener() {
                    @Override
                    public void onLeftButtonClick() {
                        getLoginStatus();
                    }

                    @Override
                    public void onRightButtonClick() {
                        getLoginStatus();
                    }
                }).show();
            }
        }
    }


    private void getLoginStatus() {
        Retrofit accountRetrofit = new Retrofit.Builder()
                .client(HttpClient.getInstance())
                .baseUrl(Urls.ACCOUNT_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<LoginStatusModel> observable = accountRetrofit.create(AccountService.class).getLoginStatus();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginStatusModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        notLoginEnter();
                    }

                    @Override
                    public void onNext(LoginStatusModel loginStatusModel) {
                        if (loginStatusModel.getIsLogined()) {
                            getIdentity();
                        } else {
                            notLoginEnter();
                        }
                    }
                });
    }

    private void getIdentity() {
        CommonUserApi.getUserIdentity(new Subscriber<UserIdentityModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                notLoginEnter();
            }

            @Override
            public void onNext(UserIdentityModel userIdentityModel) {
                CommonUserApi.setCurrentUserIdentity(userIdentityModel.getUserType());
                if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.UNDEFINE) {
                    notLoginEnter();
                } else if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.STUDENT) {
                    getStudentUserInfo();
                } else if (userIdentityModel.getUserType() == CommonUserApi.UserIdentity.WORKER) {
                    getWorkerUserInfo();
                }
            }
        });
    }

    private void getStudentUserInfo() {
        StudentUserApi.getUserInfo(new Subscriber<StudentUserInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                notLoginEnter();
            }

            @Override
            public void onNext(StudentUserInfoModel model) {
                studentEnter(model);
            }
        });
    }

    private void getWorkerUserInfo() {
        WorkerUserApi.getUserBasicInfo(new Subscriber<WorkerUserBasicInfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                notLoginEnter();
            }

            @Override
            public void onNext(WorkerUserBasicInfoModel model) {
                workerEnter(model);
            }
        });
    }

    //未登录状态进入
    private void notLoginEnter() {
        CommonUserApi.setIsLogin(false);
        TokenCache.clearToken();
        handler.postDelayed(runnable, DELAY);
    }

    //上班族进入
    private void studentEnter(StudentUserInfoModel model) {
        CommonUserApi.setIsLogin(true);
        UserInfoCache.saveStudentUserInfo(model);
        UserInfoCache.savePhone(model.getPhone());
        UserInfoCache.saveUserName(model.getUserName());
        UserInfoCache.saveAvatar(model.getAvatar());
        handler.postDelayed(runnable, DELAY);
    }

    //学生进入
    private void workerEnter(WorkerUserBasicInfoModel model) {
        CommonUserApi.setIsLogin(true);
        UserInfoCache.saveWorkerUserInfo(model);
        UserInfoCache.savePhone(model.getPhone());
        UserInfoCache.saveUserName(model.getUserName());
        UserInfoCache.saveAvatar(model.getAvatar());
        handler.postDelayed(runnable, DELAY);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            AppApi.checkIsFirstBoot(new Subscriber<Boolean>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.class));
                    cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this.finish();
                }

                @Override
                public void onNext(Boolean isFirstBoot) {
                    if (isFirstBoot) {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.class));
                        cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this.finish();
                    } else {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this, MainActivity.class));
                        cn.pocketwallet.pocketwallet.ui.activity.common.BootActivity.this.finish();
                    }
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
