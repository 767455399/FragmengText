package com.example.administrator.fragmenttext.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.FragmentUtil;
import com.example.administrator.fragmenttext.ui.fragment.CityFragment;
import com.example.administrator.fragmenttext.ui.fragment.ProvinceFragment;
import com.example.administrator.fragmenttext.ui.fragment.WeChatFragment;

public class PlaceActivity extends BaseActivity implements View.OnClickListener {
    private TextView provincePlaceTextView;
    private TextView cityPlaceTextView;
    private ProvinceFragment provinceFragment;
    private CityFragment cityFragment;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_place);
        provincePlaceTextView=(TextView)findViewById(R.id.provincePlaceTextView);
        cityPlaceTextView=(TextView)findViewById(R.id.cityPlaceTextView);
        provincePlaceTextView.setOnClickListener(this);
        cityPlaceTextView.setOnClickListener(this);
  //      FragmentUtil.replace(getSupportFragmentManager(), R.id.bankBranchContainer, new BankBranchProvinceFragment(), false, "BankBranchProvinceFragment");
    //    FragmentUtil.replace(getSupportFragmentManager(),R.id.placeFrameLayout,new ProvinceFragment(),false,"ProvinceFragment");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        provinceFragment = new ProvinceFragment();
        ft.add(R.id.placeFrameLayout, provinceFragment);
        ft.commit();

    }
    public void setProvinceVisibility(String province){
        provincePlaceTextView.setVisibility(View.VISIBLE);
        provincePlaceTextView.setText(province);
    }
    public void setCityVisibility(String city){
        cityPlaceTextView.setVisibility(View.VISIBLE);
        cityPlaceTextView.setText(city);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.provincePlaceTextView:
                provincePlaceTextView.setVisibility(View.GONE);
                if(View.VISIBLE==cityPlaceTextView.getVisibility()){
                    cityPlaceTextView.setVisibility(View.GONE);
                }
                FragmentManager fm2 = getFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
                provinceFragment = new ProvinceFragment();
                ft2.replace(R.id.placeFrameLayout, provinceFragment);
                ft2.commit();
                break;
            case R.id.cityPlaceTextView:
                cityPlaceTextView.setVisibility(View.GONE);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                provinceFragment = new ProvinceFragment();
                ft.replace(R.id.placeFrameLayout, provinceFragment);
                ft.commit();
                break;

        }
    }
}
