package cn.pocketwallet.pocketwallet.ui.activity.common;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.ForgottenTradePasswordStepOneFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonDialog;

public class ForgottenTradePasswordActivity extends BaseActivity {

    private static final String TAG = "ForgottenTradePasswordActivity";

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_forgotten_trade_password);

        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.forgottenTradePasswordContainer,
                new ForgottenTradePasswordStepOneFragment(), false,
                "ForgottenTradePasswordStepOneFragment");
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onBackPressed() {
        final CommonDialog commonDialog = new CommonDialog(this, R.string.sweet_note, R.string.register_auth_dialog_content, new CommonDialog.Listener() {
            @Override
            public void onLeftButtonClick() {
                cn.pocketwallet.pocketwallet.ui.activity.common.ForgottenTradePasswordActivity.super.onBackPressed();
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
