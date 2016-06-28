package com.example.administrator.fragmenttext.ui.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.ui.activity.PlaceActivity;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/10 16:49
 * 修改人：WangQing
 * 修改时间：2016/3/10 16:49
 * 修改备注：
 */
public class CityFragment extends BaseFragment {
    private RecyclerView cityRecyclerView;
    private CityAdapter cityAdapter;
    String[] city = {"杭州市", "宁波市", "温州市", "嘉兴市", "湖州市", "绍兴市", "金华市", "舟山市", "台州市", "丽水市"};
    private AreaFragment areaFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_city, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        cityRecyclerView = (RecyclerView) view.findViewById(R.id.cityRecyclerView);
        cityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cityAdapter=new CityAdapter();
        cityRecyclerView.setAdapter(cityAdapter);

    }

    @Override
    protected void loadDate() {

    }

    class CityAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment_city, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.cityTextView.setText(city[position]);
            holder.cityTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PlaceActivity)(getActivity())).setCityVisibility(city[position]);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    areaFragment = new AreaFragment();
                    ft.replace(R.id.placeFrameLayout, areaFragment);
                    ft.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return city.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            cityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
        }
    }
}
