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
import com.example.administrator.fragmenttext.ui.adapter.PhoneNumberUtils;
import com.example.administrator.fragmenttext.ui.adapter.StringUtil;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/5 16:50
 * 修改人：WangQing
 * 修改时间：2016/1/5 16:50
 * 修改备注：
 */
public class OneRegistrationFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private Button nextButton;
    private RegistrationTwoFragment registrationTwoFragment;
    private EditText mobilePhoneEditText;
    private EditText invitationCodeEditText;


    public OneRegistrationFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_one_registration, container, false);
    }

    @Override
    protected void initView(View view) {
        nextButton = (Button) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);
        mobilePhoneEditText=(EditText)view.findViewById(R.id.mobilePhoneEditText);
        invitationCodeEditText=(EditText)view.findViewById(R.id.invitationCodeEditText);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nextButton:
                registration();

                break;
            default:
                break;
        }
    }
    private void registration(){
        String mobilePhone= StringUtil.removeSpace(mobilePhoneEditText.getText().toString());
        String invitationCode=StringUtil.removeSpace(invitationCodeEditText.getText().toString());
        if(TextUtils.isEmpty(mobilePhone)){
            ToastUtil.showWarningToast("请输入手机号码",getActivity());
        }else{
            if(PhoneNumberUtils.isMobileNO(mobilePhone)){
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if(registrationTwoFragment==null){
                    registrationTwoFragment=new RegistrationTwoFragment();
                }
                fragmentTransaction.replace(R.id.container,registrationTwoFragment);
                fragmentTransaction.commit();
            }else{
                ToastUtil.showWarningToast("请输入正确的手机号码",getActivity());
            }

        }

    }
}
