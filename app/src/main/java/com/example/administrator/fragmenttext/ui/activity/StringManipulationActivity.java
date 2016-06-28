package com.example.administrator.fragmenttext.ui.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

/*
*
* textview文字处理
*
* */

public class StringManipulationActivity extends BaseActivity {
    private TextView textView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_string_manipulation);
        textView=(TextView)findViewById(R.id.textView);
        getData();
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

    private void getData(){

//创建一个 SpannableString对象
        SpannableString sp = new SpannableString("这句话中有百度超链接,有高亮显示，这样，或者这样，还有斜体.");
//设置超链接
        sp.setSpan(new URLSpan("http://www.baidu.com"), 5, 7,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置高亮样式一
        sp.setSpan(new BackgroundColorSpan(Color.RED), 17 ,19,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//设置高亮样式二          sp.setSpan(new ForegroundColorSpan(Color.YELLOW),20,24,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//设置斜体
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 27, 29, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //SpannableString对象设置给TextView
        textView.setText(sp);
        //设置TextView可点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
