package cn.pocketwallet.pocketwallet.ui.activity.common;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.CreditProgressFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class CreditProgressActivity extends BaseActivity {

    private static final String TAG = "CreditProgressActivity";


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_credit_progress);
        FragmentUtil.replace(getSupportFragmentManager(), R.id.creditProgressContainer, new CreditProgressFragment(), false, "CreditProgressFragment");
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
