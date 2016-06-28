package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/18 16:39
 * 修改人：WangQing
 * 修改时间：2015/12/18 16:39
 * 修改备注：
 */
public class PersonalDataActivity extends BaseActivity{
    private CircleImageView headPortraitImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    protected void setListener() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_personal_data);
        headPortraitImageView=(CircleImageView)findViewById(R.id.headPortraitImageView);
  //    headPortraitImageView.setImageResource(R.drawable.b);
        Picasso.with(this).load("http://g.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917914baed1cd3d70cf3ac7578a.jpg").placeholder(R.drawable.b).error(R.drawable.c).into(headPortraitImageView);
    }
}
