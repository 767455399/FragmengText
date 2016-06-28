package com.example.administrator.fragmenttext.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.ui.adapter.ScrollView;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 16:09
 * 修改人：WangQing
 * 修改时间：2015/12/1 16:09
 * 修改备注：
 */
public class WeChatFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private Button weChatButton;
    private TextView  textView;
    private ScrollView  myScrollView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_wechat,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        weChatButton=(Button)view.findViewById(R.id.weChatButton);
        weChatButton.setOnClickListener(this);
        textView=(TextView)view.findViewById(R.id.textView);
        myScrollView=(ScrollView)view.findViewById(R.id.myScrollView);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weChatButton:
                controlJitter();
                weChatButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(),"微信",Toast.LENGTH_LONG).show();
           //   textView.scrollBy(-50,0);
                myScrollView.scrollBy();
                textView.setText("123");
                break;
            default:
                break;
        }
    }
   /* 控件抖动动画*/
    private void controlJitter() {
        Animation shakeAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.shake);
        textView.startAnimation(shakeAnim);
    }


}
