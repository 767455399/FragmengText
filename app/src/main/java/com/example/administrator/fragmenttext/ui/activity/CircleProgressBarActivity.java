package com.example.administrator.fragmenttext.ui.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.adapter.HorizontalProgressBarWithNumber;
import com.example.administrator.fragmenttext.ui.adapter.RoundProgressBarWidthNumber;

public class CircleProgressBarActivity extends BaseActivity {
    private HorizontalProgressBarWithNumber mProgressBar1;
    private RoundProgressBarWidthNumber mProgressBar;
    private static final int MSG_PROGRESS_UPDATE = 0x110;

    private Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            int progress = mProgressBar.getProgress();
            mProgressBar.setProgress(++progress);
            if (progress >= 100) {
                mHandler.removeMessages(MSG_PROGRESS_UPDATE);

            }
           /* mHandler.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE, 500);
            int progress1 = mProgressBar1.getProgress();
            mProgressBar1.setProgress(++progress1);
            if (progress1 >= 100) {
                mHandler.removeMessages(MSG_PROGRESS_UPDATE);

            }*/
            mHandler.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE, 100);
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress_bar);
        mProgressBar1 = (HorizontalProgressBarWithNumber) findViewById(R.id.id_progressbar01);
        mProgressBar=(RoundProgressBarWidthNumber)findViewById(R.id.id_progress04);
        mProgressBar.setProgress(10);
        invalidateOptionsMenu();
        mProgressBar.setRotation(0);
        mHandler.sendEmptyMessage(MSG_PROGRESS_UPDATE);

    }

    @Override
    protected void initView() {

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
