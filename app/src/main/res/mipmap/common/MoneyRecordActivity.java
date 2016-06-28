package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.LoanApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.CapitalRecordListModel;
import cn.pocketwallet.pocketwallet.model.MoneyRecordItemModel;
import cn.pocketwallet.pocketwallet.util.DateUtil;
import cn.pocketwallet.pocketwallet.util.SwipeRefreshLayoutUtil;
import cn.pocketwallet.pocketwallet.util.http.ApiErrorUtil;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonLoadingDialog;
import rx.Subscriber;

public class MoneyRecordActivity extends BaseActivity {

    private static final String TAG = "MoneyRecordActivity";

    private SwipeRefreshLayout moneyRecordSwipeRefreshLayout;
    private View moneyRecordEmptyView;
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private CommonLoadingDialog commonLoadingDialog;
    private RecyclerView moneyRecordRecyclerView;
    private ListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<MoneyRecordItemModel> list = new ArrayList<>();
    private int pageIndex = 1;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_money_record);
        commonLoadingDialog = new CommonLoadingDialog(cn.pocketwallet.pocketwallet.ui.activity.common.MoneyRecordActivity.this);
        moneyRecordEmptyView = findViewById(R.id.moneyRecordEmptyView);
        moneyRecordSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.moneyRecordSwipeRefreshLayout);
        moneyRecordSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        SwipeRefreshLayoutUtil.initStyle(moneyRecordSwipeRefreshLayout);
        moneyRecordRecyclerView = (RecyclerView) findViewById(R.id.moneyRecordRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        moneyRecordRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void setListeners() {
    }

    @Override
    protected void loadData() {
        listAdapter = new ListAdapter();
        moneyRecordRecyclerView.setAdapter(listAdapter);
        getMoneyRecord(true);
    }


    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getMoneyRecord(false);
        }
    };

    private void getMoneyRecord(boolean showLoadingDialog) {
        if (showLoadingDialog) {
            commonLoadingDialog.show();
        }
        int pageSize = 1000;
        LoanApi.getCapitalRecordList(pageIndex, pageSize, new Subscriber<CapitalRecordListModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                if (commonLoadingDialog != null && commonLoadingDialog.isShowing()) {
                    commonLoadingDialog.dismiss();
                }
            }

            @Override
            public void onNext(CapitalRecordListModel model) {
                list.clear();
                list.addAll(model.getInfos());
                if (pageIndex == 1) {
                    if (list.size() > 0) {
                        moneyRecordEmptyView.setVisibility(View.GONE);
                    } else {
                        moneyRecordEmptyView.setVisibility(View.VISIBLE);
                    }
                }
                listAdapter.notifyDataSetChanged();
                if (commonLoadingDialog != null && commonLoadingDialog.isShowing()) {
                    commonLoadingDialog.dismiss();
                }
                if (moneyRecordSwipeRefreshLayout.isRefreshing()) {
                    moneyRecordSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }


    class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_money_record, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MoneyRecordItemModel moneyRecordItemModel = list.get(position);
            String yearMonth = DateUtil.format(new Date(moneyRecordItemModel.getFlowDate()), DateUtil.YEAR_MONTH_PATTERN);
            String month = yearMonth;
            if (yearMonth.length() > 2) {
                month = yearMonth.substring(yearMonth.length() - 2, yearMonth.length()) + getString(R.string.month);
            }
            holder.moneyRecordItemDateHeaderTextView.setText(month);
            if (list.size() == 0) {
                holder.moneyRecordItemDateHeaderTextView.setVisibility(View.VISIBLE);
                holder.moneyRecordItemBottomLinearLayout.setVisibility(View.VISIBLE);
                holder.moneyRecordItemDateHeaderTextView.setText(month);
            }

            if (list.size() > 1) {
                if (position != 0) {
                    holder.moneyRecordItemOnceHeaderView.setVisibility(View.GONE);
                    String lastYearMonth = DateUtil.format(new Date(list.get(position - 1).getFlowDate()), DateUtil.YEAR_MONTH_PATTERN);
                    if (yearMonth.equals(lastYearMonth)) {
                        holder.moneyRecordItemDateHeaderTextView.setVisibility(View.GONE);
                    } else {
                        holder.moneyRecordItemDateHeaderTextView.setVisibility(View.VISIBLE);
                        holder.moneyRecordItemDateHeaderTextView.setText(month);
                    }
                } else {
                    holder.moneyRecordItemOnceHeaderView.setVisibility(View.VISIBLE);
                    holder.moneyRecordItemDateHeaderTextView.setVisibility(View.VISIBLE);
                    holder.moneyRecordItemDateHeaderTextView.setText(month);
                }

                if (position == list.size() - 1) {
                    holder.moneyRecordItemBottomLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    String nextYearMonth = DateUtil.format(new Date(list.get(position + 1).getFlowDate()), DateUtil.YEAR_MONTH_PATTERN);
                    if (yearMonth.equals(nextYearMonth)) {
                        holder.moneyRecordItemBottomLinearLayout.setVisibility(View.GONE);
                    } else {
                        holder.moneyRecordItemBottomLinearLayout.setVisibility(View.VISIBLE);
                    }
                }

            }


            holder.moneyRecordItemDateTextView.setText(DateUtil.format(new Date(list.get(position).getFlowDate()), DateUtil.TIME_PATTERN));
            holder.moneyRecordItemIdTextView.setText(getString(R.string.serial_number) + moneyRecordItemModel.getCfNo());

            String flowType = "";
            holder.moneyRecordItemAmountTextView.setTextColor(ContextCompat.getColor(cn.pocketwallet.pocketwallet.ui.activity.common.MoneyRecordActivity.this, R.color.theme_color));
            switch (moneyRecordItemModel.getFlowType()) {
                case CASH:
                    flowType = getResources().getString(R.string.take_now);
                    break;
                case CONSUME:
                    flowType = getResources().getString(R.string.consumption);
                    break;
                case REPAY:

                    flowType = getResources().getString(R.string.repayment);
                    break;
                case POUNDAGE:

                    flowType = getResources().getString(R.string.handling_charge);
                    break;
                case SERVICE:

                    flowType = getResources().getString(R.string.service_charge);
                    break;
                case FINE_RATE:

                    flowType = getResources().getString(R.string.overdue_penalty);
                    break;
                case LATE:

                    flowType = getResources().getString(R.string.late_management_fee);
                    break;
                case BREAK:

                    flowType = getResources().getString(R.string.liquidated_damages);
                    break;
                case BIND_CARD:

                    flowType = getResources().getString(R.string.tie_card_money);
                    break;
            }

            holder.moneyRecordItemAmountTextView.setText(flowType + decimalFormat.format(moneyRecordItemModel.getFlowAmount()));
        }


        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public View moneyRecordItemOnceHeaderView;
        public TextView moneyRecordItemIdTextView;
        public TextView moneyRecordItemAmountTextView;
        public TextView moneyRecordItemDateHeaderTextView;
        public LinearLayout moneyRecordItemBottomLinearLayout;
        public TextView moneyRecordItemDateTextView;

        public ViewHolder(View v) {
            super(v);
            rootView = v;
            moneyRecordItemOnceHeaderView = v.findViewById(R.id.moneyRecordItemOnceHeaderView);
            moneyRecordItemAmountTextView = (TextView) v.findViewById(R.id.moneyRecordItemAmountTextView);
            moneyRecordItemIdTextView = (TextView) v.findViewById(R.id.moneyRecordItemIdTextView);
            moneyRecordItemDateHeaderTextView = (TextView) v.findViewById(R.id.moneyRecordItemDateHeaderTextView);
            moneyRecordItemBottomLinearLayout = (LinearLayout) v.findViewById(R.id.moneyRecordItemBottomLinearLayout);
            moneyRecordItemDateTextView = (TextView) v.findViewById(R.id.moneyRecordItemDateTextView);
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
