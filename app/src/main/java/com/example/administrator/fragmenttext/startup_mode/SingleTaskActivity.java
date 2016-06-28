package com.example.administrator.fragmenttext.startup_mode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class SingleTaskActivity extends BaseActivity {
    private TextView textView;
    private Button singleTask;
    private Button toStandard;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_single_task);
        textView=(TextView)findViewById(R.id.textView);
        singleTask=(Button)findViewById(R.id.singleTask);
        toStandard=(Button)findViewById(R.id.toStandard);
    }

    @Override
    protected void setListener() {
        singleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleTask();
            }
        });
        toStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SingleTaskActivity.this,StandardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void singleTask() {
        startActivity(new Intent(this,SingleTaskActivity.class));
        textView.setText(this.toString());
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
