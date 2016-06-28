package com.example.administrator.fragmenttext.ui.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.ui.adapter.CountDown;
import com.example.administrator.fragmenttext.widget.ColorfulRingProgressView;
import com.example.administrator.fragmenttext.widget.SectorProgressView;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 16:05
 * 修改人：WangQing
 * 修改时间：2015/12/1 16:05
 * 修改备注：
 * <img src="../{@docRoot}/ui/FoundFragment.png"width="540" height="960"/>
 */
//{@docRoot}表示main下面的目录；..表示上一级目录；
public class FoundFragment extends BaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private View view;
    private Button FoundButton;
    private Button cancle;
    private CountDown countDown;
    private ColorfulRingProgressView crpv;
    private SeekBar currentValueSeekBar;
    private TextView vaiueTextView;
    private SeekBar valueSeekBar;
    private SectorProgressView spv;
    private TextView valueTextview;
    private SeekBar angleSeekBar;
    private TextView angleTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_found,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        FoundButton=(Button)view.findViewById(R.id.foundButton);
        FoundButton.setOnClickListener(this);
        cancle=(Button)view.findViewById(R.id.cancle);
        cancle.setOnClickListener(this);
        countDown=new CountDown(30*1000,1000,FoundButton);
        crpv=(ColorfulRingProgressView)view.findViewById(R.id.crpv);
        currentValueSeekBar=(SeekBar)view.findViewById(R.id.currentValueSeekBar);
        crpv.setOnClickListener(this);
        currentValueSeekBar.setOnSeekBarChangeListener(this);
        vaiueTextView=(TextView)view.findViewById(R.id.vaiueTextView);
        valueSeekBar=(SeekBar)view.findViewById(R.id.valueSeekBar);
        valueSeekBar.setOnSeekBarChangeListener(this);
        spv=(SectorProgressView)view.findViewById(R.id.spv);
        spv.setOnClickListener(this);
        valueTextview=(TextView)view.findViewById(R.id.valueTextview);
        angleSeekBar=(SeekBar)view.findViewById(R.id.angleSeekBar);
        angleTextView=(TextView)view.findViewById(R.id.angleTextview);
        angleSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void loadDate() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.foundButton:
              countDown.start();
                break;
            case R.id.cancle:
                countDown.cancel();
                break;
            case R.id.crpv:
                ObjectAnimator anim = ObjectAnimator.ofFloat(v, "percent",
                        0, ((ColorfulRingProgressView) v).getPercent());
                anim.setInterpolator(new LinearInterpolator());
                anim.setDuration(1000);
                anim.start();
                break;
            case R.id.spv:


        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==R.id.currentValueSeekBar){
            crpv.setPercent(progress);
            vaiueTextView.setText(progress+"");
        }
        if(seekBar.getId()==R.id.valueSeekBar){
            spv.setPercent(progress);
            valueTextview.setText("值"+progress);
        }
        if(seekBar.getId()==R.id.angleSeekBar){

            spv.setStartAngle(progress);
            angleTextView.setText("值"+progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
