package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class ItemActivity extends BaseActivity {
    private TextView textView;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_item);
        textView=(TextView)findViewById(R.id.textView);
        Bundle bunde = this.getIntent().getExtras();
        String eml = bunde.getString("text");
        textView.setText(eml);
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
