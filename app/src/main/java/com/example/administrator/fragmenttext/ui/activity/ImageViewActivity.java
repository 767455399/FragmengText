package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import it.sephiroth.android.library.picasso.Picasso;

public class ImageViewActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_image_view);
        imageview=(ImageView)findViewById(R.id.phoneImageview);

    }

    @Override
    protected void setListener() {
        imageview.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {
        Intent intent=getIntent();
        String imagepath1=intent.getStringExtra("imagepath");
        Picasso.with(ImageViewActivity.this)
                .load(imagepath1)
                .placeholder(R.drawable.b)
                .error(R.drawable.c)
                .into(imageview);
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phoneImageview:
                finish();
                break;
        }
    }
}
