package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

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
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import rx.Subscriber;

/**
 * Created by liubo on 2015/11/25.
 */
public class TransactionDetailActivity extends BaseActivity {

    private static final String TAG = "TransactionDetailActivity";

    private static final int TYPE_FOOTER = 0x0001;
    private static final int TYPE_NORMAL = 0x0002;


    private static final int pageSize = 50;  //每次获取50个

    private RecyclerView transactionDetailRecyclerView;
    private SwipeRefreshLayout moneyRecordSwipeRefreshLayout;
    private View moneyRecordEmptyView;

    private boolean isLoading; //正在加载
    private boolean canLoadMore = true; //能否加载更多


    private List<MoneyRecordItemModel> list = new ArrayList<>();
    private int pageIndex = 1;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_transaction_detail);

        showLoadingDialog();

        moneyRecordSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.moneyRecordSwipeRefreshLayout);
        SwipeRefreshLayoutUtil.initStyle(moneyRecordSwipeRefreshLayout);

        moneyRecordEmptyView = findViewById(R.id.moneyRecordEmptyView);

        transactionDetailRecyclerView = (RecyclerView) findViewById(R.id.transactionDetailRecyclerView);
        transactionDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListeners() {
        moneyRecordSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        transactionDetailRecyclerView.addOnScrollListener(onScrollListener);
    }

    @Override
    protected void loadData() {
        transactionDetailRecyclerView.setAdapter(new TransactionDetailAdapter());
        getMoneyRecord(true, true);

    }

    private class TransactionDetailAdapter extends RecyclerView.Adapter {

        @Override
        public int getItemViewType(int position) {
            if (position == list.size()) {
                return TYPE_FOOTER;
            } else {
                return TYPE_NORMAL;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_FOOTER) {
                View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_loading, parent, false);
                return new FootHolder(root);
            } else {
                View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction_detail, parent, false);
                return new TransactionDetailItemHolder(root);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if (position == list.size()) {
                FootHolder vh = (FootHolder) holder;
                if (canLoadMore) {
                    vh.itemCircularProgressBar.setVisibility(View.VISIBLE);
                    vh.itemLoadingTextView.setText(R.string.just_a_moment_please);
                } else {
                    vh.itemLoadingTextView.setText(R.string.no_more_data);
                    vh.itemCircularProgressBar.setVisibility(View.GONE);
                }
            } else {
                TransactionDetailItemHolder vh = (TransactionDetailItemHolder) holder;

                MoneyRecordItemModel moneyRecordItemModel = list.get(position);

                vh.transactionDetailItemTime.setText(DateUtil.format(new Date(moneyRecordItemModel.getFlowDate()), DateUtil.TIME_PATTERN));
                vh.transactionDetailItemMoney.setText(String.format(getString(R.string.transaction_money_format), moneyRecordItemModel.getFlowAmount()));
                vh.transactionSwiftNum.setText(String.format(getString(R.string.transaction_swift_num), moneyRecordItemModel.getCfNo()));

                String type = "";
                switch (moneyRecordItemModel.getFlowType()) {
                    case CASH:
                        type = getResources().getString(R.string.take_now);
                        break;
                    case CONSUME:
                        type = getResources().getString(R.string.consumption);
                        break;
                    case REPAY:

                        type = getResources().getString(R.string.repayment);
                        break;
                    case POUNDAGE:

                        type = getResources().getString(R.string.handling_charge);
                        break;
                    case SERVICE:

                        type = getResources().getString(R.string.service_charge);
                        break;
                    case FINE_RATE:

                        type = getResources().getString(R.string.overdue_penalty);
                        break;
                    case LATE:

                        type = getResources().getString(R.string.late_management_fee);
                        break;
                    case BREAK:

                        type = getResources().getString(R.string.liquidated_damages);
                        break;
                    case BIND_CARD:

                        type = getResources().getString(R.string.tie_card_money);
                        break;
                    case RECHARGE:
                        type = getResources().getString(R.string.transaction_recharge);
                        break;
                    case WITHDRAW:
                        type = getResources().getString(R.string.transaction_drawing);
                        break;
                }
                vh.transactionDetailItemSource.setText(type);
            }

        }

        @Override
        public int getItemCount() {
            return list.size() > 0 ? list.size() + 1 : 0;
        }

        class TransactionDetailItemHolder extends RecyclerView.ViewHolder {

            final TextView transactionDetailItemSource;
            final TextView transactionDetailItemMoney;
            final TextView transactionDetailItemTime;
            final TextView transactionSwiftNum;

            public TransactionDetailItemHolder(View itemView) {
                super(itemView);
                transactionDetailItemSource = (TextView) itemView.findViewById(R.id.transactionDetailItemSource);
                transactionDetailItemMoney = (TextView) itemView.findViewById(R.id.transactionDetailItemMoney);
                transactionDetailItemTime = (TextView) itemView.findViewById(R.id.transactionDetailItemTime);
                transactionSwiftNum = (TextView) itemView.findViewById(R.id.transactionSwiftNum);
            }
        }

        class FootHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public CircularProgressBar itemCircularProgressBar;
            public TextView itemLoadingTextView;

            public FootHolder(View v) {
                super(v);
                rootView = v;
                itemCircularProgressBar = (CircularProgressBar) v.findViewById(R.id.itemCircularProgressBar);
                itemLoadingTextView = (TextView) v.findViewById(R.id.itemLoadingTextView);
            }
        }
    }

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getMoneyRecord(false, true);
        }
    };

    private void getMoneyRecord(boolean showLoadingDialog, final boolean pullDown) {
        if (showLoadingDialog) {
            showLoadingDialog();
        }
        LoanApi.getCapitalRecordList(pullDown ? 1 : pageIndex, pageSize, new Subscriber<CapitalRecordListModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ApiErrorUtil.handleError(e);
                dismissLoadingDialog();

                isLoading = false;
                canLoadMore = false;
                if (moneyRecordSwipeRefreshLayout.isRefreshing()) {
                    moneyRecordSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onNext(CapitalRecordListModel model) {
                if (model.getInfos().size() < pageSize) {
                    canLoadMore = false;
                }

                if (pullDown) {
                    list.clear();
                    list.addAll(model.getInfos());
                    pageIndex = 1;
                    if (list.size() > 0) {
                        moneyRecordEmptyView.setVisibility(View.GONE);
                    } else {
                        moneyRecordEmptyView.setVisibility(View.VISIBLE);
                    }
                } else {
                    list.addAll(model.getInfos());
                    if (list.size() > 0) {
                        moneyRecordEmptyView.setVisibility(View.GONE);
                        pageIndex++;
                    } else {
                        moneyRecordEmptyView.setVisibility(View.VISIBLE);
                    }
                    if (model.getInfos().size() == 0 && moneyRecordEmptyView.getVisibility() == View.GONE) {
                        canLoadMore = false;
                    } else {
                        pageIndex++;
                    }
                    isLoading = false;
                }
                transactionDetailRecyclerView.getAdapter().notifyDataSetChanged();
                dismissLoadingDialog();
                if (moneyRecordSwipeRefreshLayout.isRefreshing()) {
                    moneyRecordSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    /**
     * recyclerView滑动监听
     */
    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {

        private int totalItemCount;
        private int lastVisibleItem;
        private int visibleItemCount;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            totalItemCount = layoutManager.getItemCount();
            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            visibleItemCount = layoutManager.getChildCount();
            if (!isLoading && lastVisibleItem >= totalItemCount - 1 && totalItemCount > visibleItemCount) {
                if (!canLoadMore) {
                    return;
                } else {
                    isLoading = true;
                    getMoneyRecord(false, false);
                }
            }
        }
    };

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
