package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.BankCardApi;
import cn.pocketwallet.pocketwallet.api.PayApi;
import cn.pocketwallet.pocketwallet.api.RechargeApi;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.BankCardListModel;
import cn.pocketwallet.pocketwallet.model.BankCardModel;
import cn.pocketwallet.pocketwallet.model.LianlianPayParamModel;
import cn.pocketwallet.pocketwallet.service.BankCardService;
import cn.pocketwallet.pocketwallet.util.MoneyValueFilter;
import cn.pocketwallet.pocketwallet.util.NumberFormatUtil;
import cn.pocketwallet.pocketwallet.util.StringUtil;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.util.http.HttpClient;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonTradePasswordDialog;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RechargeActivity extends BaseActivity {

    private ImageView rechargeBankImageView;
    private TextView rechargeAmountLimitTextView;
    private TextView rechargeBankNumberTextView;
    private EditText rechargeAmountEditText;
    private Button rechargeButton;

    private String bankCardNo;
    private String bankCardCode;
    private String bankCardId;

    private String noOrder;

    private double amount = 0.0;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_recharge);
        rechargeBankImageView = (ImageView) findViewById(R.id.rechargeBankImageView);
        rechargeBankNumberTextView = (TextView) findViewById(R.id.rechargeBankNumberTextView);
        rechargeAmountLimitTextView = (TextView) findViewById(R.id.rechargeAmountLimitTextView);
        rechargeAmountEditText = (EditText) findViewById(R.id.rechargeAmountEditText);
        rechargeButton = (Button) findViewById(R.id.rechargeButton);

        InputFilter[] filters = {new MoneyValueFilter(), new InputFilter.LengthFilter(10)};
        rechargeAmountEditText.setFilters(filters);
    }

    @Override
    protected void setListeners() {
        rechargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = rechargeAmountEditText.getText().toString();
                amount = NumberFormatUtil.parseDouble(amountText, 0.0);
                if (amount >= 1) {
                    verifyTradePassword(amount);
                } else {
                    ToastUtil.showWarningToast(R.string.recharge_amount_is_0);
                }
            }
        });
    }

    @Override
    protected void loadData() {
        load();
    }

    private void load() {
        showLoadingDialog();
        Retrofit fundRetrofit = new Retrofit.Builder()
                .client(HttpClient.getInstance())
                .baseUrl(Urls.FUND_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<BankCardListModel> observable = fundRetrofit.create(BankCardService.class).getBankCardList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BankCardListModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        ApiErrorUtil.handleError(e);
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onNext(BankCardListModel model) {
                        List<BankCardModel> cardList = model.getInfos();
                        if (cardList.size() > 0) {
                            BankCardModel bankCard = cardList.get(0);
                            bankCardNo = bankCard.getBankCardNo();
                            bankCardCode = bankCard.getBankCardCode();
                            bankCardId = bankCard.getBankCardId();
                            int resId = BankCardApi.getBankImageResByBankCode(bankCardCode);
                            if (resId != 0) {
                                rechargeBankImageView.setImageResource(resId);
                            }
                            rechargeAmountLimitTextView.setText(BankCardApi.getBankCardLimitString(bankCardCode));
                            if (bankCardNo.length() >= 15) {
                                rechargeBankNumberTextView.setText(StringUtil.invisibleWord(bankCardNo, 0, 4));
                            }
                            dismissLoadingDialog();
                        } else {
                            dismissLoadingDialog();
                            cn.pocketwallet.pocketwallet.ui.activity.common.RechargeActivity.this.finish();
                            ToastUtil.showWarningToast("请确认是否绑定银行卡");
                        }
                    }
                });
    }


    private void verifyTradePassword(final double amount) {
        new CommonTradePasswordDialog(cn.pocketwallet.pocketwallet.ui.activity.common.RechargeActivity.this, new CommonTradePasswordDialog.CallBack() {
            @Override
            public void onSuccess() {
                recharge(amount);
            }

            @Override
            public void onCancel() {

            }
        }).show();
    }


    private void recharge(double amount) {
        showLoadingDialog();
        RechargeApi.rechargeToAccount(amount, new Subscriber<LianlianPayParamModel>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(LianlianPayParamModel model) {
                try {
                    noOrder = model.getNoOrder();
                    String payParam = new Gson().toJson(model);
                    pay(payParam);
                } catch (Exception e) {
                    ToastUtil.showWarningToast(R.string.data_parse_fail);
                    dismissLoadingDialog();
                }
            }
        });
    }

    private void pay(String payParam) {
        new PayApi(cn.pocketwallet.pocketwallet.ui.activity.common.RechargeActivity.this).pay(payParam, new Subscriber<JSONObject>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                cancelPay(noOrder);
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(JSONObject jsonObject) {
                Log.e("jsonObject", jsonObject.toString());
                String retCode = jsonObject.optString("ret_code");
                String retMsg = jsonObject.optString("ret_msg");
                String resultPay = jsonObject.optString("result_pay");

                if (PayApi.RET_CODE_SUCCESS.equals(retCode)) {
                    if (PayApi.RESULT_PAY_SUCCESS.equalsIgnoreCase(resultPay)) {
                        ToastUtil.showSuccessToast(R.string.recharge_success);
                        cn.pocketwallet.pocketwallet.ui.activity.common.RechargeActivity.this.finish();
                    } else {
                        ToastUtil.showWarningToast(retMsg);
                        cancelPay(noOrder);
                    }
                } else if (PayApi.RET_CODE_PROCESS.equals(retCode)) {
                    ToastUtil.showWarningToast(retMsg);
                    cancelPay(noOrder);
                } else if (PayApi.RET_CODE_STOP.equals(retCode)) {
                    ToastUtil.showWarningToast(getString(R.string.cancel_payment));
                    cancelPay(noOrder);
                } else {
                    ToastUtil.showWarningToast(retMsg);
                    cancelPay(noOrder);
                }
                dismissLoadingDialog();
            }
        });
    }

    private void cancelPay(String noOrder) {
        if (!TextUtils.isEmpty(noOrder)) {
            PayApi.payCancel(noOrder);
        }
    }
}
