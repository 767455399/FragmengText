package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.fragmenttext.Handler.MyHandlerActivity;
import com.example.administrator.fragmenttext.Handler.StandardHandlerActivity;
import com.example.administrator.fragmenttext.Handler.TreadNewActivity;
import com.example.administrator.fragmenttext.Linegraph.BarChartActivity;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.addresspick.Cities;
import com.example.administrator.fragmenttext.addresspick.PlacePickerUI;
import com.example.administrator.fragmenttext.addresspick.Province;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.dialog.AddressDialog;
import com.example.administrator.fragmenttext.location.LocationCallBack;
import com.example.administrator.fragmenttext.maillist.MailListActivity;
import com.example.administrator.fragmenttext.post.PostActivity;
import com.example.administrator.fragmenttext.recyclerview.HeaderViewRecyclerView;
import com.example.administrator.fragmenttext.startactivityforresult.StartActivityForResultActivity;
import com.example.administrator.fragmenttext.startup_mode.StandardActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.adapter.PhoneNumberUtils;
import com.example.administrator.fragmenttext.ui.adapter.StringUtil;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：phontEditText
 * 创建人：WangQing
 * 创建时间：2016/1/4 10:04
 * 修改人：WangQing
 * 修改时间：2016/1/4 10:04
 * 修改备注：
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private CheckBox passedwordChecked;
    private EditText passwordEditText;
    private EditText phontEditText;
    private Button loginButton;
    private Button registerButton;
    private AddressDialog addressDialog;
    List<Province> data = new ArrayList<>();
    private TextView locationTextView;

    private void init() {
        startActivity(new Intent(this,LocationActivity.class));
        LocationActivity.getLocation(new LocationCallBack() {
            @Override
            public void returnAddress(final String address) {
                       /* 这里我们直接用Gson解析返回的数据；*/
                ToastUtil.showSuccessToast(address,LoginActivity.this);
                locationTextView.setText(address+"");
            }
        });

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
        setContentView(R.layout.activity_login);
        parseJson(Cities.jsonData);
        PlacePickerUI mPickerUI = (PlacePickerUI)findViewById(R.id.place_picker);
        passedwordChecked = (CheckBox) findViewById(R.id.passedwordChecked);
        passedwordChecked.setOnCheckedChangeListener(passedwordCheckededListener);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        phontEditText = (EditText) findViewById(R.id.phontEditText);
        phontEditText.setText(Math.abs(-5)+"");
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);
        locationTextView=(TextView)findViewById(R.id.locationTextView);
        //默认不显示密码
        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        addressDialog = new AddressDialog();
        addressDialog.parseJson(Cities.jsonData, LoginActivity.this);
        init()
;        mPickerUI.setOnClickItemPickerUIListener(
                new PlacePickerUI.PlacePickerUIItemClickListener() {

                    @Override
                    public void onItemClickPickerUI(int which, int position, String valueResult) {
                        Toast.makeText(LoginActivity.this, valueResult + "第" + which + "列", Toast.LENGTH_SHORT).show();
                    }
                });
        mPickerUI.bindData(this,data);
    }

    CompoundButton.OnCheckedChangeListener passedwordCheckededListener = new CompoundButton.OnCheckedChangeListener() {
        /* edittext显示和隐藏代码*/
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                //密码可见；
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                //密码不可见；
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            passwordEditText.setSelection(passwordEditText.length());
        }
    };

    private boolean login(String phoneNum, String passward) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }
    private void parseJson(String jsonData){

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                Province province = new Gson().fromJson(jsonArray.get(i).toString(),Province.class);
                data.add(province);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        android.util.Log.d("ljx",data.get(1).getName());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
               /* ToastUtil.showSuccessToast(LocationActivity.Address, LoginActivity.this);*/
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                   /*  login();*/
                break;
            case R.id.registerButton:
               /* AddressDialog addressDialog=new AddressDialog();*/
               /* addressDialog.parseJson(Cities.jsonData ,LoginActivity.this);*/
              //  addressDialog.showDialog();
                addressDialog.showDialog();
                Intent intent = new Intent(LoginActivity.this, VoiceSMSActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void login() {
        //去掉用户输入手机号码时误添加的空格，这样可以避免用户不小心在输入手机号码时输入空格导致号码不正确，
        String phoneNum = StringUtil.removeSpace(phontEditText.getText().toString());
        String passWord = passwordEditText.getText().toString();
        if (TextUtils.isEmpty(phoneNum)) {
            ToastUtil.showWarningToast("请输入手机号码", LoginActivity.this);
        } else {
            if (PhoneNumberUtils.isMobileNO(phoneNum)) {
                if (TextUtils.isEmpty(passWord)) {
                    ToastUtil.showWarningToast("请输入密码", LoginActivity.this);
                } else {
                    login(phoneNum, passWord);
                }
            } else {
                ToastUtil.showWarningToast("请输入正确的手机号码", LoginActivity.this);
            }
        }
    }

    private void qingqiushuju() {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url("http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=0")
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                String htmlStr = response.body().string();
            }
        });
    }

}
