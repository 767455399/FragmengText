package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.SupermarketModle;

import java.util.ArrayList;
import java.util.List;

public class SupermarketActivity extends BaseActivity {
    private String path="http://www.jutongbao.com/jtb/phone/score_calShopOrProduct.action?companyCode=05710001&scoreType=7&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&yearMonthInfo=2015-01-01";
    private RecyclerView supermarketRecyclerView;
    private SupermarketAdapter supermarketAdapter;
    private List<List<String>>supermarketList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_supermarket);
        supermarketRecyclerView=(RecyclerView)findViewById(R.id.supermarketRecyclerView);
        supermarketRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        supermarketAdapter=new SupermarketAdapter();
        supermarketRecyclerView.setAdapter(supermarketAdapter);
        getDate();
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void getDate() {
        NetWork.getSupermarket(path, new myCallBack<SupermarketModle>() {
            @Override
            public void Success(SupermarketModle supermarketModle) {
                Boolean  success=supermarketModle.isSuccess();
                supermarketList.addAll(supermarketModle.getScoreList());
                supermarketAdapter.notifyDataSetChanged();
            }

            @Override
            public void Fail(String fail) {

            }
        });
    }

    class SupermarketAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(SupermarketActivity.this).inflate(R.layout.item_supermarket,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.supermarketName.setText(supermarketList.get(position).get(0).toString());
            holder.num.setText(supermarketList.get(position).get(1).toString());

        }

        @Override
        public int getItemCount() {
            return supermarketList.size();
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView supermarketName;
        private TextView num;
        public ViewHolder(View itemView) {
            super(itemView);
            supermarketName=(TextView)itemView.findViewById(R.id.supermarketName);
            num=(TextView)itemView.findViewById(R.id.num);
        }
    }


}
