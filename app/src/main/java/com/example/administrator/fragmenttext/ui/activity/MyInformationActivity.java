package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;


import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItemAdapter;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItems;
import com.example.administrator.fragmenttext.ui.fragment.ContactsFragment;
import com.example.administrator.fragmenttext.ui.fragment.DocumentInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.PersonalCenterFragment;


/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/28 14:21
 * 修改人：WangQing
 * 修改时间：2015/12/28 14:21
 * 修改备注：和
 */
public class MyInformationActivity extends BaseActivity{

    private TabLayout tabLayout ;
    private ViewPager viewPager;
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
        setContentView(R.layout.activity_my_information);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        //界面的切换；
        FragmentPagerItemAdapter fragmentPagerItemAdapter=new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(MyInformationActivity.this)
                .add(R.string.personal_information, PersonalCenterFragment.class)
                .add(R.string.contacts, ContactsFragment.class)
                .add(R.string.document_information,DocumentInformationFragment.class)
                .create());
        viewPager.setAdapter(fragmentPagerItemAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
