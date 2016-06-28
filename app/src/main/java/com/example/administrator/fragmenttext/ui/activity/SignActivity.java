package com.example.administrator.fragmenttext.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.FragmentUtil;
import com.example.administrator.fragmenttext.dialog.CommonDialog;
import com.example.administrator.fragmenttext.ui.fragment.OneRegistrationFragment;

import java.util.Observable;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/5 16:05
 * 修改人：WangQing
 * 修改时间：2016/1/5 16:05
 * 修改备注：
 */
public class SignActivity extends BaseActivity implements View.OnClickListener {
    OneRegistrationFragment oneRegistrationFragment;


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
        setContentView(R.layout.activity_sign);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (oneRegistrationFragment == null) {
            oneRegistrationFragment = new OneRegistrationFragment();
        }
        fragmentTransaction.replace(R.id.container, oneRegistrationFragment);
        fragmentTransaction.commit();

        //   FragmentUtil.replace(getSupportFragmentManager(),R.id.container,new OneRegistrationFragment(),false,"OneRegistrationFragment");
    }

    @Override
    public void onClick(View v) {
       /* switch (v.getId()){
            case
                break;
            default:
                break;
        }*/
    }

    @Override
    public void onBackPressed() {
        final CommonDialog commonDialog = new CommonDialog(SignActivity.this, "温馨提醒", "短信验证码可能略有延迟，请稍等!", new CommonDialog.Listener() {
            @Override
            public void onLeftButtonClick() {
               SignActivity.super.onBackPressed();
            }

            @Override
            public void onRightButtonClick() {

            }
        });
        commonDialog.setLeftButtonText("不了");
        commonDialog.setRightButtonText("好的");
        commonDialog.show();
    }
}
