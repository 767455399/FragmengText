package com.example.administrator.fragmenttext.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.post.PostActivity;
import com.example.administrator.fragmenttext.ui.activity.HandleActivity;
import com.example.administrator.fragmenttext.ui.activity.ItemActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class HeaderViewRecyclerView extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<HashMap<String ,Object>>list=new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_header_view_recycler_view);
        getData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {

    }
    protected void getData(){
        for (int i=0;i<20;i++){
            HashMap<String,Object>map=new HashMap<>();
            map.put("zhangdan","账单"+i);
            map.put("haikuan","还款"+i);
            list.add(map);
        }
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter {
        public static final int ITEM_HEADER = 0;
        public static final int ITEM_RECORD = 1;
        public static final int ITEM_NO_RECORD = 2;
        public static final int ITEM_FOOTER=3;


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case ITEM_HEADER:
                    HeadViewHolder headViewHolder = new HeadViewHolder(LayoutInflater.from(HeaderViewRecyclerView.this).inflate(R.layout.head_recycler, parent, false));
                    return headViewHolder;
                case ITEM_RECORD:
                    RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(LayoutInflater.from(HeaderViewRecyclerView.this).inflate(R.layout.item_recyclerview, parent, false));
                    return recyclerViewHolder;
                case ITEM_NO_RECORD:
                    NoRecordHolder noRecordHolder = new NoRecordHolder(LayoutInflater.from(HeaderViewRecyclerView.this).inflate(R.layout.item_no_record, parent, false));
                    return noRecordHolder;
                case ITEM_FOOTER:
                    View view=LayoutInflater.from(HeaderViewRecyclerView.this).inflate(R.layout.footer_layout,parent,false);
                    return new FooterHolder(view);
                default:
                    return null;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if (holder instanceof HeadViewHolder) {
                HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                headViewHolder.availableCreditTextView.setText("可用额度：0.00元");
                headViewHolder.immediateWithdrawalButton.setText("立即还款");
                headViewHolder.viewDetailsButton.setText("查看详情");
                headViewHolder.immediateWithdrawalButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.setClass(HeaderViewRecyclerView.this, PostActivity.class);
                        startActivity(intent);
                    }
                });
                headViewHolder.viewDetailsButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.setClass(HeaderViewRecyclerView.this, HandleActivity.class);
                        startActivity(intent);
                    }
                });
            } else if (holder instanceof RecyclerViewHolder) {
                RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) holder;
                recyclerViewHolder.itemTextView.setText(list.get(position-1).get("zhangdan").toString());
                recyclerViewHolder.itemButton.setText(list.get(position-1).get("haikuan").toString());
                recyclerViewHolder.itemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.setClass(HeaderViewRecyclerView.this, ItemActivity.class);
                        Bundle bundleSimple = new Bundle();
                        bundleSimple.putString("text",list.get(position-1).get("zhangdan").toString());
                        intent.putExtras(bundleSimple);
                        startActivity(intent);
                    }
                });
            }else if(holder instanceof NoRecordHolder){
                NoRecordHolder noRecordHolder=(NoRecordHolder)holder;
                noRecordHolder.noRecordImageView.setVisibility(View.VISIBLE);
            }else if(holder instanceof FooterHolder){
                ((FooterHolder)holder).footerTextView.setVisibility(View.VISIBLE);
                ((FooterHolder)holder).footerTextView.setText("加载更多。。。。");
            }
        }

        @Override
        public int getItemCount() {
            return list.size() == 0 ? 2 :list.size() + 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return ITEM_HEADER;
            } else if (position==1&&list.size()==0) {
                return ITEM_NO_RECORD;
            } else if(position==list.size()+1){
                return ITEM_FOOTER;
            }else{
                return ITEM_RECORD;
            }
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        private Button viewDetailsButton;
        private TextView availableCreditTextView;
        private Button immediateWithdrawalButton;

        public HeadViewHolder(View itemView) {
            super(itemView);
            viewDetailsButton = (Button) itemView.findViewById(R.id.viewDetailsButton);
            availableCreditTextView = (TextView) itemView.findViewById(R.id.viewDetailsButton);
            immediateWithdrawalButton = (Button) itemView.findViewById(R.id.immediateWithdrawalButton);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private Button itemButton;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.itemTextView);
            itemButton = (Button) itemView.findViewById(R.id.itemButton);
        }
    }

    public class NoRecordHolder extends RecyclerView.ViewHolder {
        private ImageView noRecordImageView;

        public NoRecordHolder(View itemView) {
            super(itemView);
            noRecordImageView = (ImageView) itemView.findViewById(R.id.noRecordImageView);
        }
    }

    public class FooterHolder extends RecyclerView.ViewHolder{
        private TextView footerTextView;
        public FooterHolder(View itemView) {
            super(itemView);
            footerTextView=(TextView)itemView.findViewById(R.id.footerTextView);
        }
    }
}
