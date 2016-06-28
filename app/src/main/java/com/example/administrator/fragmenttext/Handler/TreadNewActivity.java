package com.example.administrator.fragmenttext.Handler;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.activity.ThreadActivity;

public class TreadNewActivity extends BaseActivity {
    private Button button;
    private TextView textView;
    private Button tiaozhuan;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_tread_new);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
        tiaozhuan=(Button)findViewById(R.id.tiaozhuan);
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(TreadNewActivity.this,MyHandlerActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               thread.start();
            }
        });
    }
//线程为什么会卡；
    Thread thread=new Thread(){
        @Override
        public void run() {
            Message message=new Message();
            message.arg1=123;
            message.arg2=456;
          /*  handler.sendMessageAtTime(message,1000);*/
            handler.sendMessage(message);
            handler.obtainMessage();
        }
    };

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.arg1+msg.arg2+"");
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
