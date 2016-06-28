package com.example.administrator.fragmenttext.startup_mode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class SingleTopActivity extends BaseActivity {
    private Button singleTop;
    private TextView textView;
    private Button toNext;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_single_top);
        singleTop = (Button) findViewById(R.id.singleTop);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText(this.toString());
        toNext=(Button)findViewById(R.id.toNext);
    }

    private void singleTop() {
        startActivity(new Intent(this,SingleTopActivity.class));
    }

    @Override
    protected void setListener() {
        singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleTop();
            }
        });

        toNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SingleTopActivity.this,SingleTaskActivity.class);
                startActivity(intent);

            }
        });
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
