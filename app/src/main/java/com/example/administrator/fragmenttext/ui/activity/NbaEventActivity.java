package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.DisplayStandardModle;
import com.example.administrator.fragmenttext.model.NbaEventModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

public class NbaEventActivity extends BaseActivity {
    private String path = "http://api.avatardata.cn/Nba/NomalRace?key=b346c49e01ed4354ae2e7374afe79e30";
    private RecyclerView nbaEventRecyclerView;
    private NbaEventAdapter nbaEventAdapter;
    private List<NbaEventModle.ResultEntity.ListEntity> nabList = new ArrayList<>();
    private List<NbaEventModle.ResultEntity.ListEntity.TrEntity> teamScoreList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_nba_event);
        nbaEventRecyclerView = (RecyclerView) findViewById(R.id.nbaEventRecyclerView);
        nbaEventRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        nbaEventAdapter = new NbaEventAdapter();
        nbaEventRecyclerView.setAdapter(nbaEventAdapter);
        getData();
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void getData() {
        if (DeviceUtil.isOnline(NbaEventActivity.this)) {
            NetWork.getNbaEvent(path, new myCallBack<NbaEventModle>() {
                @Override
                public void Success(NbaEventModle nbaEventModle) {
                    nabList.addAll(nbaEventModle.getResult().getList());
                    teamScoreList.addAll(nabList.get(0).getTr());
                    nbaEventAdapter.notifyDataSetChanged();
                }

                @Override
                public void Fail(String fail) {
                    ToastUtil.showWarningToast("数据加载失败", NbaEventActivity.this);
                }
            });
        } else {
            ToastUtil.showWarningToast("请检查网络", NbaEventActivity.this);
        }


    }

    class NbaEventAdapter extends RecyclerView.Adapter<ViewHolder> {
        private View view;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(NbaEventActivity.this).inflate(R.layout.item_nba_event, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final NbaEventModle.ResultEntity.ListEntity.TrEntity teamScoreModle = teamScoreList.get(position);
            holder.teamTimeTextView.setText(teamScoreModle.getTime());
            Picasso.with(NbaEventActivity.this).load(teamScoreModle.getPlayer1logo()).error(R.drawable.c)
                    .placeholder(R.drawable.b).into(holder.homeTeamImageView);
            holder.homeTeamTextView.setText(teamScoreModle.getPlayer1());
            holder.teamScoreTextView.setText(teamScoreModle.getScore());
            holder.visitingTeamTextView.setText(teamScoreModle.getPlayer2());
           Picasso.with(NbaEventActivity.this).load(teamScoreModle.getPlayer2logo()).error(R.drawable.c)
                   .placeholder(R.drawable.b).into(holder.visitingTeamImageView);
        }

        @Override
        public int getItemCount() {
            return teamScoreList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView homeTeamImageView;
        private TextView homeTeamTextView;
        private TextView teamScoreTextView;
        private TextView teamTimeTextView;
        private TextView visitingTeamTextView;
        private ImageView visitingTeamImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            homeTeamImageView = (ImageView) itemView.findViewById(R.id.homeTeamImageView);
            homeTeamTextView = (TextView) itemView.findViewById(R.id.homeTeamTextView);
            teamScoreTextView = (TextView) itemView.findViewById(R.id.teamScoreTextView);
            teamTimeTextView = (TextView) itemView.findViewById(R.id.teamTimeTextView);
            visitingTeamImageView = (ImageView) itemView.findViewById(R.id.visitingTeamImageView);
            visitingTeamTextView = (TextView) itemView.findViewById(R.id.visitingTeamTextView);

        }
    }
}
