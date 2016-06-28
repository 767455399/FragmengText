package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.FundApi;
import cn.pocketwallet.pocketwallet.api.RepayApi;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.cache.TokenCache;
import cn.pocketwallet.pocketwallet.model.AdvanceRepayWarningModel;
import cn.pocketwallet.pocketwallet.model.LoanOrderDetailModel;
import cn.pocketwallet.pocketwallet.model.LoanOrderStageItemModel;
import cn.pocketwallet.pocketwallet.model.LoanOrderStageListModel;
import cn.pocketwallet.pocketwallet.model.OrderPreferentialInfoModel;
import cn.pocketwallet.pocketwallet.service.LoanService;
import cn.pocketwallet.pocketwallet.util.DateUtil;
import cn.pocketwallet.pocketwallet.util.SwipeRefreshLayoutUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.util.http.HttpClient;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonDialog;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class OrderDetailActivity extends BaseActivity {

    private static final String PARAM_BORROW_ID = "borrowId";

    private SwipeRefreshLayout orderDetailSwipeRefreshLayout;

    private LinearLayout orderDetailRootLinearLayout;
    private LinearLayout orderDetailStageListLinearLayout;

    private Button orderDetailRepayButton;
    private Button orderDetailAdvanceRepayButton;

    private TextView orderDetailBorrowIdTextView;
    private TextView orderDetailCurrentAmountTextView;
    private TextView orderDetailProgressTextView;
    private TextView orderDetailStatusTextView;
    private TextView orderDetailLoanAmountTextView;
    private TextView orderDetailLoanDateTextView;
    private TextView orderDetailCurrentCapitalTextView;
    private TextView orderDetailCurrentServiceTextView;
    private TextView orderDetailOverdueAmountTextView;
    private TextView orderDetailPreferentialTextView;

    private LoanOrderDetailModel loanOrderDetail;
    private OrderPreferentialInfoModel orderPreferentialInfo;

    private String borrowId;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_order_detail);
        borrowId = getIntent().getStringExtra(PARAM_BORROW_ID);
        orderDetailSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.orderDetailSwipeRefreshLayout);
        SwipeRefreshLayoutUtil.initStyle(orderDetailSwipeRefreshLayout);

        orderDetailRootLinearLayout = (LinearLayout) findViewById(R.id.orderDetailRootLinearLayout);
        orderDetailStageListLinearLayout = (LinearLayout) findViewById(R.id.orderDetailStageListLinearLayout);

        orderDetailRepayButton = (Button) findViewById(R.id.orderDetailRepayButton);
        orderDetailAdvanceRepayButton = (Button) findViewById(R.id.orderDetailAdvanceRepayButton);

        orderDetailBorrowIdTextView = (TextView) findViewById(R.id.orderDetailBorrowIdTextView);
        orderDetailCurrentAmountTextView = (TextView) findViewById(R.id.orderDetailCurrentAmountTextView);
        orderDetailProgressTextView = (TextView) findViewById(R.id.orderDetailProgressTextView);
        orderDetailStatusTextView = (TextView) findViewById(R.id.orderDetailStatusTextView);
        orderDetailLoanAmountTextView = (TextView) findViewById(R.id.orderDetailLoanAmountTextView);
        orderDetailLoanDateTextView = (TextView) findViewById(R.id.orderDetailLoanDateTextView);
        orderDetailCurrentCapitalTextView = (TextView) findViewById(R.id.orderDetailCurrentCapitalTextView);
        orderDetailCurrentServiceTextView = (TextView) findViewById(R.id.orderDetailCurrentServiceTextView);
        orderDetailOverdueAmountTextView = (TextView) findViewById(R.id.orderDetailOverdueAmountTextView);
        orderDetailPreferentialTextView = (TextView) findViewById(R.id.orderDetailPreferentialTextView);

    }

    @Override
    protected void setListeners() {
        findViewById(R.id.orderDetailAgreementLinearLayout).setOnClickListener(listener);
        orderDetailRepayButton.setOnClickListener(listener);
        orderDetailAdvanceRepayButton.setOnClickListener(listener);
        orderDetailSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }

    @Override
    protected void loadData() {
        orderDetailBorrowIdTextView.setText(String.format(getString(R.string.order_no_format), borrowId));
        getOrderDetail(true);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.orderDetailAgreementLinearLayout) {
                String url = Urls.LOAN_AGREEMENT_URL + "?token=" + TokenCache.getToken() + "&borrowId=" + borrowId;
                startActivity(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.getWebViewActivityIntent(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this, url, getString(R.string.loan_agreement), false));
            }
            if (v.getId() == R.id.orderDetailRepayButton) {
                FundApi.normalRepay(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this, borrowId);
            }
            if (v.getId() == R.id.orderDetailAdvanceRepayButton) {
                showAdvanceRepayWarning(borrowId);
            }
        }
    };

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getOrderDetail(false);
        }
    };

    private void getOrderDetail(boolean showLoadingDialog) {
        if (showLoadingDialog) {
            showLoadingDialog();
        }
        final Retrofit fundRetrofit = new Retrofit.Builder()
                .client(HttpClient.getInstance())
                .baseUrl(Urls.FUND_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<LoanOrderDetailModel> observable = fundRetrofit.create(LoanService.class).getLoanOrderDetail(borrowId);
        observable.flatMap(new Func1<LoanOrderDetailModel, Observable<OrderPreferentialInfoModel>>() {
            @Override
            public Observable<OrderPreferentialInfoModel> call(LoanOrderDetailModel loanOrderDetailModel) {
                loanOrderDetail = loanOrderDetailModel;
                return fundRetrofit.create(LoanService.class).getOrderPreferentialInfo(borrowId);
            }
        }).flatMap(new Func1<OrderPreferentialInfoModel, Observable<LoanOrderStageListModel>>() {
            @Override
            public Observable<LoanOrderStageListModel> call(OrderPreferentialInfoModel orderPreferentialInfoModel) {
                orderPreferentialInfo = orderPreferentialInfoModel;
                return fundRetrofit.create(LoanService.class).getLoanOrderStageDetail(borrowId);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoanOrderStageListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ApiErrorUtil.handleError(e);
                        dismissLoadingDialog();
                        if (orderDetailSwipeRefreshLayout.isRefreshing()) {
                            orderDetailSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onNext(LoanOrderStageListModel loanOrderStageListModel) {
                        viewBindData(loanOrderStageListModel);
                    }
                });
    }


    private void viewBindData(LoanOrderStageListModel loanOrderStageList) {
        String borrowDate = DateUtil.format(new Date(loanOrderDetail.getBorrowDate()), DateUtil.TIME_PATTERN);
        Double borrowAmount = loanOrderDetail.getBorrowAmount();

        orderDetailLoanAmountTextView.setText(String.format(getString(R.string.borrow_amount_format), borrowAmount));
        orderDetailLoanDateTextView.setText(String.format(getString(R.string.borrow_date_format), borrowDate));

        if (orderPreferentialInfo.getIsfree()) {
            orderDetailPreferentialTextView.setVisibility(View.VISIBLE);
            orderDetailPreferentialTextView.setText(orderPreferentialInfo.getFreeInterestDesc());
        } else {
            orderDetailPreferentialTextView.setVisibility(View.INVISIBLE);
        }

        int curNo = loanOrderStageList.getCurNo();
        int num = loanOrderStageList.getNum();
        orderDetailProgressTextView.setText(String.format(getString(R.string.current_total_period_format), curNo, num));
        orderDetailStageListLinearLayout.removeAllViews();
        List<LoanOrderStageItemModel> list = new ArrayList<>();
        list.clear();
        list.addAll(loanOrderStageList.getInfos());
        if (list.size() == 0) {
            return;
        }

        for (LoanOrderStageItemModel stageItem : list) {
            Double capitalAmount = stageItem.getCapitalAmount();
            Double serviceAmount = stageItem.getServiceAmount();
            int overdueDays = Math.abs(stageItem.getOverdueDays());
            boolean current = (stageItem.getNo() == curNo);


            View itemView = LayoutInflater.from(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this).inflate(R.layout.item_order_detail_stage, null);
            TextView stageDetailPeriodTextView = (TextView) itemView.findViewById(R.id.stageDetailPeriodTextView);
            TextView stageDetailRepayDateTextView = (TextView) itemView.findViewById(R.id.stageDetailRepayDateTextView);
            TextView stageDetailRepayAmountTextView = (TextView) itemView.findViewById(R.id.stageDetailRepayAmountTextView);
            TextView stageDetailServiceAmountTextView = (TextView) itemView.findViewById(R.id.stageDetailServiceAmountTextView);
            TextView stageDetailStatusTextView = (TextView) itemView.findViewById(R.id.stageDetailStatusTextView);

            if (current) {
                orderDetailCurrentCapitalTextView.setText(String.format(getString(R.string.current_capital_format), capitalAmount));
                orderDetailCurrentServiceTextView.setText(String.format(getString(R.string.current_service_format), serviceAmount));
                orderDetailCurrentAmountTextView.setText(String.format(getString(R.string.double_format), stageItem.getPayAmount()));


                stageDetailPeriodTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                stageDetailRepayDateTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                stageDetailRepayAmountTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                stageDetailServiceAmountTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                stageDetailStatusTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                stageDetailPeriodTextView.setText(getString(R.string.current_period));
            } else {
                stageDetailPeriodTextView.setText(String.format(getString(R.string.int_format), stageItem.getNo()));
            }
            switch (stageItem.getRepayStatus()) {
                case OTHER:
                    if (current) {
                        orderDetailStatusTextView.setText(getString(R.string.other));
                        orderDetailRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailAdvanceRepayButton.setVisibility(View.INVISIBLE);
                    }
                    stageDetailStatusTextView.setText(getString(R.string.other));
                    break;
                case OVERDUE:
                    if (current) {
                        orderDetailStatusTextView.setText(String.format(getString(R.string.overdue_days_format_1), overdueDays));
                        orderDetailStatusTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_color));
                        orderDetailOverdueAmountTextView.setText(String.format(getString(R.string.overdue_amount_format), stageItem.getOverdueAmount()));
                        orderDetailOverdueAmountTextView.setVisibility(View.VISIBLE);
                    }
                    stageDetailStatusTextView.setText(getString(R.string.overdue));
                    break;
                case WAIT_PAY:
                    if (current) {
                        orderDetailStatusTextView.setText(String.format(getString(R.string.overdue_days_format_2), overdueDays));
                        orderDetailStatusTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_green_color));
                        orderDetailOverdueAmountTextView.setVisibility(View.GONE);
                    }
                    stageDetailStatusTextView.setText(getString(R.string.wait_repay));
                    break;
                case PAYING:
                    if (current) {
                        orderDetailStatusTextView.setText(getString(R.string.repaying));
                        orderDetailRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailAdvanceRepayButton.setVisibility(View.INVISIBLE);
                    }
                    stageDetailStatusTextView.setText(getString(R.string.repaying));
                    break;
                case STAGES:
                    if (current) {
                        orderDetailRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailAdvanceRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailStatusTextView.setText(getString(R.string.staged));
                        orderDetailStatusTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_green_color));
                        if (stageItem.getOverdueAmount() > 0) {
                            orderDetailOverdueAmountTextView.setVisibility(View.VISIBLE);
                            orderDetailOverdueAmountTextView.setText(String.format(getString(R.string.overdue_amount_format), stageItem.getOverdueAmount()));
                        } else {
                            orderDetailOverdueAmountTextView.setVisibility(View.GONE);
                        }
                    }
                    stageDetailStatusTextView.setText(getString(R.string.staged));
                    break;
                case PAID:
                    if (current) {
                        orderDetailRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailAdvanceRepayButton.setVisibility(View.INVISIBLE);
                        orderDetailStatusTextView.setText(getString(R.string.paid));
                        orderDetailStatusTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_green_color));
                        if (stageItem.getOverdueAmount() > 0) {
                            orderDetailOverdueAmountTextView.setVisibility(View.VISIBLE);
                            orderDetailOverdueAmountTextView.setText(String.format(getString(R.string.overdue_amount_format), stageItem.getOverdueAmount()));
                        } else {
                            orderDetailOverdueAmountTextView.setVisibility(View.GONE);
                        }
                    }
                    stageDetailStatusTextView.setText(getString(R.string.paid));
                    break;
            }
            stageDetailRepayDateTextView.setText(DateUtil.format(new Date(stageItem.getRepayEndDate()), DateUtil.DATE_PATTERN));
            stageDetailRepayAmountTextView.setText(String.format(getString(R.string.double_format), capitalAmount));
            stageDetailServiceAmountTextView.setText(String.format(getString(R.string.double_format), serviceAmount));
            orderDetailStageListLinearLayout.addView(itemView);
        }
        dismissLoadingDialog();
        if (orderDetailSwipeRefreshLayout.isRefreshing()) {
            orderDetailSwipeRefreshLayout.setRefreshing(false);
        }
    }


    private void showAdvanceRepayWarning(final String borrowId) {
        showLoadingDialog();
        RepayApi.getAdvanceRepayWarning(borrowId, new Subscriber<AdvanceRepayWarningModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();
            }

            @Override
            public void onNext(AdvanceRepayWarningModel advanceRepayWarningModel) {
                dismissLoadingDialog();
                if (TextUtils.isEmpty(advanceRepayWarningModel.getMsg())) {
                    FundApi.advanceRepay(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this, borrowId);
                    return;
                }
                final CommonDialog commonDialog = new CommonDialog(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this,
                        getString(R.string.sweet_note),
                        advanceRepayWarningModel.getMsg(), new CommonDialog.Listener() {
                    @Override
                    public void onLeftButtonClick() {

                    }

                    @Override
                    public void onRightButtonClick() {
                        FundApi.advanceRepay(cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.this, borrowId);
                    }
                });
                commonDialog.show();
            }
        });
    }


    public static void toOrderDetailActivity(Activity activity, String borrowId) {
        Intent intent = new Intent(activity, cn.pocketwallet.pocketwallet.ui.activity.common.OrderDetailActivity.class);
        intent.putExtra(PARAM_BORROW_ID, borrowId);
        activity.startActivity(intent);
    }


}
