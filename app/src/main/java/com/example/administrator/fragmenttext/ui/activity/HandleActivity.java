package com.example.administrator.fragmenttext.ui.activity;

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

public class HandleActivity extends BaseActivity {
    private int i;
    private Button kaishijishi;
    private TextView textView;
    private Button jieshujishi;
    private Button tiaozhuan;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_handle);
        kaishijishi = (Button) findViewById(R.id.kaishijishi);
        textView = (TextView) findViewById(R.id.textView);
        jieshujishi = (Button) findViewById(R.id.jieshujishi);
        tiaozhuan=(Button)findViewById(R.id.tiaozhuan);
    }

    @Override
    protected void setListener() {
        kaishijishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.post(runnable);
            }
        });
        jieshujishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.removeCallbacks(runnable);
            }
        });
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(HandleActivity.this,TextHandlerActivity.class);
                startActivity(intent);
            }
        });
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

    Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(String.valueOf(msg.arg1));
            myHandler.post(runnable);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            i++;
            Message message = myHandler.obtainMessage();
            message.obj = "";
            message.arg1 = i;
            myHandler.sendMessage(message);
        }
    };
}
