package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.HttpHandler;

import java.io.File;

public class AfinalActivity extends BaseActivity {
    private Button button;
    private TextView textview;
    private ImageView imageview;
    private FinalBitmap fb;
    private TextView currentTextView;


    protected void initView() {
        setContentView(R.layout.activity_afinal);
        currentTextView = (TextView) findViewById(R.id.currentTextView);
        textview = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        imageview = (ImageView) findViewById(R.id.imageview);
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            Log.i("TestFile",
                    "SD card is not avaiable/writeable right now.");
            return;
        }



        final String filePath = Environment.getExternalStorageDirectory() + "/testFile.apk";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinalHttp fh = new FinalHttp();
                //调用download方法开始下载
                HttpHandler handler = fh.download("http://www.jutongbao.com/jtb/jtb.apk",
                        //这里是下载的路径//true:断点续传 false:不断点续传（全新下载）
                        filePath
                        , true, //这是保存到本地的路径
                        new AjaxCallBack<File>() {
                            @Override
                            public void onLoading(long count, long current) {
                                currentTextView.setText("下载进度：" + count*100/current+"%");
                            }

                            @Override
                            public void onStart() {
                                super.onStart();
                            }

                            @Override
                            public void onFailure(Throwable t, int errorNo, String strMsg) {
                                super.onFailure(t, errorNo, strMsg);
                            }


                            @Override
                            public void onSuccess(File t) {
                                textview.setText(t == null ? "null" : t.getAbsoluteFile().toString());
                                ToastUtil.showSuccessToast("下载成功", AfinalActivity.this);
                            }

                        }

                );


                //调用stop()方法停止下载
                handler.stop();

               /* FinalHttp fh = new FinalHttp();
                fh.get("http://www.yangfuhai.com",*/
                       /* new AjaxCallBack<Object>(){

                    @Override
                    public void onLoading(long count, long current) { //每1秒钟自动被回调一次
                        currentTextView.setText(current+"/"+count);
                    }

                    @Override
                    public void onSuccess(String t) {
                        currentTextView.setText(t==null?"null":t);
                    }

                    @Override
                    public void onStart() {
                        //开始http请求的时候回调
                    }

                    @Override
                    public void onFailure(Throwable t, String strMsg) {
                        //加载失败的时候回调
                    }
                });*/
                       /* new AjaxCallBack<Object>() {
                            @Override
                            public void onLoading(long count, long current) {
                                super.onLoading(count, current);
                                ToastUtil.showSuccessToast("",AfinalActivity.this);
                            }

                            @Override
                            public void onSuccess(Object o) {
                                super.onSuccess(o);
                            }
                        });*/


            }
        });
        fb = FinalBitmap.create(this);//初始化FinalBitmap模块
        fb.configLoadingImage(R.drawable.b);
        //这里可以进行其他十几项的配置，也可以不用配置，配置之后必须调用init()函数,才生效
        //fb.configBitmapLoadThreadSize(int size)
        //fb.configBitmapMaxHeight(bitmapHeight)
        fb.display(imageview, "http://img.ivsky.com/img/tupian/pre/201601/01/qinghai_lake-003.jpg");
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
}
