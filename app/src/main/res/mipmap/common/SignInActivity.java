package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.os.CountDownTimer;
import android.widget.Button;

import com.umeng.analytics.MobclickAgent;

import java.lang.ref.WeakReference;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.SignInVerifyPhoneFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonDialog;

public class SignInActivity extends BaseActivity {

    private static final String TAG = "SignInActivity";

    private WeakReference<Button> smsCodeButton;
    private CountDownTimer countDownTimer;
    private boolean isCountDownTimerFinish = true;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_sign_in);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.signInContainer,
                new SignInVerifyPhoneFragment(), false,
                "SignInVerifyPhoneFragment");
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
        countDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (smsCodeButton.get() != null) {
                    smsCodeButton.get().setEnabled(false);
                    smsCodeButton.get().setText((millisUntilFinished / 1000) + "秒后重发");
                }
                isCountDownTimerFinish = false;
            }

            @Override
            public void onFinish() {
                if (smsCodeButton.get() != null) {
                    smsCodeButton.get().setEnabled(true);
                    smsCodeButton.get().setText("点击获取验证码");
                }
                isCountDownTimerFinish = true;
            }
        };
    }

    public void contactSMSCodeButton(Button button) {
        smsCodeButton = new WeakReference<>(button);
        button.setEnabled(isCountDownTimerFinish);
        button.setText(isCountDownTimerFinish ? "点击获取验证码" : "");
    }

    public void startTimer() {
        if (isCountDownTimerFinish) {
            isCountDownTimerFinish = false;
            countDownTimer.start();
        }
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
    public void onBackPressed() {
        final CommonDialog commonDialog = new CommonDialog(this, R.string.sweet_note,
                R.string.register_auth_dialog_content, new CommonDialog.Listener() {
            @Override
            public void onLeftButtonClick() {
                cn.pocketwallet.pocketwallet.ui.activity.common.SignInActivity.super.onBackPressed();
            }

            @Override
            public void onRightButtonClick() {

            }
        });
        commonDialog.setLeftButtonText(getString(R.string.register_auth_dialog_button1));
        commonDialog.setRightButtonText(getString(R.string.register_auth_dialog_button2));
        commonDialog.show();
    }
}
