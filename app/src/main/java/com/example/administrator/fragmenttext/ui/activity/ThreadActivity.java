package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

public class ThreadActivity extends BaseActivity {
    private Button button;
    private int i;
    private TextView textView;
    private Button xianchen;
    private TextView ceshiTextView;



    @Override
    protected void initView() {
        setContentView(R.layout.activity_thread);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        xianchen=(Button)findViewById(R.id.xianchen);
        ceshiTextView=(TextView)findViewById(R.id.ceshiTextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(runnable);
                thread.start();
            }
        });
        xianchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ThreadActivity.this,NewThreadActivity.class);
                startActivity(intent);
            }
        });
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText(String.valueOf(msg.arg1));
            handler.post(runnable);
        }
    };

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            i++;
        //    ceshiTextView.setText("当前计数："+i);
            Message message=Message.obtain();
            message.arg1=i;
            handler.sendMessage(message);

        }
    };

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }
}
