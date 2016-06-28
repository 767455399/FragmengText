package com.example.administrator.fragmenttext.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.activity.LoginActivity;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/6 10:35
 * 修改人：WangQing
 * 修改时间：2016/1/6 10:35
 * 修改备注：
 */
public class SetTransactionPasswordFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private Button completeRegistrationButton;
    private CheckBox loginCheckBox;
    private CheckBox transactionPasswordCheckBox;
    private EditText transactionPasswordEditText;
    private EditText loginPasswordEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_set_transaction_password, container, false);
    }

    @Override
    protected void initView(View view) {
        transactionPasswordEditText=(EditText)view.findViewById(R.id.transactionPasswordEditText);
        loginPasswordEditText=(EditText)view.findViewById(R.id.loginPasswordEditText);
        completeRegistrationButton = (Button) view.findViewById(R.id.completeRegistrationButton);
        completeRegistrationButton.setOnClickListener(this);
        loginCheckBox = (CheckBox) view.findViewById(R.id.loginCheckBox);
        transactionPasswordCheckBox = (CheckBox) view.findViewById(R.id.transactionPasswordCheckBox);
        loginCheckBox.setOnCheckedChangeListener(loginOnCheckedChangeListener);
        //默认设置密码不可见；
        loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        transactionPasswordCheckBox.setOnCheckedChangeListener(transactionPasswordOnCheckedChangeListener);
        transactionPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.completeRegistrationButton:
                completeRegistration();

                break;
        }
    }

    CompoundButton.OnCheckedChangeListener loginOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                //密码可见；
                loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                //密码不可见；
                loginPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        }
    };
    CompoundButton.OnCheckedChangeListener transactionPasswordOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                transactionPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                transactionPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        }
    };
    private void completeRegistration(){
        String transactionPassword=transactionPasswordEditText.getText().toString();
        String loginPassword=loginPasswordEditText.getText().toString();
        if(TextUtils.isEmpty(loginPassword)){
           ToastUtil.showWarningToast("请输入登录密码",getActivity());
        }else{
            if(TextUtils.isEmpty(transactionPassword)){
                ToastUtil.showWarningToast("请输入交易密码",getActivity());
            }else{
                ToastUtil.showSuccessToast("注册成功",getActivity());
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        }
    }
}
