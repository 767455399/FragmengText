package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    /*这里我们在布局里为ccardview添加了点击水波纹的效果，
    android:clickable="true"
    android:foreground="?attr/selectableItemBackground"
    但是只能在Android 6.0以上的系统才能起作用**/

public class CardViewActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private CardViewAdapter cardViewAdapter;
    private List<Map<String, Object>> myList = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_card_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardViewAdapter=new CardViewAdapter();
        recyclerView.setAdapter(cardViewAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("diyi", "第一栏");
            map.put("dier", "第二栏");
            myList.add(map);
        }
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    public class CardViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CardViewActivity.this).inflate(R.layout.item_card_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView1.setText(myList.get(position).get("diyi").toString());
            holder.textView2.setText(myList.get(position).get("dier").toString());
        }

        @Override
        public int getItemCount() {
            return myList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView1;
        private TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView1);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
