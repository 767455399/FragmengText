package com.example.administrator.fragmenttext.ui.fragment;

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

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/10 16:51
 * 修改人：WangQing
 * 修改时间：2016/3/10 16:51
 * 修改备注：
 */
public class AreaFragment extends BaseFragment {
    private RecyclerView areaRecyclerView;
    private AreaAdapter areaAdapter;
    String[] area = {"上城区", "下城区", "江干区", "拱墅区", "西湖区", "滨江区", "萧山区", "余杭区", "桐庐县", "富阳区", "建德市", "淳安县"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_area, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        areaRecyclerView = (RecyclerView) view.findViewById(R.id.areaRecyclerView);
        areaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        areaAdapter=new AreaAdapter();
        areaRecyclerView.setAdapter(areaAdapter);
    }

    @Override
    protected void loadDate() {

    }

    class AreaAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment_area, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.areaTextView.setText(area[position]);
        }

        @Override
        public int getItemCount() {
            return area.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView areaTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            areaTextView = (TextView) itemView.findViewById(R.id.areaTextView);
        }
    }
}
