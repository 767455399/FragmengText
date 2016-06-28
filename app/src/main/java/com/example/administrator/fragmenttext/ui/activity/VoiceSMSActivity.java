package com.example.administrator.fragmenttext.ui.activity;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.ProductInformationModle;
import com.example.administrator.fragmenttext.model.weather.VoiceSMSModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.tools.Location;

import java.util.Random;

public class VoiceSMSActivity extends BaseActivity {
private String path="http://api.avatardata.cn/VoiceCode/Send?key=71aed1f497ac4d35bb3a848efdca21ca&tel=15158857404&verifyCode=658766&times=3";
    private Button button;
    private EditText phoneNumberEditText;
    private String phoneNumber;
    private TextView voiceSMSTextView;
    private TextView locationTextView;
    private Location location;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_voice_sms);
        location=new Location(VoiceSMSActivity.this);
        phoneNumberEditText=(EditText)findViewById(R.id.phoneNumberEditText);
        button=(Button)findViewById(R.id.button);
        voiceSMSTextView=(TextView)findViewById(R.id.voiceSMSTextView);
        locationTextView=(TextView)findViewById(R.id.locationTextView);
        getLocation();

    }
     public void getLocation() {
            location.setCallBack(new Location.LocationCallBack() {
                @Override
                public void getLocation(String address) {
                    if(null!=address){
                        locationTextView.setText("当前所在城市："+address);
                        location.stopLocation();
                    }

                }
            });
    }

    public interface Listener{
        void callback();
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DeviceUtil.isOnline(VoiceSMSActivity.this)){
                    button.setText("语音验证码发送中");
                    final int radomInt = new Random().nextInt(99999);
                    phoneNumber=phoneNumberEditText.getText().toString();
                    if(TextUtils.isEmpty(phoneNumber)){
                        path="http://api.avatardata.cn/VoiceCode/Send?key=71aed1f497ac4d35bb3a848efdca21ca&tel=15958044817&verifyCode="+String.valueOf(radomInt)+"&times=3";
                    }else{
                        path="http://api.avatardata.cn/VoiceCode/Send?key=71aed1f497ac4d35bb3a848efdca21ca&tel="+phoneNumber+"&verifyCode="+String.valueOf(radomInt)+"&times=3";
                    }

                    NetWork.getVoiceSMS(path, new myCallBack<VoiceSMSModle>() {
                        @Override
                        public void Success(VoiceSMSModle voiceSMSModle) {
                            if(voiceSMSModle.isSuccess()){
                                ToastUtil.showSuccessToast("发送语音验证码成功",VoiceSMSActivity.this);
                                button.setText("发送语音短信");
                                voiceSMSTextView.setText("语音验证码为"+Integer.toString(radomInt));
                            }
                        }

                        @Override
                        public void Fail(String fail) {
                            button.setText("发送语音短信");
                            ToastUtil.showSuccessToast("发送语音验证码失败",VoiceSMSActivity.this);
                        }
                    });
                }
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
}
