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

public class NewThreadActivity extends BaseActivity {
    private Button button;
    private int i;
    private TextView textView;
    private Button stop;
    private Button tiaozhuan;



    @Override
    protected void initView() {
        setContentView(R.layout.activity_new_thread);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        stop=(Button)findViewById(R.id.stop);
        tiaozhuan=(Button)findViewById(R.id.tiaozhuan);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(NewThreadActivity.this,HandleActivity.class);
                startActivity(intent);
            }
        });
    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Message message=Message.obtain();
            message.arg1=i;
            i++;
            handler.sendMessage(message);

        }
    };
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText(String.valueOf(msg.arg1));
             handler.post(runnable);
        }
    };

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
