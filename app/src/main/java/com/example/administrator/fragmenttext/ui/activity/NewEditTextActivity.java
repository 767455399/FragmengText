package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

public class NewEditTextActivity extends BaseActivity {
private Button button;
    final int RESULT_CODE=101;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_new_edit_text);
        button=(Button)findViewById(R.id.button);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("second", "I am second!");
                setResult(RESULT_CODE, intent);
                finish();
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
