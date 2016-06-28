package com.example.administrator.fragmenttext.ui.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.adapter.CountDown;
import com.example.administrator.fragmenttext.ui.adapter.StringUtil;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/5 17:42
 * 修改人：WangQing
 * 修改时间：2016/1/5 17:42
 * 修改备注：
 */
public class RegistrationTwoFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private Button getVerificationCodeButton;
    private CountDown countDown;
    private Button nextButton;
    private EditText verificationCodeEditText;
    SetTransactionPasswordFragment setTransactionPasswordFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_registration_two, container, false);
    }

    @Override
    protected void initView(View view) {
        getVerificationCodeButton = (Button) view.findViewById(R.id.getVerificationCodeButton);
        getVerificationCodeButton.setOnClickListener(this);
        nextButton=(Button)view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);
        verificationCodeEditText=(EditText)view.findViewById(R.id.verificationCodeEditText);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getVerificationCodeButton:
                countDown=new CountDown(30*1000,1000,getVerificationCodeButton);
                countDown.start();
                break;
            case R.id.nextButton:
                nextStep();
                break;
            default:
                break;
        }
    }
private void nextStep(){
    //去掉验证码字符串中的空格；
    String verificationCode= StringUtil.removeSpace(verificationCodeEditText.getText().toString());
    if(TextUtils.isEmpty(verificationCode)){
        ToastUtil.showWarningToast("请输入验证码",getActivity());
    }else{
        if(verificationCode.length()!=6){
            ToastUtil.showWarningToast("请输入正确的验证码",getActivity());
        }else {
            FragmentManager fragmentManager=getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            if(null==setTransactionPasswordFragment){
                setTransactionPasswordFragment=new SetTransactionPasswordFragment();
            }
            fragmentTransaction.replace(R.id.container,new SetTransactionPasswordFragment());
            fragmentTransaction.commit();
        }
    }
}
}
