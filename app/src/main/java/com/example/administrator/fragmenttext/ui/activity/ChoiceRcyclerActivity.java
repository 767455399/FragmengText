package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChoiceRcyclerActivity extends BaseActivity {
    private RecyclerView recycleView;
    private ChoiceAdapter choiceAdapter;
    private List<Map<String, Object>> list = new ArrayList<>();


    @Override
    protected void initView() {
        setContentView(R.layout.activity_choice_rcycler);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        choiceAdapter = new ChoiceAdapter();
        recycleView.setAdapter(choiceAdapter);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < 10; i++) {
            map.put("xingming", "张三");
            map.put("neixing", "现代");
            list.add(map);
        }

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    class ChoiceAdapter extends RecyclerView.Adapter<ViewHolder> {
        private View selectedItem;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ChoiceRcyclerActivity.this).inflate(R.layout.item_choice_rcycler, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.xingmingTextView.setText(list.get(position).get("xingming").toString());
            holder.neixingTextView.setText(list.get(position).get("neixing").toString());
            if(Param.choice==position){
                holder.imageView.setVisibility(View.VISIBLE);
            }
            holder.relativelayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null==selectedItem){
                        selectedItem=holder.imageView;
                        holder.imageView.setVisibility(View.VISIBLE);
                    }else{
                        if(selectedItem==v){
                            return;
                        }else{
                            holder.imageView.setVisibility(View.INVISIBLE);
                            selectedItem.setVisibility(View.INVISIBLE);
                            selectedItem=holder.imageView;
                        }
                    }
                    selectedItem.setVisibility(View.VISIBLE);
                    Param.choice=position;
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView xingmingTextView;
        private TextView neixingTextView;
        private ImageView imageView;
        private RelativeLayout relativelayout;

        public ViewHolder(View itemView) {
            super(itemView);
            xingmingTextView = (TextView) itemView.findViewById(R.id.xingmingTextView);
            neixingTextView = (TextView) itemView.findViewById(R.id.neixingTextView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            relativelayout=(RelativeLayout)itemView.findViewById(R.id.relativelayout);
        }
    }
}
