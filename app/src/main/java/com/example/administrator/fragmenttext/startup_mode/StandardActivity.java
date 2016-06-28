package com.example.administrator.fragmenttext.startup_mode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class StandardActivity extends BaseActivity {
    private Button standard;
    private TextView textView;
    private Button toSingleTask;
    private Button toSingleTop;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_standard);
        standard = (Button) findViewById(R.id.standard);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("<<<<<<StandardHandlerActivity>>>>>>>>" + this.toString());
        toSingleTask = (Button) findViewById(R.id.toSingleTask);
        toSingleTop = (Button) findViewById(R.id.toSingleTop);
        toSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });

        toSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent2);
            }
        });

    }

    @Override
    protected void setListener() {
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchStandard();

            }
        });
    }

    private void launchStandard() {
        startActivity(new Intent(this, StandardActivity.class));

        //    textView.setText(StandardHandlerActivity.this.toString());
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
