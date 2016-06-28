package com.example.administrator.fragmenttext.Handler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.post.PostActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

public class MyHandlerActivity extends BaseActivity {
    private Button button;
    private TextView textView;
    private int i;
    private ImageView imageView;
    private Button post;
    private int imageViewWidth;
    String imageUrl = "http://img1.gtimg.com/sports/pics/hv1/174/208/1298/84455664.jpg";

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_handler);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        post=(Button)findViewById(R.id.post);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageViewWidth=imageView.getWidth();
                ToastUtil.showSuccessToast(imageViewWidth+"",MyHandlerActivity.this);
            }
        });

    };

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MyThread()).start();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MyHandlerActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap myBitmap= (Bitmap) msg.obj;
         /*   textView.setText(msg.arg1 + "");*/
            imageView.setImageBitmap(myBitmap);
           /* 继续开启线程*/
         /*   handler.post(new MyThread());*/
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

    public class MyThread implements Runnable {
        @Override
        public void run() {
            loadImageView();

        }

        private void loadImageView() {
            //httpGet连接对象
            HttpGet httpRequest = new HttpGet(imageUrl);
            //取得HttpClient 对象
            HttpClient httpclient = new DefaultHttpClient();
            try {
                //请求httpClient ，取得HttpRestponse
                   HttpResponse httpResponse = httpclient.execute(httpRequest);
                if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    //取得相关信息 取得HttpEntiy
                    HttpEntity httpEntity = httpResponse.getEntity();
                    //获得一个输入流
                    InputStream is = httpEntity.getContent();
                    System.out.println(is.available());
                    System.out.println("Get, Yes!");
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                    Message message = new Message();
                    message.obj=bitmap;
                    handler.sendMessage(message);
                }

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


}
