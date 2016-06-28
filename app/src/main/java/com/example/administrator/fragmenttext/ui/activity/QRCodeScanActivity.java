package com.example.administrator.fragmenttext.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.fragment.MaillistFragment;
import com.jack.qrcode.QRCodeReaderView;


public class QRCodeScanActivity extends AppCompatActivity {

    private static final String TAG = "QRCodeScanActivity";

    public static final int QR_SCAN_RESULT_OK = 0x0001;
    public static final int QR_SCAN_REQUEST_CODE = 0x0002;
    private QRCodeReaderView qrCodeReaderView;
    private TextView qrTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan);
        initView();
        setListener();
    }


/*@Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }*/

    public static void startForScanResult(MaillistFragment fragment) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), com.example.administrator.fragmenttext.ui.activity.QRCodeScanActivity.class), QR_SCAN_REQUEST_CODE);
    }

    protected void initView() {

        qrCodeReaderView = (QRCodeReaderView) findViewById(R.id.qrCodeReaderView);
        qrTitle=(TextView)findViewById(R.id.qrTitle);
    }


    protected void setListener() {

        qrCodeReaderView.setOnQRCodeReadListener(new QRCodeReaderView.OnQRCodeReadListener() {
            @Override
            public void onQRCodeRead(String s, PointF[] pointFs) {
                Log.e("onQRCodeRead", s);
               /* if (!TextUtils.isEmpty(s) && s.contains("wq")) {
                    Intent intent = new Intent();
                    intent.putExtra("qrResult", s);
                    setResult(QR_SCAN_RESULT_OK, intent);
                    com.example.administrator.fragmenttext.ui.activity.QRCodeScanActivity.this.finish();*/
                    qrTitle.setText(s);
              /*  }*/
            }

            @Override
            public void cameraNotFound() {

            }

            @Override
            public void QRCodeNotFoundOnCamImage() {

            }
        });
    }

  /*  @Override
    protected void loadDate() {
        *//*if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }*//*
    }*/


   /* @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(this);
    }*/
}
