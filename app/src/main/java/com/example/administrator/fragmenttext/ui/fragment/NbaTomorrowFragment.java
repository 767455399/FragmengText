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
 * 创建时间：2016/1/29 12:45
 * 修改人：WangQing
 * 修改时间：2016/1/29 12:45
 * 修改备注：
 */
public class NbaTomorrowFragment extends Fragment {
    private String path = "http://api.avatardata.cn/Nba/NomalRace?key=b346c49e01ed4354ae2e7374afe79e30";
    private RecyclerView nbaTomorrowRecyclerView;
    private View view;
    private View nullAddressMessage;
    private NbaTomorrowAdapter nbaTomorrowAdapter;
    private List<NbaEventModle.ResultEntity.ListEntity.TrEntity> tomorrowGameList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nba_tomorrow, container, false);
        initView();
        loadData();
        return view;
    }

    private void loadData() {
        if (DeviceUtil.isOnline(getActivity())) {
            NetWork.getNbaEvent(path, new myCallBack<NbaEventModle>() {
                @Override
                public void Success(NbaEventModle nbaEventModle) {
                    tomorrowGameList.clear();
                    if(null!=nbaEventModle.getResult()&&null!=nbaEventModle.getResult().getList().get(2).getTr()){
                        tomorrowGameList.addAll(nbaEventModle.getResult().getList().get(2).getTr());
                        nbaTomorrowAdapter.notifyDataSetChanged();
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

    private void initView() {
        nbaTomorrowRecyclerView = (RecyclerView) view.findViewById(R.id.nbaTomorrowRecyclerView);
        nbaTomorrowRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        nbaTomorrowAdapter = new NbaTomorrowAdapter();
        nbaTomorrowRecyclerView.setAdapter(nbaTomorrowAdapter);
        nullAddressMessage=view.findViewById(R.id.nullAddressMessage);
        nullAddressMessage.setVisibility(View.GONE);
    }

    class NbaTomorrowAdapter extends RecyclerView.Adapter<ViewHolder> {
        View myView;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            myView = LayoutInflater.from(getActivity()).inflate(R.layout.item_nba_tomorrow, parent, false);
            return new ViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final NbaEventModle.ResultEntity.ListEntity.TrEntity tomorrowGameModle = tomorrowGameList.get(position);
            holder.tomorrowhomeTeamTextView.setText(tomorrowGameModle.getPlayer1());
            Picasso.with(getActivity()).load(tomorrowGameModle.getPlayer1logo())
                    .error(R.drawable.c).placeholder(R.drawable.b).into(holder.tomorrowTeamImageView);
            holder.tomorrowTeamScoreTextView.setText(tomorrowGameModle.getScore());
            holder.tomorrowVisitingTeamTextView.setText(tomorrowGameModle.getPlayer2());
            holder.tomorrowTeamTimeTextView.setText(tomorrowGameModle.getTime());
            Picasso.with(getActivity()).load(tomorrowGameModle.getPlayer2logo())
                    .error(R.drawable.c).placeholder(R.drawable.b).into(holder.tomorrowVisitingTeamImageView);
        }

        @Override
        public int getItemCount() {
            return tomorrowGameList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tomorrowTeamTimeTextView;
        private TextView tomorrowhomeTeamTextView;
        private TextView tomorrowTeamScoreTextView;
        private TextView tomorrowVisitingTeamTextView;
        private ImageView tomorrowTeamImageView;
        private ImageView tomorrowVisitingTeamImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tomorrowTeamTimeTextView = (TextView) itemView.findViewById(R.id.tomorrowTeamTimeTextView);
            tomorrowhomeTeamTextView = (TextView) itemView.findViewById(R.id.tomorrowhomeTeamTextView);
            tomorrowTeamScoreTextView = (TextView) itemView.findViewById(R.id.tomorrowTeamScoreTextView);
            tomorrowVisitingTeamTextView = (TextView) itemView.findViewById(R.id.tomorrowVisitingTeamTextView);
            tomorrowTeamImageView = (ImageView) itemView.findViewById(R.id.tomorrowTeamImageView);
            tomorrowVisitingTeamImageView = (ImageView) itemView.findViewById(R.id.tomorrowVisitingTeamImageView);
        }
    }
}
