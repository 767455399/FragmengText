package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jack.qrcode.QRCode;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.util.Constants;
import cn.pocketwallet.pocketwallet.util.roundedimage.RoundedTransformationBuilder;

/**
 * 项目名称：PocketWallet
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/23 11:39
 * 修改人：WangQing
 * 修改时间：2015/12/23 11:39
 * 修改备注：
 */
public class NewQRCodeActivity extends BaseActivity {

    private static final String TAG = "NewQRCodeActivity";

    private static final String PARAM_USER_NAME = "userName";
    private static final String PARAM_AVATAR = "avatar";
    private static final String PARAM_INVITATION_CODE = "invitationCode";

    private TextView userNameTextView;
    private ImageView headPortraitImageView;
    private TextView authenticationStatusTextView;
    private ImageView qrCodeImageView;


    private String userName;
    private String avatar;
    private String invitationCode;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_qr_code);

        userName = getIntent().getStringExtra(PARAM_USER_NAME);
        avatar = getIntent().getStringExtra(PARAM_AVATAR);
        invitationCode = getIntent().getStringExtra(PARAM_INVITATION_CODE);
        userNameTextView = (TextView) findViewById(R.id.userNameTextView);
        headPortraitImageView = (ImageView) findViewById(R.id.headPortraitImageView);
        authenticationStatusTextView = (TextView) findViewById(R.id.authenticationStatusTextView);
        qrCodeImageView = (ImageView) findViewById(R.id.qrCodeImageView);
        qrCodeImageView.post(new Runnable() {
            @Override
            public void run() {
                loadQRCode(qrCodeImageView.getWidth());
            }
        });
    }

    @Override
    protected void setListeners() {


    }

    @Override
    protected void loadData() {
        userNameTextView.setText(userName);
        loadHeadPortrait(avatar);
    }

    public static void toQRCodeActivity(Activity activity, String userName, String
            avatar, String invitationCode) {
        Intent intent = new Intent(activity, cn.pocketwallet.pocketwallet.ui.activity.common.NewQRCodeActivity.class);
        intent.putExtra(PARAM_USER_NAME, userName);
        intent.putExtra(PARAM_AVATAR, avatar);
        intent.putExtra(PARAM_INVITATION_CODE, invitationCode);
        activity.startActivity(intent);
    }


    private void loadHeadPortrait(String avatarUrl) {
        if (TextUtils.isEmpty(avatarUrl)) {
            avatarUrl = "http://default";
        }

        Transformation transformation = new RoundedTransformationBuilder()
                .oval(true)
                .build();
        RequestCreator requestCreator = Picasso.with(getApplicationContext())
                .load(avatarUrl)
                .placeholder(R.mipmap.bg_avatar_sample)
                .error(R.mipmap.bg_avatar_sample)
                .fit()
                .transform(transformation);
        requestCreator.into(headPortraitImageView);
    }


    private void loadQRCode(final int size) {
        String code = Constants.QRCODE_PREFIX + invitationCode;
        authenticationStatusTextView.setText(getString(R.string.my_invitation_code) + invitationCode);
        qrCodeImageView.setImageBitmap(QRCode.from(code).withSize(size, size).bitmap());
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
