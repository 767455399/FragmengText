package com.example.administrator.fragmenttext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/21 19:58
 * 修改人：WangQing
 * 修改时间：2015/12/21 19:58
 * 修改备注：
 */
public class RegistrationFirstStepFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmnet_registration_first_step,container,false);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void loadDate() {

    }
}
