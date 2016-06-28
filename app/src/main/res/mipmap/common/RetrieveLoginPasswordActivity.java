package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.os.CountDownTimer;
import android.widget.Button;

import com.umeng.analytics.MobclickAgent;

import java.lang.ref.WeakReference;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.RetrieveLoginPasswordVerifyPhoneFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class RetrieveLoginPasswordActivity extends BaseActivity {


    private static final String TAG = "RetrieveLoginPasswordActivity";

    private WeakReference<Button> smsCodeButton;
    private CountDownTimer countDownTimer;
    private boolean isCountDownTimerFinish = true;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_retrieve_login_password);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.retrievePasswordContainer,
                new RetrieveLoginPasswordVerifyPhoneFragment(), false,
                "RetrieveLoginPasswordVerifyPhoneFragment");
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
}
