package com.example.administrator.fragmenttext.Handler;

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

public class StandardHandlerActivity extends BaseActivity {
    private Button button1;
    private TextView textView;
    int i;
    private Button button2;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           /* Bundle bundle = msg.getData();
            String[] a = bundle.getStringArray("shuju");
            String b = a[i % 7];
            if (b.equals("cc")) {
                textView.setText(b);
                new Thread(new MyThread()).interrupt();
            } else {
                textView.setText(b);
                new Thread(new MyThread()).start();
            }*/
            textView.setText(""+msg.arg1+msg.arg2+msg.obj+" ");


        }
    };


    @Override
    protected void initView() {
        setContentView(R.layout.activity_standard3);
        button1 = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.textView);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MyThread()).start();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = Message.obtain();
                        message.arg1 = 123;
                        message.arg2 = 21;
                        message.obj = "dsdd";
                        handler.sendMessage(message);


                    }
                }).start();
            }
        });
    }

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

    public class MyThread implements Runnable {
        @Override
        public void run() {
            i++;
            //请求方式一：
           /* Message message = Message.obtain();
            message.arg1 = 1;
            message.arg2 = 2;
            message.obj = "wang";
            message.what = 1;
            handler.sendMessage(message);*/
            //请求方式二：
           /* Message message1 = Message.obtain(handler);
            message1.arg1 = 1;
            message1.arg2 = 2;
            message1.obj = "wang";
            message1.what = 1;
            message1.sendToTarget();*/
            //请求方式三：
          /*  Message message2 = Message.obtain(handler, 22);
            message2.obj = "jjjj";
            message2.arg1 = 32;
            message2.arg2 = 17;
            message2.sendToTarget();*/
            //请求方式四：
            //对应的值分别为：handler，what，arg1,arg2,obj;
          /*  Message message3 = Message.obtain(handler, 15, 29, 29, "sds");
            message3.sendToTarget();*/
            //第五种方式：
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message4 = Message.obtain(handler, 1);
            Bundle data = new Bundle();
            data.putStringArray("shuju", new String[]{"as", "dhc", "ghfh", "ww", "aa", "cc", "sd"});
            message4.setData(data);
            message4.sendToTarget();

        }
    }
}
