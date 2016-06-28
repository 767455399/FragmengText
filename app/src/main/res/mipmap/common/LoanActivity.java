package cn.pocketwallet.pocketwallet.ui.activity.common;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.LoanInstallmentFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class LoanActivity extends BaseActivity {

    private static final String TAG = "LoanActivity";


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_loan);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.loanContainer,
                new LoanInstallmentFragment(), false,
                "LoanInstallmentFragment");

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
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


