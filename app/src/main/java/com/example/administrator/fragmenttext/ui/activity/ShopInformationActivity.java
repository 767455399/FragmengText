package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItemAdapter;
import com.example.administrator.fragmenttext.ui.adapter.FragmentPagerItems;
import com.example.administrator.fragmenttext.ui.fragment.CommodityPriceFragment;
import com.example.administrator.fragmenttext.ui.fragment.ContactsFragment;
import com.example.administrator.fragmenttext.ui.fragment.DocumentInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.NetworkInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.PersonalCenterFragment;

/*网店信息*/

public class ShopInformationActivity extends BaseActivity {
    private ViewPager shopInformationViewPager;
    private TabLayout loanRecordTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_shop_information);
        shopInformationViewPager = (ViewPager) findViewById(R.id.shopInformationViewPager);
        loanRecordTabLayout = (TabLayout) findViewById(R.id.shopInformationTabLayout);
        FragmentPagerItemAdapter fragmentPagerItemAdapter1=new FragmentPagerItemAdapter(
                getSupportFragmentManager(),FragmentPagerItems.with(ShopInformationActivity.this)
                //这里新建的两个fragment必须继承fragment，不能继承其他fragment，因为FragmentPagerItemAdapter
               // 里面继承的fragment
        .add(R.string.network_information,CommodityPriceFragment.class)
        .add(R.string.commodity_price,NetworkInformationFragment.class).create());
        shopInformationViewPager.setAdapter(fragmentPagerItemAdapter1);
        loanRecordTabLayout.setupWithViewPager(shopInformationViewPager);
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
