package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.CallBack1;
import com.example.administrator.fragmenttext.base.LoadData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/12 17:42
 * 修改人：WangQing
 * 修改时间：2016/1/12 17:42
 * 修改备注：
 */
public class CallbackActivity extends BaseActivity implements CallBack1{
    private RecyclerView recycleView;
    public LoadData loadData;
    CallBackAdapter callBackAdapter;
    private String path="http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=0";
    List<HashMap<String, String>> mylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public CallbackActivity(LoadData loadData){
        this.loadData=loadData;
    }
    /*public void loading(){
        LoadData.LoadingData(path,CallbackActivity.this);
    }*/

    @Override
    public void result(List<HashMap<String, String>> list) {
        mylist=list;
    }


    @Override
    protected void initView() {
        setContentView(R.layout.activity_callback);
        recycleView=(RecyclerView)findViewById(R.id.recycleView);
       recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    class CallBackAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(CallbackActivity.this).inflate(R.layout.item_my_network,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.name.setText(mylist.get(position).get("salesMan").toString());
            holder.network.setText(mylist.get(position).get("sn").toString());
            holder.audit.setText(mylist.get(position).get("stn").toString());
            holder.time.setText(mylist.get(position).get("t").toString());
        }

        @Override
        public int getItemCount() {
            return mylist.size();
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView network;
        private TextView audit;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            network = (TextView) itemView.findViewById(R.id.network);
            audit = (TextView) itemView.findViewById(R.id.audit);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
