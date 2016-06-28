package com.example.administrator.fragmenttext.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItemAdapter;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItems;
import com.example.administrator.fragmenttext.ui.fragment.CommodityPriceFragment;
import com.example.administrator.fragmenttext.ui.fragment.NbaTodayFragment;
import com.example.administrator.fragmenttext.ui.fragment.NbaTomorrowFragment;
import com.example.administrator.fragmenttext.ui.fragment.NbaYesterdayFragmnet;
import com.example.administrator.fragmenttext.ui.fragment.NetworkInformationFragment;

public class NbaActivity extends BaseActivity {
    private TabLayout nbaTabLayout;
    private ViewPager nbaViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_nba);
        nbaTabLayout = (TabLayout) findViewById(R.id.nbaTabLayout);
        nbaViewPager = (ViewPager) findViewById(R.id.nbaViewPager);
        Time time = new Time("GMT+8");
        time.setToNow();
        int year = time.year;
        int month = time.month;
        int day = time.monthDay;
        int minute = time.minute;
        int hour = time.hour;
        int sec = time.second;
        String yesterday = year + "年" + month + "月" + (day - 1) + "日";
        String today = year + "年" + month + "月" + day + "日";
        String tomorrow = year + "年" + month + "月" + (day + 1) + "日";
        FragmentPagerItemAdapter nbaFragmentPagerItemAdapter = new FragmentPagerItemAdapter
                (getSupportFragmentManager(), FragmentPagerItems.with(NbaActivity.this)
                        .add(R.string.yesterday, NbaYesterdayFragmnet.class)
                        .add(R.string.today, NbaTodayFragment.class)
                        .add(R.string.tomorrow, NbaTomorrowFragment.class).create());
        nbaViewPager.setAdapter(nbaFragmentPagerItemAdapter);
        nbaTabLayout.setupWithViewPager(nbaViewPager);
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
