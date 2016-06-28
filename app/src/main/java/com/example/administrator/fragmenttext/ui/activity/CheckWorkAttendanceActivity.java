package com.example.administrator.fragmenttext.ui.activity;

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
import com.example.administrator.fragmenttext.model.CheckWorkAttendanceModle;

import java.util.ArrayList;
import java.util.List;

public class CheckWorkAttendanceActivity extends BaseActivity {
    private String path = "http://www.jutongbao.com/jtb/phone/score_calShopRewardDetailInfoList.action?companyCode=05710001&uid=%E5%85%A8%E5%8B%A4%E5%A5%96%E9%87%91&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&yearMonthInfo=2015-01-06";
    /*{"leaveCount":null,"mainExpress":null,"saleAmount":null,"score":null,
            "scoreList":[[" ","旷工天数","0.0天","1",null,null],[" ","旷勤次数","0.0次","1",null,null],[" ","病假天数","0.0天","1",null,null],
        [" ","事假天数","0.0天","1",null,null]],"signErrorCount":null,"success":true,"uid":"全勤奖金","userName":null,"yearMonthInfo":"2015-01-06"}
    上面是服务器返回的数据，我们要获取scoreList中的数据，我们可以发现scoreList中的数据[" ","旷勤次数","0.0次","1",null,null]是数组形式，而且这种数据是无法生成modle的，
    而且他们是一字符串的形式存在，并不是我们键值对，所以我们可以将每个小数组当作一个list集合，很明显，list的集合应该为string形式，所以我们在下面新建的数组里面的参数为String*/
    private List<List<String>> checkWorkAttendanceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CheckWorkAttendanceAdapter checkWorkAttendanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_check_work_attendance);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        checkWorkAttendanceAdapter = new CheckWorkAttendanceAdapter();
        recyclerView.setAdapter(checkWorkAttendanceAdapter);
        getDate();


    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void getDate() {
        showLoadingDialog();
       /* 这里我们请求数据的接口里面的参数并没有什么变化，callback里面还是继续传递modle*/
        NetWork.getCheckWorkAttendance(path, new myCallBack<CheckWorkAttendanceModle>() {

            @Override
            public void Success(CheckWorkAttendanceModle checkWorkAttendanceModle) {
                dismissLoadDialog();
                /*这里我们已经将返回的数据以modle的形式获取到了，接下来要做的就是直接从modle里面取值*/
                String aaa=checkWorkAttendanceModle.getUid();
                String bbb=checkWorkAttendanceModle.getYearMonthInfo();
                Boolean ccc=checkWorkAttendanceModle.isSuccess();
               /* 这里我们获取list里面的数据还是跟往常一样*/
                checkWorkAttendanceList.addAll(checkWorkAttendanceModle.getScoreList());
                /*这里我们一定要刷新数据，不然数据无法展示*/
                checkWorkAttendanceAdapter.notifyDataSetChanged();
            }

            @Override
            public void Fail(String fail) {
                dismissLoadDialog();
            }

        });

    }

    public class CheckWorkAttendanceAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CheckWorkAttendanceActivity.this).inflate(R.layout.item_check_work_attendance, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
          /*  这里我们要先通过checkWorkAttendanceList.get(position)获取checkWorkAttendanceList里面的数组，然后通过get(1)来获取数组中的第几个数据*/
            holder.style.setText(checkWorkAttendanceList.get(position).get(1).toString());
            holder.num.setText(checkWorkAttendanceList.get(position).get(2).toString());
            holder.unit.setText(checkWorkAttendanceList.get(position).get(3).toString());
        }

        @Override
        public int getItemCount() {
            return checkWorkAttendanceList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView style;
        private TextView num;
        private TextView unit;

        public ViewHolder(View itemView) {
            super(itemView);
            style = (TextView) itemView.findViewById(R.id.style);
            num = (TextView) itemView.findViewById(R.id.num);
            unit = (TextView) itemView.findViewById(R.id.unit);
        }
    }
}
