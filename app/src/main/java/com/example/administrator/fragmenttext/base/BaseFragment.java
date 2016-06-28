package com.example.administrator.fragmenttext.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.fragmenttext.widget.LoadingDialog;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 15:38
 * 修改人：WangQing
 * 修改时间：2015/12/1 15:38
 * 修改备注：
 */
public abstract class BaseFragment extends Fragment{
    private LoadingDialog loadingDialog;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingDialog=new LoadingDialog(getActivity());
        initView(view);
        loadDate();
    }

    protected abstract void initView(View view);

    protected abstract void loadDate();

    protected void showLoadingDialog(){
        if(null!=loadingDialog&&!loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }
    protected void dismisLoadingDialog(){
        if(null!=loadingDialog&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }

    


}
