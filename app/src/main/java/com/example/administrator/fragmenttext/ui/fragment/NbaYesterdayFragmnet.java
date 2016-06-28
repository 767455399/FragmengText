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
import com.example.administrator.fragmenttext.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;
import rx.Observable;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/29 12:43
 * 修改人：WangQing
 * 修改时间：2016/1/29 12:43
 * 修改备注：
 */
public class NbaYesterdayFragmnet extends Fragment {
    private String path = "http://api.avatardata.cn/Nba/NomalRace?key=b346c49e01ed4354ae2e7374afe79e30";
    private List<NbaEventModle.ResultEntity.ListEntity.TrEntity> nbaYesterdayList = new ArrayList<>();
    private View view;
    private NbaYesterdayAdapter nbaYesterdayAdapter;
    private RecyclerView nbaYesterdayRecyclerView;
    LoadingDialog loadingDialog;
    private View nullAddressMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nba_yesterday, container, false);
        initView();
        getData();
        return view;
    }

    private void initView() {
        loadingDialog=new LoadingDialog(getActivity());
        nbaYesterdayRecyclerView = (RecyclerView) view.findViewById(R.id.nbaYesterdayRecyclerView);
        nbaYesterdayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        nbaYesterdayAdapter = new NbaYesterdayAdapter();
        nbaYesterdayRecyclerView.setAdapter(nbaYesterdayAdapter);
        nullAddressMessage=view.findViewById(R.id.nullAddressMessage);
        nullAddressMessage.setVisibility(View.GONE);

    }

    private void getData() {
        if(!loadingDialog.isShowing()){
            loadingDialog.show();
        }

        if (DeviceUtil.isOnline(getActivity())) {
            NetWork.getNbaEvent(path, new myCallBack<NbaEventModle>() {
                @Override
                public void Success(NbaEventModle nbaEventModle) {
                    if(loadingDialog.isShowing()){
                        loadingDialog.dismiss();
                    }
                    if(nbaYesterdayList.size()>0){
                        nbaYesterdayList.clear();
                    }
                    if(null!=nbaEventModle.getResult()&&null!=nbaEventModle.getResult().getList().get(0).getTr()){
                        nbaYesterdayList.addAll(nbaEventModle.getResult().getList().get(0).getTr());
                        nbaYesterdayAdapter.notifyDataSetChanged();
                    }else{
                        nullAddressMessage.setVisibility(View.VISIBLE);
                    }

                }

                @Override
                public void Fail(String fail) {
                    ToastUtil.showWarningToast(getString(R.string.failed_to_get_data), getActivity());
                    if(loadingDialog.isShowing()){
                        loadingDialog.dismiss();
                    }
                }
            });
        } else {
            ToastUtil.showWarningToast(getString(R.string.please_check_the_network), getActivity());
        }
    }

    class NbaYesterdayAdapter extends RecyclerView.Adapter<ViewHolder> {
        View viewAdapter;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            viewAdapter = LayoutInflater.from(getActivity()).inflate(R.layout.item_nba_event, parent, false);
            return new ViewHolder(viewAdapter);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final NbaEventModle.ResultEntity.ListEntity.TrEntity nbaYesterdayModle = nbaYesterdayList.get(position);
            Picasso.with(getActivity()).load(nbaYesterdayModle.getPlayer1logo())
                    .error(R.drawable.c).placeholder(R.drawable.b).into(holder.homeTeamImageView);
            holder.homeTeamTextView.setText(nbaYesterdayModle.getPlayer1());
            holder.teamTimeTextView.setText(nbaYesterdayModle.getTime());
            Picasso.with(getActivity()).load(nbaYesterdayModle.getPlayer2logo())
                    .error(R.drawable.c).placeholder(R.drawable.b).into(holder.visitingTeamImageView);
            holder.visitingTeamTextView.setText(nbaYesterdayModle.getPlayer2());
            holder.teamScoreTextView.setText(nbaYesterdayModle.getScore());
        }

        @Override
        public int getItemCount() {
            return nbaYesterdayList.size();
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
