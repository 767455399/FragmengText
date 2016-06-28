package com.example.administrator.fragmenttext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;

/**
 * 项目名称：FragmentText
 * 类描述：联系人信息
 * 创建人：WangQing
 * 创建时间：2015/12/16 18:36
 * 修改人：WangQing
 * 修改时间：2015/12/16 18:36
 * 修改备注：
 */

public class ContactInformationFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout relationshipLinearLayout1;
    private LinearLayout relationshipLinearLayout2;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_contact_information,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        relationshipLinearLayout1=(LinearLayout)view.findViewById(R.id.relationshipLinearLayout1);
        relationshipLinearLayout2=(LinearLayout)view.findViewById(R.id.relationshipLinearLayout2);
        relationshipLinearLayout1.setOnClickListener(this);
        relationshipLinearLayout2.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relationshipLinearLayout1:
                break;
            case R.id.relationshipLinearLayout2:
                break;
            default:
                break;
        }
    }
}
