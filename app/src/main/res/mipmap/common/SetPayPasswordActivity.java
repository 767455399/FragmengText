package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.AccountApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.UpdateTradePasswordResponseModel;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonDialog;
import rx.Subscriber;

public class SetPayPasswordActivity extends BaseActivity {

    private static final String TAG = "SetPayPasswordFragment";

    private EditText setPayPasswordEditText;
    private CheckBox setPayPasswordEyeCheckBox;
    private Button setPayPasswordButton;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_set_pay_password);
        setPayPasswordEditText = (EditText) findViewById(R.id.setPayPasswordEditText);
        setPayPasswordEyeCheckBox = (CheckBox) findViewById(R.id.setPayPasswordEyeCheckBox);
        setPayPasswordButton = (Button) findViewById(R.id.setPayPasswordButton);
        setPayPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    protected void setListeners() {
        setPayPasswordEyeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setPayPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    setPayPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                setPayPasswordEditText.setSelection(setPayPasswordEditText.length());
            }
        });
        setPayPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void validate() {
        String payPassword = setPayPasswordEditText.getText().toString();
        if (payPassword.length() < 6) {
            ToastUtil.showWarningToast(getString(R.string.password_is_too_short));
        } else {
            setPayPassword(payPassword);
        }
    }

    private void setPayPassword(String payPassword) {
        showLoadingDialog();
        AccountApi.updateTradePassword("", payPassword, new Subscriber<UpdateTradePasswordResponseModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(UpdateTradePasswordResponseModel responseModel) {
                if (responseModel.getSuccess()) {
                    ToastUtil.showSuccessToast(R.string.set_trading_password_success);
                    finish();
                } else {
                    int remainTimes = responseModel.getRemainTimes();
                    if (remainTimes == 1) {
                        final CommonDialog tradePasswordDialog = new CommonDialog(cn.pocketwallet.pocketwallet.ui.activity.common.SetPayPasswordActivity.this,
                                getString(R.string.sweet_note),
                                String.format(getString(R.string.forget_trade_password_content_1), remainTimes), new CommonDialog.Listener() {
                            @Override
                            public void onLeftButtonClick() {

                            }

                            @Override
                            public void onRightButtonClick() {
                                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.SetPayPasswordActivity.this, ForgottenTradePasswordActivity.class));
                            }
                        });
                        tradePasswordDialog.setLeftButtonText(getString(R.string.try_on));
                        tradePasswordDialog.setRightButtonText(getString(R.string.retrieve_password));
                        tradePasswordDialog.show();
                    } else {
                        ToastUtil.showWarningToast(String.format(getString(R.string.forget_trade_password_content_2), remainTimes));
                    }
                }
                dismissLoadingDialog();
            }
        });
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
