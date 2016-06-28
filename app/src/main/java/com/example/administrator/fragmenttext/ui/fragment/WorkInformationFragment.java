package com.example.administrator.fragmenttext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/16 18:45
 * 修改人：WangQing
 * 修改时间：2015/12/16 18:45
 * 修改备注：
 */
public class WorkInformationFragment extends BaseFragment {
    private List<Map<String, Object>> data;
    private View view;
    private RecyclerView withdrawalRecordRecyclerView;
    private WorkInformationAdapter workInformationAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_work_information, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        withdrawalRecordRecyclerView = (RecyclerView) view.findViewById(R.id.withdrawalRecordRecyclerView);
        withdrawalRecordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void loadDate() {
        workInformationAdapter = new WorkInformationAdapter();
        withdrawalRecordRecyclerView.setAdapter(workInformationAdapter);
        data = getData();
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<String, Object>();
            map.put("productName", "云南白药");
            map.put("specifications", "1.5cmx2.3cmx6");
            map.put("function", "止血，镇痛，消炎，愈创。用于小面积开放性创伤。");
            map.put("price", "6.5元");
            list.add(map);
        }
        return list;
    }

    class WorkInformationAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_information, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //图像处理
            holder.productNameTextView.setText(data.get(position).get("productName").toString());
            holder.functionTextView.setText(data.get(position).get("function").toString());
            holder.priceTextView.setText(data.get(position).get("price").toString());
            holder.specificationsTextView.setText(data.get(position).get("specifications").toString());
            Picasso.with(getActivity()).load("http://g.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917914baed1cd3d70cf3ac7578a.jpg").into(holder.productImageImageView);
            holder.itemLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productNameTextView;
        private LinearLayout itemLinearLayout;
        private ImageView productImageImageView;
        private TextView specificationsTextView;
        private TextView functionTextView;
        private TextView priceTextView;
        private ImageView shoppingCartImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemLinearLayout = (LinearLayout) itemView.findViewById(R.id.itemLinearLayout);
            productNameTextView = (TextView) itemView.findViewById(R.id.productNameTextView);
            productImageImageView = (ImageView) itemView.findViewById(R.id.productImageImageView);
            specificationsTextView = (TextView) itemView.findViewById(R.id.specificationsTextView);
            functionTextView = (TextView) itemView.findViewById(R.id.functionTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
            shoppingCartImageView = (ImageView) itemView.findViewById(R.id.shoppingCartImageView);
        }
    }
}
