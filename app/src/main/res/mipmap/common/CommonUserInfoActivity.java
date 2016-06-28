package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.CommonUserApi;
import cn.pocketwallet.pocketwallet.api.common.ImageUploadApi;
import cn.pocketwallet.pocketwallet.api.student.StudentUserApi;
import cn.pocketwallet.pocketwallet.api.worker.WorkerUserApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.base.BaseApplication;
import cn.pocketwallet.pocketwallet.cache.UserInfoCache;
import cn.pocketwallet.pocketwallet.model.ImageUpTokenModel;
import cn.pocketwallet.pocketwallet.model.InvitationCodeModel;
import cn.pocketwallet.pocketwallet.model.StudentUserInfoModel;
import cn.pocketwallet.pocketwallet.model.UploadImageModel;
import cn.pocketwallet.pocketwallet.model.WorkerUserBasicInfoModel;
import cn.pocketwallet.pocketwallet.ui.activity.student.StudentInfoActivity;
import cn.pocketwallet.pocketwallet.ui.activity.worker.WorkerInfoActivity;
import cn.pocketwallet.pocketwallet.util.BitmapCompressUtil;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import cn.pocketwallet.pocketwallet.util.album.AlbumIntentUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.util.roundedimage.RoundedTransformationBuilder;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CommonUserInfoActivity extends BaseActivity {

    private static final String TAG = "CommonUserInfoActivity";


    private ImageView userInfoAvatarImageView;
    private TextView userInfoCheckTextView;
    private TextView userInfoNameClickTextView;
    private TextView userInfoNameTextView;
    private TextView userInfoPhoneClickTextView;
    private TextView userInfoPhoneTextView;
    private TextView userInfoInvitationCodeClickTextView;
    private TextView userInfoInvitationCodeTextView;
    private TextView userInfoQRCodeTextView;

    private String userName;
    private String avatar;
    private String invitationCode;

    private Subscriber<InvitationCodeModel> subscriber;

    private StudentUserInfoModel studentUserInfo;
    private WorkerUserBasicInfoModel workerUserBasicInfo;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_common_user_info);
        userInfoAvatarImageView = (ImageView) findViewById(R.id.userInfoAvatarImageView);
        userInfoNameTextView = (TextView) findViewById(R.id.userInfoNameTextView);
        userInfoPhoneTextView = (TextView) findViewById(R.id.userInfoPhoneTextView);
        userInfoInvitationCodeTextView = (TextView) findViewById(R.id.userInfoInvitationCodeTextView);
    }

    @Override
    protected void setListeners() {
        findViewById(R.id.userInfoAvatarTextView).setOnClickListener(listener);
        findViewById(R.id.userInfoCheckTextView).setOnClickListener(listener);
        findViewById(R.id.userInfoQRCodeTextView).setOnClickListener(listener);
    }

    @Override
    protected void loadData() {
        loadAvatar("http://default");
        if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.STUDENT) {
            getStudentUserInfo();
        } else if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.WORKER) {
            getWorkerUserInfo();
        }
        getInvitationCode();
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.userInfoCheckTextView) {
                if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.STUDENT) {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.CommonUserInfoActivity.this, StudentInfoActivity.class));
                } else if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.WORKER) {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.CommonUserInfoActivity.this, WorkerInfoActivity.class));
                }
            }
            if (v.getId() == R.id.userInfoAvatarTextView) {
                AlbumIntentUtil.startAlbumActivityForSingleResult(cn.pocketwallet.pocketwallet.ui.activity.common.CommonUserInfoActivity.this, "修改头像", true, false, true);
            }
            if (v.getId() == R.id.userInfoQRCodeTextView) {
                NewQRCodeActivity.toQRCodeActivity(cn.pocketwallet.pocketwallet.ui.activity.common.CommonUserInfoActivity.this, userName, avatar, invitationCode);
            }
        }
    };


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AlbumIntentUtil.REQUEST_CODE_ALBUM) {
            if (resultCode == AlbumIntentUtil.RESULT_OK) {
                ArrayList<String> photos = data.getStringArrayListExtra("selectedPhotos");
                if (photos.size() > 0) {
                    String path = photos.get(0);
                    if (TextUtils.isEmpty(path)) {
                        ToastUtil.showWarningToast(getString(R.string.please_choose_a_picture));
                    } else {
                        bitmapCompress(path);
                    }
                } else {
                    ToastUtil.showWarningToast(getString(R.string.please_choose_a_picture));
                }
            }
        }
    }

    private void bitmapCompress(final String originalPath) {
        showLoadingDialog();
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String targetPath = BaseApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/"
                        + System.currentTimeMillis() + "_compress_avatar.jpg";
                String resultPath = BitmapCompressUtil.compressToPath(originalPath, targetPath);
                subscriber.onNext(resultPath);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ApiErrorUtil.handleError(e);
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onNext(String compressPath) {
                        getUpToken(compressPath);
                    }
                });

    }

    private void getUpToken(final String localCompressAvatar) {
        showLoadingDialog();
        ImageUploadApi.getUpToken(new Subscriber<ImageUpTokenModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(ImageUpTokenModel model) {
                uploadAvatar(new UploadImageModel("avatar" + System.currentTimeMillis(), localCompressAvatar), model.getUptoken());
            }
        });
    }


    private void uploadAvatar(UploadImageModel uploadImageModel, String upToken) {
        ImageUploadApi.uploadImage(uploadImageModel, upToken, new Subscriber<UploadImageModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(UploadImageModel model) {
                if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.STUDENT) {
                    updateStudentAvatar(model.getPath());
                } else if (CommonUserApi.getCurrentUserIdentity() == CommonUserApi.UserIdentity.WORKER) {
                    updateWorkerAvatar(model.getPath());
                }
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
                dismissLoadingDialog();
            }

            @Override
            public void onNext(StudentUserInfoModel model) {
                dismissLoadingDialog();
                studentUserInfo = model;
                UserInfoCache.saveAvatar(model.getAvatar());
                loadAvatar(model.getAvatar());
                userName = model.getUserName();
                avatar = model.getAvatar();
                userInfoNameTextView.setText(model.getUserName());
                userInfoPhoneTextView.setText(model.getPhone());
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
                dismissLoadingDialog();
            }

            @Override
            public void onNext(WorkerUserBasicInfoModel model) {
                dismissLoadingDialog();
                workerUserBasicInfo = model;
                UserInfoCache.saveAvatar(model.getAvatar());
                loadAvatar(model.getAvatar());
                userName = model.getUserName();
                avatar = model.getAvatar();
                userInfoNameTextView.setText(model.getUserName());
                userInfoPhoneTextView.setText(model.getPhone());
            }
        });
    }

    private void updateStudentAvatar(final String avatarUrl) {
        studentUserInfo.setAvatar(avatarUrl);
        StudentUserApi.updateUserInfo(studentUserInfo, new Subscriber<Void>() {
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
                dismissLoadingDialog();
                UserInfoCache.saveAvatar(avatarUrl);
                loadAvatar(avatarUrl);
            }
        });

    }

    private void updateWorkerAvatar(final String avatarUrl) {
        workerUserBasicInfo.setAvatar(avatarUrl);
        WorkerUserApi.updateUserBasicInfo(workerUserBasicInfo, new Subscriber<Void>() {
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
                dismissLoadingDialog();
                UserInfoCache.saveAvatar(avatarUrl);
                loadAvatar(avatarUrl);

            }
        });
    }


    private void getInvitationCode() {
        subscriber = new Subscriber<InvitationCodeModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(InvitationCodeModel invitationCodeModel) {
                invitationCode = invitationCodeModel.getReferrerCode();
                userInfoInvitationCodeTextView.setText(invitationCode);
            }
        };
        CommonUserApi.getInvitationCode(subscriber);
    }


    private void loadAvatar(String avatarUrl) {
        if (TextUtils.isEmpty(avatarUrl)) {
            avatarUrl = "http://default";
        }
        Transformation transformation = new RoundedTransformationBuilder()
                .oval(true)
                .build();
        RequestCreator requestCreator = Picasso.with(getApplicationContext())
                .load(avatarUrl)
                .placeholder(userInfoAvatarImageView.getDrawable())
                .error(R.mipmap.bg_avatar_sample)
                .fit()
                .transform(transformation);
        requestCreator.into(userInfoAvatarImageView);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelRequest(subscriber);
    }
}
