package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.content.Intent;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.RepayFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class RepayActivity extends BaseActivity {

    private static final String TAG = "RepayActivity";

    private String borrowId = "";
    private boolean isAdvance = false;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_repay);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        if (intent != null) {
            borrowId = intent.getStringExtra("borrowId");
            isAdvance = intent.getBooleanExtra("isAdvance", false);
            FragmentUtil.replace(getSupportFragmentManager(),
                    R.id.repayContainer,
                    RepayFragment.newInstance(borrowId, isAdvance),
                    false, "RepayFragment");
        } else {
            cn.pocketwallet.pocketwallet.ui.activity.common.RepayActivity.this.finish();
        }
    }

    /**
     * 使用银行卡还款
     *
     * @param activity
     * @param borrowId
     */
    public static void normalRepay(Activity activity, String borrowId) {
        Intent intent = new Intent(activity, cn.pocketwallet.pocketwallet.ui.activity.common.RepayActivity.class);
        intent.putExtra("borrowId", borrowId);
        intent.putExtra("isAdvance", false);
        activity.startActivity(intent);
    }

    /**
     * 使用账户余额还款
     *
     * @param activity
     * @param borrowId
     */
    public static void advanceRepay(Activity activity, String borrowId) {
        Intent intent = new Intent(activity, cn.pocketwallet.pocketwallet.ui.activity.common.RepayActivity.class);
        intent.putExtra("borrowId", borrowId);
        intent.putExtra("isAdvance", true);
        activity.startActivity(intent);
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
