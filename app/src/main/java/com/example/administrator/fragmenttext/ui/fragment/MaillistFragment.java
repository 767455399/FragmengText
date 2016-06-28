package com.example.administrator.fragmenttext.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.ui.activity.CheckWorkAttendanceActivity;
import com.example.administrator.fragmenttext.ui.activity.FamousQuotesActivity;
import com.example.administrator.fragmenttext.ui.activity.JobInformationActivity;
import com.example.administrator.fragmenttext.ui.activity.MyNetworkActivity;
import com.example.administrator.fragmenttext.ui.activity.NbaActivity;
import com.example.administrator.fragmenttext.ui.activity.QRCodeScanActivity;
import com.example.administrator.fragmenttext.ui.activity.ShopInformationActivity;
import com.example.administrator.fragmenttext.ui.activity.VoiceSMSActivity;
import com.example.administrator.fragmenttext.ui.activity.WeatherForecastActivity;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 16:13
 * 修改人：WangQing
 * 修改时间：2015/12/1 16:13
 * 修改备注：
 */
public class MaillistFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private TextView nba;
    private TextView shangpin;
    private TextView kaoqin;
    private TextView gongzuo;
    private TextView wangdian;
    private TextView famousQuotes;
    private TextView weather;
    private TextView erweima;
    private TextView voiceSMS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.fragment_maillist,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        nba=(TextView)view.findViewById(R.id.nba);
        shangpin=(TextView)view.findViewById(R.id.shangpin);
        kaoqin=(TextView)view.findViewById(R.id.kaoqin);
        gongzuo=(TextView)view.findViewById(R.id.gongzuo);
        wangdian=(TextView)view.findViewById(R.id.wangdian);
        famousQuotes=(TextView)view.findViewById(R.id.famousQuotes);
        weather=(TextView)view.findViewById(R.id.weather);
        erweima=(TextView)view.findViewById(R.id.erweima);
        voiceSMS=(TextView)view.findViewById(R.id.voiceSMS);
        nba.setOnClickListener(this);
        shangpin.setOnClickListener(this);
        kaoqin.setOnClickListener(this);
        gongzuo.setOnClickListener(this);
        wangdian.setOnClickListener(this);
        famousQuotes.setOnClickListener(this);
        weather.setOnClickListener(this);
        erweima.setOnClickListener(this);
        voiceSMS.setOnClickListener(this);

    }




    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nba:
                Intent intent=new Intent(getActivity(), NbaActivity.class);
                startActivity(intent);
                break;
            case R.id.shangpin:
                Intent intent1=new Intent(getActivity(), ShopInformationActivity.class);
                startActivity(intent1);
                break;
            case R.id.kaoqin:
                Intent intent2=new Intent(getActivity(), CheckWorkAttendanceActivity.class);
                startActivity(intent2);
                break;
            case R.id.gongzuo:
                Intent intent3=new Intent(getActivity(), JobInformationActivity.class);
                startActivity(intent3);
                break;
            case R.id.wangdian:
                Intent intent4=new Intent(getActivity(), MyNetworkActivity.class);
                startActivity(intent4);
                break;
            case R.id.famousQuotes:
                Intent intent5=new Intent(getActivity(), FamousQuotesActivity.class);
                startActivity(intent5);
                break;
            case R.id.weather:
                Intent intent6=new Intent(getActivity(), WeatherForecastActivity.class);
                startActivity(intent6);
                break;
            case R.id.erweima:
                QRCodeScanActivity.startForScanResult(MaillistFragment.this);
                break;
            case R.id.voiceSMS:
                Intent intent7=new Intent(getActivity(), VoiceSMSActivity.class);
                startActivity(intent7);
                break;
            default:
                break;
        }
    }





}
