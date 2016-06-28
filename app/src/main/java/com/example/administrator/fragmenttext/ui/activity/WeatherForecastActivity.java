package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.WeatherModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.*;

public class WeatherForecastActivity extends BaseActivity implements View.OnClickListener {
    private String path = "http://api.avatardata.cn/Weather/Query?key=b9cae7faf7f54bc5ad05dc7fd1f493c4&cityname=";
    private RecyclerView weatherRecyclerView;
    private WeatherForecastAdapter weatherForecastAdapter;
    private EditText weatherEditText;
    private Button weatherButton;
    private List<WeatherModle.ResultEntity.WeatherEntity> weatherList = new ArrayList<>();
    private TextView kongtiaoTextView;
    private TextView yundongTextView;
    private TextView ziwaixianTextView;
    private TextView ganmaoTextView;
    private TextView xicheTextView;
    private TextView wuranTextView;
    private TextView chuanyiTextView;
    private List<String> kongtiaoList = new ArrayList<>();
    private List<String> yundongList = new ArrayList<>();
    private List<String> ziwaixianList = new ArrayList<>();
    private List<String> ganmaoList = new ArrayList<>();
    private List<String> xicheList = new ArrayList<>();
    private List<String> wuranList = new ArrayList<>();
    private List<String> chuanyiList = new ArrayList<>();
    String defaultAddress="武汉";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_weather_forecast);
        weatherRecyclerView = (RecyclerView) findViewById(R.id.weatherRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(HORIZONTAL);
        weatherRecyclerView.setLayoutManager(linearLayoutManager);
        weatherEditText = (EditText) findViewById(R.id.weatherEditText);
        weatherButton = (Button) findViewById(R.id.weatherButton);
        weatherButton.setOnClickListener(this);
        kongtiaoTextView = (TextView) findViewById(R.id.kongtiaoTextView);
        yundongTextView = (TextView) findViewById(R.id.yundongTextView);
        ziwaixianTextView = (TextView) findViewById(R.id.ziwaixianTextView);
        ganmaoTextView = (TextView) findViewById(R.id.ganmaoTextView);
        xicheTextView = (TextView) findViewById(R.id.xicheTextView);
        wuranTextView = (TextView) findViewById(R.id.wuranTextView);
        chuanyiTextView = (TextView) findViewById(R.id.chuanyiTextView);
        weatherEditText.setText("武汉");
        getDate(weatherEditText.getText().toString());
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        weatherForecastAdapter = new WeatherForecastAdapter();
        weatherRecyclerView.setAdapter(weatherForecastAdapter);

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    protected void getDate(String place) {
        if (TextUtils.isEmpty(place)) {
            ToastUtil.showWarningToast("请输入要查询的城市", WeatherForecastActivity.this);
            return;
        }
        if (DeviceUtil.isOnline(WeatherForecastActivity.this)) {
            showLoadingDialog();
            NetWork.getWeather(path, place, new myCallBack<WeatherModle>() {
                @Override
                public void Success(WeatherModle weatherModle) {
                    dismissLoadDialog();
                  if(weatherModle.getReason().equals("Succes")){
                      if(weatherList.size()>0){
                          weatherList.clear();
                      }
                      if (kongtiaoList.size()>0){
                          kongtiaoList.clear();
                      }
                      if(yundongList.size()>0){
                          yundongList.clear();
                      }
                      if(ziwaixianList.size()>0){
                          ziwaixianList.clear();
                      }
                      if(ganmaoList.size()>0){
                          ganmaoList.clear();
                      }
                      if(xicheList.size()>0){
                          xicheList.clear();
                      }
                      if(wuranList.size()>0){
                          wuranList.clear();
                      }
                      if(chuanyiList.size()>0){
                          chuanyiList.clear();
                      }
                      weatherList.addAll(weatherModle.getResult().getWeather());
                      weatherForecastAdapter.notifyDataSetChanged();
                      kongtiaoList.addAll(weatherModle.getResult().getLife().getInfo().getKongtiao());
                      yundongList.addAll(weatherModle.getResult().getLife().getInfo().getYundong());
                      ziwaixianList.addAll(weatherModle.getResult().getLife().getInfo().getZiwaixian());
                      ganmaoList.addAll(weatherModle.getResult().getLife().getInfo().getGanmao());
                      xicheList.addAll(weatherModle.getResult().getLife().getInfo().getXiche());
                      wuranList.addAll(weatherModle.getResult().getLife().getInfo().getWuran());
                      chuanyiList.addAll(weatherModle.getResult().getLife().getInfo().getChuanyi());
                      //空调
                      StringBuffer kongtiaosb=null;
                      kongtiaosb = new StringBuffer();
                      for (int i = 0; i < kongtiaoList.size()-1; i++) {
                          if(i==kongtiaoList.size()-2){
                              kongtiaosb.append("     "+kongtiaoList.get(i));
                              kongtiaoTextView.setText(kongtiaosb.toString());
                          }else{
                              kongtiaosb.append("     "+kongtiaoList.get(i)+"\n");
                          }
                      }

                      //运动
                      StringBuffer yundongsb=null;
                      yundongsb = new StringBuffer();
                      for (int i = 0; i < yundongList.size(); i++) {
                          yundongsb.append(yundongList.get(i));
                      }
                      yundongTextView.setText(yundongsb.toString());
                      //紫外线
                      StringBuffer zhiwaixiansb=null;
                      zhiwaixiansb = new StringBuffer();
                      for (int i = 0; i < ziwaixianList.size(); i++) {
                          zhiwaixiansb.append(ziwaixianList.get(i));
                      }
                      ziwaixianTextView.setText(zhiwaixiansb.toString());
                      //感冒
                      StringBuffer ganmaosb=null;
                      ganmaosb = new StringBuffer();
                      for (int i = 0; i < ganmaoList.size(); i++) {
                          ganmaosb.append(ganmaoList.get(i));
                      }
                      ganmaoTextView.setText(ganmaosb.toString());
                      //洗车
                      StringBuffer xichesb=null;
                      xichesb = new StringBuffer();
                      for (int i = 0; i < xicheList.size(); i++) {
                          xichesb.append(xicheList.get(i));
                      }
                      xicheTextView.setText(xichesb.toString());
                      //污染
                      StringBuffer wuransb=null;
                      wuransb = new StringBuffer();
                      for (int i = 0; i < wuranList.size(); i++) {
                          wuransb.append(wuranList.get(i));
                      }
                      wuranTextView.setText(wuransb.toString());
                      //穿衣
                      StringBuffer chuanyisb=null;
                      chuanyisb = new StringBuffer();
                      for (int i = 0; i < chuanyiList.size(); i++) {
                          chuanyisb.append(chuanyiList.get(i));
                      }
                      chuanyiTextView.setText(chuanyisb.toString());
                    }else{
                      dismissLoadDialog();
                      ToastUtil.showWarningToast("获取数据失败，请检查输入的城市是否正确",WeatherForecastActivity.this);
                  }


                }

                @Override
                public void Fail(String fail) {
                    dismissLoadDialog();
                    ToastUtil.showWarningToast(getString(R.string.failed_to_get_data), WeatherForecastActivity.this);
                }
            });
        } else {
            ToastUtil.showWarningToast(getString(R.string.please_check_the_network), WeatherForecastActivity.this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weatherButton:
                defaultAddress=null;
                String place = weatherEditText.getText().toString();
                getDate(place);
                break;
            default:
                break;
        }
    }

    class WeatherForecastAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(WeatherForecastActivity.this).inflate(R.layout.item_weather, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.dateTextView.setText(weatherList.get(position).getDate());
            holder.weekTextView.setText("星期" + weatherList.get(position).getWeek());
            holder.nongliTextView.setText(weatherList.get(position).getNongli());
            holder.wenduTextView.setText(weatherList.get(position).getInfo().getDay().get(0) + "--" + weatherList.get(position).getInfo().getDay().get(2) + "度");
            holder.tianqiTextView.setText(weatherList.get(position).getInfo().getDay().get(1));
            holder.fengliTextView.setText(weatherList.get(position).getInfo().getDay().get(3) + "--" + weatherList.get(position).getInfo().getDay().get(4));

        }

        @Override
        public int getItemCount() {
            return weatherList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTextView;
        private TextView weekTextView;
        private TextView nongliTextView;
        private TextView tianqiTextView;
        private TextView fengliTextView;
        private TextView wuranTextView;
        private TextView wenduTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            weekTextView = (TextView) itemView.findViewById(R.id.weekTextView);
            nongliTextView = (TextView) itemView.findViewById(R.id.nongliTextView);
            tianqiTextView = (TextView) itemView.findViewById(R.id.tianqiTextView);
            fengliTextView = (TextView) itemView.findViewById(R.id.fengliTextView);
            wenduTextView = (TextView) itemView.findViewById(R.id.wenduTextView);
        }
    }
}
