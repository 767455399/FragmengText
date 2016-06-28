package cn.pocketwallet.pocketwallet.ui.activity.common;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.PayAuthFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class PayAuthActivity extends BaseActivity {

    private static final String TAG = "PayAuthActivity";


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_pay_auth);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.paymentAuthContainer,
                new PayAuthFragment(), false,
                "PayAuthFragment");

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
