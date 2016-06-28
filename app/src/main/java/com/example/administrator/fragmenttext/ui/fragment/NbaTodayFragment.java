package com.example.administrator.fragmenttext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.NbaEventModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/29 12:44
 * 修改人：WangQing
 * 修改时间：2016/1/29 12:44
 * 修改备注：
 */
public class NbaTodayFragment extends Fragment {
    private String path = "http://api.avatardata.cn/Nba/NomalRace?key=b346c49e01ed4354ae2e7374afe79e30";
    private View view;
    private RecyclerView nbaTodayRecyclerView;
    private NbaTodayAdapter nbaTodayAdapter;
    private List<NbaEventModle.ResultEntity.ListEntity.TrEntity> nbaTodayList = new ArrayList<>();
    private View nullAddressMessage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nba_today, container, false);
        initView();
        return view;
    }

    private void initView() {
        nullAddressMessage=view.findViewById(R.id.nullAddressMessage);
        nullAddressMessage.setVisibility(View.GONE);
        nbaTodayRecyclerView = (RecyclerView)view.findViewById(R.id.nbaTodayRecyclerView);
        nbaTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        nbaTodayAdapter = new NbaTodayAdapter();
        nbaTodayRecyclerView.setAdapter(nbaTodayAdapter);
        getData();
    }



    private void getData() {
        if (DeviceUtil.isOnline(getActivity())) {
            NetWork.getNbaEvent(path, new myCallBack<NbaEventModle>() {
                @Override
                public void Success(NbaEventModle myNbaEventModle) {
                    if(null!=myNbaEventModle.getResult()&&null!=myNbaEventModle.getResult().getList().get(1).getTr()){
                        nbaTodayList.clear();
                        nbaTodayList.addAll(myNbaEventModle.getResult().getList().get(1).getTr());
                        nbaTodayAdapter.notifyDataSetChanged();
                    }else{
                        nullAddressMessage.setVisibility(View.VISIBLE);
                    }

                }

                @Override
                public void Fail(String fail) {
                    ToastUtil.showWarningToast(getString(R.string.failed_to_get_data), getActivity());
                }
            });
        } else {
            ToastUtil.showWarningToast(getString(R.string.please_check_the_network), getActivity());
        }

    }

    class NbaTodayAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_nba_today, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final NbaEventModle.ResultEntity.ListEntity.TrEntity nbaTodayModle = nbaTodayList.get(position);
            holder.TodayteamTimeTextView.setText(nbaTodayModle.getTime());
            Picasso.with(getActivity()).load(nbaTodayModle.getPlayer1logo()).placeholder(R.drawable.b)
                    .error(R.drawable.c).into(holder.TodayhomeTeamImageView);
            holder.TodayhomeTeamTextView.setText(nbaTodayModle.getPlayer1());
            holder.TodayteamScoreTextView.setText(nbaTodayModle.getScore());
            holder.TodayvisitingTeamTextView.setText(nbaTodayModle.getPlayer2());
            Picasso.with(getActivity()).load(nbaTodayModle.getPlayer2logo())
                    .error(R.drawable.c).placeholder(R.drawable.b)
                    .into(holder.TodayvisitingTeamImageView);
        }

        @Override
        public int getItemCount() {
            return nbaTodayList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TodayteamTimeTextView;
        private TextView TodayhomeTeamTextView;
        private TextView TodayvisitingTeamTextView;
        private TextView TodayteamScoreTextView;
        private ImageView TodayhomeTeamImageView;
        private ImageView TodayvisitingTeamImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            TodayteamTimeTextView = (TextView) itemView.findViewById(R.id.TodayteamTimeTextView);
            TodayhomeTeamTextView = (TextView) itemView.findViewById(R.id.TodayhomeTeamTextView);
            TodayvisitingTeamTextView = (TextView) itemView.findViewById(R.id.TodayvisitingTeamTextView);
            TodayteamScoreTextView = (TextView) itemView.findViewById(R.id.TodayteamScoreTextView);
            TodayhomeTeamImageView = (ImageView) itemView.findViewById(R.id.TodayhomeTeamImageView);
            TodayvisitingTeamImageView = (ImageView) itemView.findViewById(R.id.TodayvisitingTeamImageView);
        }
    }
}
