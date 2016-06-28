package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.graphics.PointF;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.jack.qrcode.QRCodeReaderView;
import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.util.Constants;

public class QRCodeScanActivity extends BaseActivity {

    private static final String TAG = "QRCodeScanActivity";

    public static final int QR_SCAN_RESULT_OK = 0x0001;
    public static final int QR_SCAN_REQUEST_CODE = 0x0002;


    private QRCodeReaderView qrCodeReaderView;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_qrcode_scan);
        qrCodeReaderView = (QRCodeReaderView) findViewById(R.id.qrCodeReaderView);
    }

    @Override
    protected void setListeners() {
        qrCodeReaderView.setOnQRCodeReadListener(new QRCodeReaderView.OnQRCodeReadListener() {
            @Override
            public void onQRCodeRead(String s, PointF[] pointFs) {
                Log.e("onQRCodeRead", s);
                if (!TextUtils.isEmpty(s) && s.contains(Constants.QRCODE_PREFIX)) {
                    Intent intent = new Intent();
                    intent.putExtra("qrResult", s);
                    setResult(QR_SCAN_RESULT_OK, intent);
                    cn.pocketwallet.pocketwallet.ui.activity.common.QRCodeScanActivity.this.finish();
                }
            }

            @Override
            public void cameraNotFound() {

            }

            @Override
            public void QRCodeNotFoundOnCamImage() {

            }
        });
    }

    @Override
    protected void loadData() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
    }

    public static void startForScanResult(Fragment fragment) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), cn.pocketwallet.pocketwallet.ui.activity.common.QRCodeScanActivity.class), QR_SCAN_REQUEST_CODE);
    }


    @Override
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
    }
}
