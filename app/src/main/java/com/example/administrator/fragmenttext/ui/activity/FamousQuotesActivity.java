package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.Famous;
import com.example.administrator.fragmenttext.model.FamousQuotesModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.adapter.SwipeRefreshLayoutUtil;

import java.util.ArrayList;
import java.util.List;

public class FamousQuotesActivity extends BaseActivity implements View.OnClickListener {
    private EditText famousQuotesEditText;
    private Button famousQuotesSearchButton;
    private RecyclerView famousQuotesRecyclerView;
    private int page = 1;
    private int num = 10;
    public List<Famous> famousQuotesList = new ArrayList<>();
    private FamousQuotesAdapter famousQuotesAdapter;
    private SwipeRefreshLayout famousQuotesSwipeRefreshLayout;
    private Boolean isLoading=false;
    private Boolean haveNextPage=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Refresh();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_famous_quotes);
        famousQuotesEditText = (EditText) findViewById(R.id.famousQuotesEditText);
        famousQuotesSearchButton = (Button) findViewById(R.id.famousQuotesSearchButton);
        famousQuotesRecyclerView = (RecyclerView) findViewById(R.id.famousQuotesRecyclerView);
        famousQuotesRecyclerView.setLayoutManager(new LinearLayoutManager(FamousQuotesActivity.this));
        famousQuotesSearchButton.setOnClickListener(this);
        famousQuotesSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.famousQuotesSwipeRefreshLayout);
        SwipeRefreshLayoutUtil.initStyle(famousQuotesSwipeRefreshLayout);


    }

    @Override
    protected void setListener() {

    }

    protected void Refresh(){
        famousQuotesSwipeRefreshLayout.setOnRefreshListener(myOnRefreshListener);
        famousQuotesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manger=(LinearLayoutManager)recyclerView.getLayoutManager();
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    int lastVisibleItem=manger.findLastVisibleItemPosition();
                    int totalItemCount=manger.getItemCount();
                    if(lastVisibleItem==totalItemCount-1){
                        if(!isLoading&&haveNextPage){
                            loadMore();
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    SwipeRefreshLayout.OnRefreshListener myOnRefreshListener=new SwipeRefreshLayout.OnRefreshListener(){
        @Override
        public void onRefresh() {
            loadDate();
        }
    };

    @Override
    protected void loadDate() {
        page=1;
        famousQuotesAdapter = new FamousQuotesAdapter();
        famousQuotesRecyclerView.setAdapter(famousQuotesAdapter);
        String famousQuotes = famousQuotesEditText.getText().toString();
        String path = "http://api.avatardata.cn/MingRenMingYan/LookUp?key=971664cc1223444084716f2ff4d9b31b";
        if (!TextUtils.isEmpty(famousQuotes)) {
            if (DeviceUtil.isOnline(FamousQuotesActivity.this)) {
                NetWork.getFamousQuotes(path, famousQuotes, page, num, new myCallBack<FamousQuotesModle>() {
                    @Override
                    public void Success(FamousQuotesModle famousQuotesModle) {
                        if(famousQuotesList.size()>0){
                            famousQuotesList.clear();
                        }
                        if(famousQuotesSwipeRefreshLayout.isRefreshing()){
                            famousQuotesSwipeRefreshLayout.setRefreshing(false);
                        }
                        if((famousQuotesModle.getResult().size()<num)){
                            haveNextPage=false;
                        }else{
                            haveNextPage=true;
                        }
                        famousQuotesList.addAll(famousQuotesModle.getResult());
                        famousQuotesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void Fail(String fail) {
                        if(famousQuotesSwipeRefreshLayout.isRefreshing()){
                            famousQuotesSwipeRefreshLayout.setRefreshing(false);
                        }
                        ToastUtil.showWarningToast(getString(R.string.failed_to_get_data), FamousQuotesActivity.this);
                    }
                });

            } else {
                ToastUtil.showWarningToast(getString(R.string.please_check_the_network), FamousQuotesActivity.this);
            }
        } else {
            ToastUtil.showWarningToast("搜索内容不能为空", FamousQuotesActivity.this);
        }
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    protected void loadMore(){
        if(isLoading){
            return;
        }
        page++;
        String famousQuotes = famousQuotesEditText.getText().toString();
        String path = "http://api.avatardata.cn/MingRenMingYan/LookUp?key=971664cc1223444084716f2ff4d9b31b";
        if (!TextUtils.isEmpty(famousQuotes)) {
            if (DeviceUtil.isOnline(FamousQuotesActivity.this)) {
                NetWork.getFamousQuotes(path, famousQuotes, page, num, new myCallBack<FamousQuotesModle>() {
                    @Override
                    public void Success(FamousQuotesModle famousQuotesModle) {
                        if(famousQuotesSwipeRefreshLayout.isRefreshing()){
                            famousQuotesSwipeRefreshLayout.setRefreshing(false);
                        }
                        isLoading=false;
                        if((famousQuotesModle.getResult().size()<num)){
                           haveNextPage=false;
                        }else{
                            haveNextPage=true;
                        }
                        famousQuotesList.addAll(famousQuotesModle.getResult());
                        famousQuotesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void Fail(String fail) {
                        if(famousQuotesSwipeRefreshLayout.isRefreshing()){
                            famousQuotesSwipeRefreshLayout.setRefreshing(false);
                        }
                        ToastUtil.showWarningToast(getString(R.string.failed_to_get_data), FamousQuotesActivity.this);
                        isLoading=false;
                    }
                });

            } else {
                ToastUtil.showWarningToast(getString(R.string.please_check_the_network), FamousQuotesActivity.this);
            }
        } else {
            ToastUtil.showWarningToast("搜索内容不能为空", FamousQuotesActivity.this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.famousQuotesSearchButton:
                loadDate();
                break;
            default:
                break;
        }
    }

    class FamousQuotesAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(FamousQuotesActivity.this).inflate(R.layout.item_famous_quotes, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.author.setText(famousQuotesList.get(position).getFamousName());
            holder.well_known_saying.setText(famousQuotesList.get(position).getFamousSaying());
        }

        @Override
        public int getItemCount() {
            return famousQuotesList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView author;
        private TextView well_known_saying;

        public ViewHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.author);
            well_known_saying = (TextView) itemView.findViewById(R.id.well_known_saying);
        }
    }
}
