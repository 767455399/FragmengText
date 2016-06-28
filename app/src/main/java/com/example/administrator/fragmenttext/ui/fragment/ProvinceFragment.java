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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/10 16:24
 * 修改人：WangQing
 * 修改时间：2016/3/10 16:24
 * 修改备注：
 */
public class ProvinceFragment extends BaseFragment {
    private View view;
    private RecyclerView provinceRecyclerView;
    private ProvinceAdapter provinceAdapter;
    private CityFragment cityFragment;
    String[] province = {"湖北","北京","湖南","江西","安徽","河南","黑龙江","内蒙古","甘肃","四川","北京","湖南","江西","安徽","河南","黑龙江","内蒙古","甘肃","四川"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_province, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        provinceRecyclerView=(RecyclerView)view.findViewById(R.id.provinceRecyclerView);
        provinceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        provinceAdapter=new ProvinceAdapter();
        provinceRecyclerView.setAdapter(provinceAdapter);

    }

    @Override
    protected void loadDate() {

    }
    class ProvinceAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view1=LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment_province,parent,false);
            return new ViewHolder(view1);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.provinceTextView.setText(province[position]);
            holder.provinceTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PlaceActivity)(getActivity())).setProvinceVisibility(province[position]);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    cityFragment = new CityFragment();
                    ft.replace(R.id.placeFrameLayout, cityFragment);
                    ft.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return province.length;
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView provinceTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            provinceTextView=(TextView)itemView.findViewById(R.id.provinceTextView);
        }
    }
}
