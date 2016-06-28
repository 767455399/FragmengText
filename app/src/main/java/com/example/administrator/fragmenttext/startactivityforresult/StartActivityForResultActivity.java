package com.example.administrator.fragmenttext.startactivityforresult;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class StartActivityForResultActivity extends BaseActivity {
    private static final int REQUESTCODE = 0;
    private static final int REQUESTCODE1 = 1;
    private Button sendButton;
    private TextView textView;
    private Button sendButton2;
    private TextView textView2;



    @Override
    protected void initView() {
        setContentView(R.layout.activity_start_activity_for_result);
        sendButton = (Button) findViewById(R.id.sendButton);
        textView = (TextView) findViewById(R.id.textView);
        sendButton2 = (Button) findViewById(R.id.sendButton2);
        textView2 = (TextView) findViewById(R.id.textView2);
    }

    @Override
    protected void setListener() {
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StartActivityForResultActivity.this, SetResultActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(StartActivityForResultActivity.this, SetResultActivity.class);
                intent1.putExtra("data", "传递给A的数据");
                startActivityForResult(intent1, REQUESTCODE1);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (3 == resultCode) {
            if(requestCode==0){
                if(!TextUtils.isEmpty(data.getStringExtra("wq")))
                textView.setText(data.getStringExtra("wq"));
            }
            if(requestCode==1){


            }
        }
        if(RESULT_OK==resultCode){
            if(1==requestCode){
                if(!TextUtils.isEmpty(data.getStringExtra("www")))
                    textView2.setText(data.getStringExtra("www"));
            }
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
