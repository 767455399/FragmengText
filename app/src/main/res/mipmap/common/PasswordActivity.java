package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Context;
import android.content.Intent;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.ChangeLoginPasswordFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.ChangeTradingPasswordFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class PasswordActivity extends BaseActivity {

    private static final String TAG = "PasswordActivity";

    public static final String CHANGE_PASSWORD = "CHANGE_PASSWORD";
    public static final String CHANGE_TRADING_PASSWORD = "CHANGE_TRADING_PASSWORD";

    private String passwordAction;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_password);
        passwordAction = getIntent().getStringExtra("action");
        if (passwordAction.equals(CHANGE_PASSWORD)) {
            FragmentUtil.replace(getSupportFragmentManager(),
                    R.id.passwordContainer,
                    new ChangeLoginPasswordFragment(), false,
                    "ChangeLoginPasswordFragment");
        }
        if (passwordAction.equals(CHANGE_TRADING_PASSWORD)) {
            FragmentUtil.replace(getSupportFragmentManager(),
                    R.id.passwordContainer,
                    new ChangeTradingPasswordFragment(), false,
                    "ChangeTradingPasswordFragment");
        }
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }


    public static Intent getPasswordActivityIntent(Context context, String passwordAction) {
        Intent intent = new Intent();
        intent.setClass(context, cn.pocketwallet.pocketwallet.ui.activity.common.PasswordActivity.class);
        intent.putExtra("action", passwordAction);
        return intent;
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
