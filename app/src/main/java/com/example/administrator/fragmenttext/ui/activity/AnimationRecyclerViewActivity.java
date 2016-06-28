package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnimationRecyclerViewActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private  AnimationRecyclerViewAdapter animationRecyclerViewAdapter;
    private List<HashMap<String,String>>list=new ArrayList<>();
    List clickedList=new ArrayList();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_animation_recycler_view);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        animationRecyclerViewAdapter=new AnimationRecyclerViewAdapter();
        recyclerView.setAdapter(animationRecyclerViewAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        for(int i=0;i<20;i++){
            HashMap<String,String>map=new HashMap<String,String>();
            map.put("name","张三李四");
            map.put("gender","男");
            map.put("age",String.valueOf(i));
            map.put("school","湖北大学");
            map.put("major","应用电子技术");
            map.put("occupation","android开发");
            list.add(map);
        }

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    class AnimationRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(AnimationRecyclerViewActivity.this).inflate(R.layout.item_animation_recycler_view,parent,false);
             return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.name.setText(list.get(position).get("name"));
            holder.gender.setText(list.get(position).get("gender"));
            holder.age.setText(list.get(position).get("age"));
            holder.school.setText(list.get(position).get("school"));
            holder.major.setText(list.get(position).get("major"));
            holder.occupation.setText(list.get(position).get("occupation"));
           /* recyclerView的展示和隐藏效果；*/
            if(!clickedList.contains(String.valueOf(position))){
                holder.telescopicLinearLayout.setVisibility(View.GONE);
            }else{
                holder.telescopicLinearLayout.setVisibility(View.VISIBLE);
            }
            holder.mainLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickedList.contains(String.valueOf(position))){
                        clickedList.remove(String.valueOf(position));
                        holder.telescopicLinearLayout.setVisibility(View.GONE);
                    }else{
                        clickedList.add(String.valueOf(position));
                        holder.telescopicLinearLayout.setVisibility(View.VISIBLE);
                    }
                    /*recyclerView的动画效果*/
                      recyclerView.getAdapter().notifyItemChanged(position);
                      recyclerView.getAdapter().notifyItemMoved(position,position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public static boolean useList(List arr, int targetValue) {

           return Arrays.asList(arr).contains(targetValue);

        }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView gender;
        private TextView age;
        private TextView school;
        private TextView major;
        private TextView occupation;
        private LinearLayout mainLinearLayout;
        private LinearLayout telescopicLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            gender=(TextView)itemView.findViewById(R.id.gender);
            age=(TextView)itemView.findViewById(R.id.age);
            school=(TextView)itemView.findViewById(R.id.school);
            major=(TextView)itemView.findViewById(R.id.major);
            occupation=(TextView)itemView.findViewById(R.id.occupation);
            mainLinearLayout=(LinearLayout)itemView.findViewById(R.id.mainLinearLayout);
            telescopicLinearLayout=(LinearLayout)itemView.findViewById(R.id.telescopicLinearLayout);
        }
    }


}
