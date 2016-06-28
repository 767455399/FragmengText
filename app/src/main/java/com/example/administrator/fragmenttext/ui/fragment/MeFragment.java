package com.example.administrator.fragmenttext.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.dialog.CommonDialog;
import com.example.administrator.fragmenttext.ui.activity.JobInformationActivity;
import com.example.administrator.fragmenttext.ui.activity.MyQrCodeActivity;


import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 15:37
 * 修改人：WangQing
 * 修改时间：2015/12/1 15:37
 * 修改备注：
 */
public  class MeFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private LinearLayout QRCodeLinearLayout;
    private ImageView headPortraitImageView;
    private LinearLayout viewDataLinearLayout;
    private LinearLayout nameLinearLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_personal_data,container,false);
        return view;
    }



    protected void initView(View view) {
        QRCodeLinearLayout=(LinearLayout)view.findViewById(R.id.QRCodeLinearLayout);
        QRCodeLinearLayout.setOnClickListener(this);
        viewDataLinearLayout=(LinearLayout)view.findViewById(R.id.viewDataLinearLayout);
        viewDataLinearLayout.setOnClickListener(this);
        headPortraitImageView=(ImageView)view.findViewById(R.id.headPortraitImageView);
        nameLinearLayout=(LinearLayout)view.findViewById(R.id.nameLinearLayout);
        nameLinearLayout.setOnClickListener(this);
        Picasso.with(getActivity()).load("http://g.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917914baed1cd3d70cf3ac7578a.jpg").placeholder(R.drawable.b).error(R.drawable.c).into(headPortraitImageView);
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.QRCodeLinearLayout:
                Intent intent1=new Intent(getActivity(), MyQrCodeActivity.class);
                startActivity(intent1);
                break;
            case R.id.viewDataLinearLayout:
                Intent intent=new Intent(getActivity(), JobInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.nameLinearLayout:
                CommonDialog commonDialog=new CommonDialog(getActivity(),"温馨提示","暂时没有名字信息",new CommonDialog.Listener(){

                    @Override
                    public void onLeftButtonClick() {

                    }

                    @Override
                    public void onRightButtonClick() {
                        Toast.makeText(getActivity(),"没有获取到名字",Toast.LENGTH_SHORT).show();
                    }
                });
                commonDialog.setLeftButtonText("北京");
                commonDialog.setRightButtonText("上海");
                commonDialog.show();

                break;
            default:
                break;
        }
    }
}
