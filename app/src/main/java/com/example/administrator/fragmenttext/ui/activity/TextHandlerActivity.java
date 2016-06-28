package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.Handler.TreadNewActivity;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

public class TextHandlerActivity extends BaseActivity {
    private ImageView imageView;
    private int[] image = {R.drawable.e, R.drawable.f, R.drawable.g};
    private int index;
    private Button button;
    private Button stop;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_text_handler);
        imageView = (ImageView) findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);
        stop= (Button) findViewById(R.id.stop);
        handler.post(runnable);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(TextHandlerActivity.this,TreadNewActivity.class);
                startActivity(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });
        imageView.post(new Runnable() {
            @Override
            public void run() {
                int width=imageView.getWidth();
                ToastUtil.showSuccessToast(width+"",TextHandlerActivity.this);
            }
        });
    }
//该线程是运行在主线程中的，而且是运行在最后，所以当要更新UI或者测量某个控件的宽高（必须等该控件绘制完成才能得到它的宽高）的时候，
// 我们就可以用到这个了。我们在MyQrCodeActivity这个类中也用到了这个方法。
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            index++;
            imageView.setImageResource(image[index%3]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(runnable);
        }
    };


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
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
