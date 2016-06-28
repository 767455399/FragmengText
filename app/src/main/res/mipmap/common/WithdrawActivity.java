package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import java.util.List;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.AccountApi;
import cn.pocketwallet.pocketwallet.api.BankCardApi;
import cn.pocketwallet.pocketwallet.api.WithdrawApi;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.AccountBalanceModel;
import cn.pocketwallet.pocketwallet.model.BankCardBranchInfoResponseModel;
import cn.pocketwallet.pocketwallet.model.BankCardListModel;
import cn.pocketwallet.pocketwallet.model.BankCardModel;
import cn.pocketwallet.pocketwallet.model.TradePasswordStatusModel;
import cn.pocketwallet.pocketwallet.service.BankCardService;
import cn.pocketwallet.pocketwallet.service.WithdrawService;
import cn.pocketwallet.pocketwallet.util.MoneyValueFilter;
import cn.pocketwallet.pocketwallet.util.NumberFormatUtil;
import cn.pocketwallet.pocketwallet.util.StringUtil;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.util.http.HttpClient;
import cn.pocketwallet.pocketwallet.util.http.LogicException;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonTradePasswordDialog;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class WithdrawActivity extends BaseActivity {

    private static final String TAG = "WithdrawActivity";

    private static final int REQUEST_CODE_BANK_BRANCH = 0x0001;

    private TextView withdrawAccountBalanceTextView;
    private TextView withdrawBankNumberTextView;
    private TextView withdrawBankBranchTextView;
    private ImageView withdrawBankImageView;
    private LinearLayout withdrawBranchLinearLayout;
    private LinearLayout withdrawBankBranchClickLinearLayout;
    private EditText withdrawAmountEditText;
    private Button withdrawButton;


    private String bankCardNo;
    private String bankCardCode;
    private String bankCardId;
    private String bankBranchName;
    private boolean isNeedBranch;

    private double fundBalance = 0.0;
    private double amount = 0.0;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_withdraw);
        withdrawAccountBalanceTextView = (TextView) findViewById(R.id.withdrawAccountBalanceTextView);
        withdrawBankNumberTextView = (TextView) findViewById(R.id.withdrawBankNumberTextView);
        withdrawBankBranchTextView = (TextView) findViewById(R.id.withdrawBankBranchTextView);
        withdrawBankImageView = (ImageView) findViewById(R.id.withdrawBankImageView);
        withdrawBranchLinearLayout = (LinearLayout) findViewById(R.id.withdrawBranchLinearLayout);
        withdrawBankBranchClickLinearLayout = (LinearLayout) findViewById(R.id.withdrawBankBranchClickLinearLayout);
        withdrawAmountEditText = (EditText) findViewById(R.id.withdrawAmountEditText);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        withdrawBranchLinearLayout.setVisibility(View.GONE);

        InputFilter[] filters = {new MoneyValueFilter(), new InputFilter.LengthFilter(10)};
        withdrawAmountEditText.setFilters(filters);
    }

    @Override
    protected void setListeners() {
        withdrawBankBranchClickLinearLayout.setOnClickListener(listener);
        withdrawButton.setOnClickListener(listener);
        withdrawAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String amountText = s.toString();
                double amountDou = NumberFormatUtil.parseDouble(amountText, 0.0);
                if (amountDou > fundBalance) {
                    amountDou = fundBalance;
                    withdrawAmountEditText.setText(String.format(getString(R.string.double_format), amountDou));
                    withdrawAmountEditText.setSelection(String.format(getString(R.string.double_format), amountDou).length());
                }
            }
        });
    }

    @Override
    protected void loadData() {
        load();
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.withdrawBankBranchClickLinearLayout) {
                Intent intent = new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WithdrawActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.BankBranchActivity.class);
                intent.putExtra("bankCardId", bankCardId);
                startActivityForResult(intent, REQUEST_CODE_BANK_BRANCH);
            }
            if (v.getId() == R.id.withdrawButton) {
                String amountText = withdrawAmountEditText.getText().toString();
                amount = NumberFormatUtil.parseDouble(amountText, 0.0);
                if (amount > fundBalance) {
                    amount = fundBalance;
                }
                if (amount >= 1) {
                    verifyTradePassword(amount, bankCardNo);
                } else {
                    ToastUtil.showWarningToast(R.string.withdraw_amount_is_0);
                }
            }
        }
    };


    private void load() {
        showLoadingDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .client(HttpClient.getInstance())
                .baseUrl(Urls.FUND_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<BankCardListModel> observable = retrofit.create(BankCardService.class).getBankCardList();
        observable.flatMap(new Func1<BankCardListModel, Observable<BankCardBranchInfoResponseModel>>() {
            @Override
            public Observable<BankCardBranchInfoResponseModel> call(BankCardListModel model) {
                List<BankCardModel> cardList = model.getInfos();
                if (cardList.size() > 0) {
                    BankCardModel bankCard = cardList.get(0);
                    bankCardNo = bankCard.getBankCardNo();
                    bankCardCode = bankCard.getBankCardCode();
                    bankCardId = bankCard.getBankCardId();
                    Retrofit retrofit = new Retrofit.Builder()
                            .client(HttpClient.getInstance())
                            .baseUrl(Urls.FUND_BASE_URL)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    return retrofit.create(BankCardService.class).checkIsNeedBranch(bankCardId);
                } else {
                    dismissLoadingDialog();
                    cn.pocketwallet.pocketwallet.ui.activity.common.WithdrawActivity.this.finish();
                    return Observable.error(new LogicException("请确认是否绑定银行卡", true));
                }
            }
        }).flatMap(new Func1<BankCardBranchInfoResponseModel, Observable<AccountBalanceModel>>() {
            @Override
            public Observable<AccountBalanceModel> call(BankCardBranchInfoResponseModel model) {
                isNeedBranch = model.getIsNeedBranch();
                bankBranchName = model.getBraBankName();
                Retrofit retrofit = new Retrofit.Builder()
                        .client(HttpClient.getInstance())
                        .baseUrl(Urls.FUND_BASE_URL)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                return retrofit.create(WithdrawService.class).getAccountBalance();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AccountBalanceModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ApiErrorUtil.handleError(e);
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onNext(AccountBalanceModel model) {
                        int resId = BankCardApi.getBankImageResByBankCode(bankCardCode);
                        if (resId != 0) {
                            withdrawBankImageView.setImageResource(resId);
                        }
                        if (bankCardNo.length() >= 15) {
                            withdrawBankNumberTextView.setText(StringUtil.invisibleWord(bankCardNo, 0, 4));
                        }
                        if (isNeedBranch) {
                            withdrawBranchLinearLayout.setVisibility(View.VISIBLE);
                            if (!TextUtils.isEmpty(bankBranchName)) {
                                withdrawBankBranchTextView.setTextColor(Color.parseColor("#333333"));
                                withdrawBankBranchTextView.setText(bankBranchName);
                            }
                        }
                        fundBalance = model.getBalanceAmount();
                        withdrawAccountBalanceTextView.setText("账户余额:" + fundBalance);
                        dismissLoadingDialog();
                    }
                });
    }


    private void verifyTradePassword(final double amount, final String bankCardNo) {
        showLoadingDialog();
        AccountApi.getTradePasswordStatus(new Subscriber<TradePasswordStatusModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(TradePasswordStatusModel model) {
                dismissLoadingDialog();
                if (model.getHave()) {
                    new CommonTradePasswordDialog(cn.pocketwallet.pocketwallet.ui.activity.common.WithdrawActivity.this, new CommonTradePasswordDialog.CallBack() {
                        @Override
                        public void onSuccess() {
                            withdraw(amount, bankCardNo);
                        }

                        @Override
                        public void onCancel() {

                        }
                    }).show();
                } else {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WithdrawActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.SetPayPasswordActivity.class));
                    ToastUtil.showWarningToast("请先设置交易密码");
                }
            }
        });
    }


    private void withdraw(final double amount, final String bankCardNo) {
        showLoadingDialog();
        WithdrawApi.withdraw(amount, bankCardNo, new Subscriber<Void>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(Void aVoid) {
                dismissLoadingDialog();
                ToastUtil.showSuccessToast(R.string.withdraw_success);
                cn.pocketwallet.pocketwallet.ui.activity.common.WithdrawActivity.this.finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_BANK_BRANCH && resultCode == Activity.RESULT_OK) {
            String bankBranchName = data.getStringExtra("bankBranchName");
            if (!TextUtils.isEmpty(bankBranchName)) {
                withdrawBankBranchTextView.setTextColor(Color.parseColor("#333333"));
                withdrawBankBranchTextView.setText(bankBranchName);
            }
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
