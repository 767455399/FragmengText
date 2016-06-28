package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import com.example.administrator.fragmenttext.model.MyNetWorkModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.adapter.SwipeRefreshLayoutUtil;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/7 15:46
 * 修改人：WangQing
 * 修改时间：2016/1/7 15:46
 * 修改备注：
 */
public class MyNetworkActivity extends BaseActivity {
    private List<MyNetWorkModle.ListEntity> myList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyNetWorkAdapter myNetWorkAdapter;
    private SwipeRefreshLayout myNetWorkSwipeRefreshLayout;
/*
    List<HashMap<String, String>> list = new ArrayList<>();
*/
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                dismissLoadDialog();
                String result = msg.obj.toString();
                MyNetWorkModle myNetWorkModle1 = new Gson().fromJson(result, MyNetWorkModle.class);
                myList.addAll(myNetWorkModle1.getList());
                myNetWorkAdapter.notifyDataSetChanged();
       //       recyclerView.setAdapter(myNetWorkAdapter);
            } else {
                if (myNetWorkSwipeRefreshLayout.isRefreshing()) {
                    myNetWorkSwipeRefreshLayout.setRefreshing(false);
                }
                ToastUtil.showWarningToast("获取数据失败", MyNetworkActivity.this);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_network);
        showLoadingDialog();
        if(DeviceUtil.isOnline(MyNetworkActivity.this)){
            new Thread(new MyThread()).start();
        }else{
            ToastUtil.showWarningToast("请检查网络是否连接",MyNetworkActivity.this);
        }
        myNetWorkSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.myNetWorkSwipeRefreshLayout);
        //设置下拉刷新进度条的颜色
        SwipeRefreshLayoutUtil.initStyle(myNetWorkSwipeRefreshLayout);
        myNetWorkSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            myList.clear();
           /* getMyNetWork();*/
            if(DeviceUtil.isOnline(MyNetworkActivity.this)){
                new Thread(new MyThread()).start();
            }else{
                ToastUtil.showWarningToast("请检查网络是否连接",MyNetworkActivity.this);
            }

          //  showLoadingDialog();
        }
    };

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        myNetWorkAdapter = new MyNetWorkAdapter();
        recyclerView.setAdapter(myNetWorkAdapter);
       /* getMyNetWork();*/
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    public class MyNetWorkAdapter extends RecyclerView.Adapter<ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MyNetworkActivity.this).inflate(R.layout.item_my_network, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final MyNetWorkModle.ListEntity netWorkModle = myList.get(position);
            holder.name.setText(netWorkModle.getSalesMan());
            holder.network.setText(netWorkModle.getSn());
            holder.time.setText(netWorkModle.getT());
            holder.audit.setText(netWorkModle.getStn());
            if (myNetWorkSwipeRefreshLayout.isRefreshing()) {
                myNetWorkSwipeRefreshLayout.setRefreshing(false);
            }
          /*holder.name.setText(list.get(position).get("salesMan").toString());
            holder.network.setText(list.get(position).get("sn").toString());
            holder.audit.setText(list.get(position).get("stn").toString());
            holder.time.setText(list.get(position).get("t").toString());*/
        }

        @Override
        public int getItemCount() {
            return myList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        /*     private View view;*/
        private TextView name;
        private TextView network;
        private TextView audit;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
          /*  view=itemView;*/
            name = (TextView) itemView.findViewById(R.id.name);
            network = (TextView) itemView.findViewById(R.id.network);
            audit = (TextView) itemView.findViewById(R.id.audit);
            time = (TextView) itemView.findViewById(R.id.time);

        }
    }

    /*private void getMyNetWork() {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=0")
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if(myNetWorkSwipeRefreshLayout.isRefreshing()){
                    myNetWorkSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                String htmlStr = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(htmlStr);
                    Boolean aa=jsonObject.getBoolean("success");
                    String  total=jsonObject.getString("total");
                    JSONArray jsonArray = jsonObject.getJSONArray("list");
                    *//*这行代码一定要写在里面，不然生成的数据会全部展示最后一条
                    HashMap<String, String> item = new HashMap<String, String>();（错误写法）*//*
                    for (int i = 0; i < jsonArray.length(); i++) {
                        HashMap<String, String> item = new HashMap<String, String>();
                        JSONObject object = jsonArray.getJSONObject(i);
                        item.put("sn", object.getString("sn"));
                        item.put("stn", object.getString("stn"));
                        item.put("t", object.getString("t"));
                        item.put("salesMan", object.getString("salesMan"));
                        list.add(item);
                    }
                    //由于数据的请求是在子线程中进行的，而更新UI界面是需要在主线程中更新的，所以要将线程切换到主线程中；
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.getAdapter().notifyDataSetChanged();
                            if(myNetWorkSwipeRefreshLayout.isRefreshing()){
                                myNetWorkSwipeRefreshLayout.setRefreshing(false);
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }*/

    @Override
    protected void onResume() {
        super.onResume();
    }

    public class MyThread implements Runnable {

        @Override
        public void run() {

                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url("http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=0")
                        .build();
                //new call
                Call call = mOkHttpClient.newCall(request);
                //请求加入调度
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        dismissLoadDialog();
                        if (myNetWorkSwipeRefreshLayout.isRefreshing()) {
                            myNetWorkSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException {
                        dismissLoadDialog();
                        String htmlStr = response.body().string();
                        Message message = Message.obtain();
                        message.obj = htmlStr;
                        message.what = 1;
                        handler.sendMessage(message);
                    }
                });


        }
    }
    private void loadMore(int pageIndex){
        String path="http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=";
        path=path+pageIndex;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
