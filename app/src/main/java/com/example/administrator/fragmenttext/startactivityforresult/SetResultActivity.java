package com.example.administrator.fragmenttext.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class SetResultActivity extends BaseActivity {
    private Button button;
    private static final int resultCode = 3;
    private TextView textView;
    private Button button2;
    private TextView textView2;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_set_result);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent1 = getIntent();
        String aa = intent1.getStringExtra("data");
        textView.setText(aa);

    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("www", "大家好！");
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }

    private void getData() {
        Intent intent = new Intent();
        intent.putExtra("wq", "wangqing");
        setResult(resultCode, intent);
        finish();
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
