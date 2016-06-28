package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.tools.JumpToTheTopPosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*recyclerview跳转到指定的位置；*/

public class JumpToTheTopPositionActivty extends BaseActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private JumpToTheTopPositionAdapter jumpToTheTopPositionAdapter;
    private List<Map<String, Object>> list = new ArrayList<>();
    int current;
    String currentVaule;
    public boolean move;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_jump_to_the_top_position_activty);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        jumpToTheTopPositionAdapter = new JumpToTheTopPositionAdapter();
        recyclerView.setAdapter(jumpToTheTopPositionAdapter);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String vaule=editText.getText().toString();
                if(!TextUtils.isEmpty(vaule)){
                    for(int x=0;x<list.size();x++){
                        currentVaule= String.valueOf(list.get(x).get("number").toString());
                        if(currentVaule.equals(vaule)){
                            current=x;
                           /* moveToPosition(x);*/
                            JumpToTheTopPosition jumpToTheTopPosition=new JumpToTheTopPosition();
                            jumpToTheTopPosition.moveToPosition(x,recyclerView);
                            break;
                        }

                    }
                }else{
                    ToastUtil.showWarningToast("请先输入数值",JumpToTheTopPositionActivty.this);
                }


            }
        });
    }

    @Override
    protected void loadDate() {
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map;
            map = new HashMap<String, Object>();
            map.put("number", i);
            list.add(map);
        }


    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void moveToPosition(final int n) {
        final LinearLayoutManager mLinearLayoutManager=(LinearLayoutManager)recyclerView.getLayoutManager();
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mLinearLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem ){
            //当要置顶的项在当前显示的第一个项的前面时
            recyclerView.scrollToPosition(n);
        }else if ( n <= lastItem ){
            //当要置顶的项已经在屏幕上显示时
            int top = recyclerView.getChildAt(n - firstItem).getTop();
            recyclerView.scrollBy(0, top);
        }else{
            //当要置顶的项在当前显示的最后一项的后面时
            recyclerView.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
            move = true;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (move) {
                    move = false;
                    int offset = n - mLinearLayoutManager.findFirstVisibleItemPosition();
                    if (offset >= 0 && offset <= recyclerView.getChildCount()) {
                        recyclerView.scrollBy(0, recyclerView.getChildAt(offset).getTop());
                    }
                }
            }
        });

    }


    class JumpToTheTopPositionAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(JumpToTheTopPositionActivty.this).inflate(R.layout.item_jump_to_the_top_position_activty, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(list.get(position).get("number").toString());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
