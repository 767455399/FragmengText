package com.example.administrator.fragmenttext.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.camera.CameraActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.fragment.FoundFragment;
import com.example.administrator.fragmenttext.ui.fragment.MaillistFragment;
import com.example.administrator.fragmenttext.ui.fragment.MeFragment;
import com.example.administrator.fragmenttext.ui.fragment.WeChatFragment;
import com.example.administrator.fragmenttext.ui.fragment.WorkInformationFragment;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 14:32
 * 修改人：WangQing
 * 修改时间：2015/12/1 14:32
 * 修改备注：
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TextView meTextView;
    private TextView foundTextView;
    private TextView weChatTextView;
    private TextView maillistTextView;
    private FoundFragment foundFragment;
    private MaillistFragment maillistFragment;
    private MeFragment meFragment;
    private WeChatFragment weChatFragment;
    private WorkInformationFragment workInformationFragment;
    private Button takePhoto;

    //   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            weChatFragment = new WeChatFragment();
            ft.add(R.id.container, weChatFragment);
            ft.commit();
        }
        //获取应用程序最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        ToastUtil.showWarningToast(maxMemory+"",MainActivity.this);

        //      ToastUtil.showWarningToast(getString(R.string.phone_password_wrong));
    }

    @Override
    protected void loadDate() {
     /*  显示加载框
       showLoadingDialog();*/
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    @Override
    protected void setListener() {
        maillistTextView.setOnClickListener(this);
        weChatTextView.setOnClickListener(this);
        foundTextView.setOnClickListener(this);
        meTextView.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        takePhoto = (Button) findViewById(R.id.takePhoto);
        maillistTextView = (TextView) findViewById(R.id.maillistTextView);
        weChatTextView = (TextView) findViewById(R.id.weChatTextView);
        foundTextView = (TextView) findViewById(R.id.foundTextView);
        meTextView = (TextView) findViewById(R.id.meTextView);
        weChatTextView.setTextColor(this.getResources().getColor(R.color.green));
    }

    @Override
    public void onClick(View v) {
        press();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.maillistTextView:
                if (maillistFragment == null) {
                    maillistFragment = new MaillistFragment();
                }
                fragmentTransaction.replace(R.id.container, maillistFragment);
                fragmentTransaction.commit();
                maillistTextView.setTextColor(this.getResources().getColor(R.color.green));
                break;
            case R.id.foundTextView:
                if (foundFragment == null) {
                    foundFragment = new FoundFragment();
                }
                fragmentTransaction.replace(R.id.container, foundFragment);
                fragmentTransaction.commit();
                foundTextView.setTextColor(this.getResources().getColor(R.color.green));
                break;
            case R.id.weChatTextView:
                if (workInformationFragment == null) {
                    workInformationFragment = new WorkInformationFragment();
                }
                fragmentTransaction.replace(R.id.container, workInformationFragment);
                fragmentTransaction.commit();
                weChatTextView.setTextColor(this.getResources().getColor(R.color.green));
                break;
          /*  case R.id.weChatTextView:
                if(weChatFragment==null){
                    weChatFragment=new WeChatFragment();
                }
                fragmentTransaction.replace(R.id.container,weChatFragment);
                fragmentTransaction.commit();
                weChatTextView.setTextColor(this.getResources().getColor(R.color.green));
                break;*/
            case R.id.meTextView:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                }
                fragmentTransaction.replace(R.id.container, meFragment);
                fragmentTransaction.commit();
                meTextView.setTextColor(this.getResources().getColor(R.color.green));
                break;
            case R.id.takePhoto:
                Intent intent = new Intent();
                //            intent.setClass(MainActivity.this, CameraActivity.class);
                intent.setClass(MainActivity.this, MyInformationActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    //初始化底部文字的颜色
    private void press() {
        maillistTextView.setTextColor(this.getResources().getColor(R.color.black));
        foundTextView.setTextColor(Color.BLACK);
        weChatTextView.setTextColor(0xFF000000);
        meTextView.setTextColor(Color.BLACK);
    }

}
