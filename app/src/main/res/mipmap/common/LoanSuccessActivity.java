package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.animation.Animator;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jack.anim.JackAnim;
import com.jack.anim.Techniques;
import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.widget.SuccessView;

public class LoanSuccessActivity extends BaseActivity {

    private static final String TAG = "RepaySucceedFragment";

    private Button loanSuccessButton;
    private RelativeLayout loanSuccessRelativeLayout;
    private SuccessView loanSuccessView;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_loan_success);
        loanSuccessButton = (Button) findViewById(R.id.loanSuccessButton);
        loanSuccessRelativeLayout = (RelativeLayout) findViewById(R.id.loanSuccessRelativeLayout);
        loanSuccessView = (SuccessView) findViewById(R.id.loanSuccessView);
        loanSuccessRelativeLayout.setAlpha(0);
    }

    @Override
    protected void setListeners() {
        loanSuccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.LoanSuccessActivity.this, LoanRecordActivity.class));
                cn.pocketwallet.pocketwallet.ui.activity.common.LoanSuccessActivity.this.finish();
            }
        });
    }

    @Override
    protected void loadData() {
        JackAnim.with(Techniques.FadeIn).duration(700).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                loanSuccessRelativeLayout.setAlpha(1f);
                loanSuccessView.startAnim();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(loanSuccessRelativeLayout);
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
