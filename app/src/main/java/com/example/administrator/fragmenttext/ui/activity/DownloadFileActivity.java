package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.widget.LoadingDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileActivity extends BaseActivity {
    private static final String TAG = "DownloadFileActivity";
    private Button loadingButton;
    private String path = "http://www.jutongbao.com/jtb/jtb.apk";
    private String filePath;
    private LoadingDialog loadingDialog;
    private TextView textview;
    int total = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textview.setText(msg.arg1 + "%");
            loadingDialog.dismiss();
            if (msg.arg1 == 100) {
                filePath = Environment.getExternalStorageDirectory() + "/wwwwwwwwwwww.apk";
                final File file = new File(filePath);
                openFile(file);
            }

        }
    };

    @Override
    protected void initView() {
        setContentView(R.layout.activity_download_file);
        loadingButton = (Button) findViewById(R.id.loadingButton);
        loadingDialog = new LoadingDialog(DownloadFileActivity.this);
        Log.d(TAG, "initView: ");
        textview = (TextView) findViewById(R.id.textview);
    }

    //打开APK程序代码
    private void openFile(File file) {
        // TODO Auto-generated method stub
        Log.e("OpenFile", file.getName());
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @Override
    protected void setListener() {
        loadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            ToastUtil.showSuccessToast("主线程", DownloadFileActivity.this);
                        } else {
                            loading(path);
                        }


                    }
                }.start();
            }
        });
    }


    private void loading(String path) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            Log.i("TestFile",
                    "SD card is not avaiable/writeable right now.");
            ToastUtil.showSuccessToast("没有存储卡", DownloadFileActivity.this);
            return;
        } else {
            filePath = Environment.getExternalStorageDirectory() + "/wwwwwwwwwwww.apk";
        }

        File file = new File(filePath);
        //如果目标文件已经存在，则删除。产生覆盖旧文件的效果
        if (file.exists()) {
            file.delete();
        }
        try {
            // 构造URL
            URL url = new URL(path);
            // 打开连接
            URLConnection con = url.openConnection();
            //获得文件的长度
            int contentLength = con.getContentLength();
            System.out.println("长度 :" + contentLength);
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream(filePath);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
                total += len;
                Message message = new Message();
                int x = total * 100 / contentLength;
                message.arg1 = x;
                handler.sendMessage(message);
            }
            os.close();
            is.close();

        } catch (Exception e) {
            Message message = new Message();
            message.arg1 = 2;
            handler.sendMessage(message);
            e.printStackTrace();

        }


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
