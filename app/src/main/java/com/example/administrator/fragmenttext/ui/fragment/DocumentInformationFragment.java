package com.example.administrator.fragmenttext.ui.fragment;

import android.content.Intent;
import android.database.CursorJoiner;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.camera.CameraActivity;

import java.io.File;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/28 14:42
 * 修改人：WangQing
 * 修改时间：2015/12/28 14:42
 * 修改备注：
 */
public class DocumentInformationFragment extends Fragment implements View.OnClickListener {
    /*通过FixRatioFrameLayout重写FrameLayout，将宽高比设置为二比一或者一比二，
    private boolean baseOnWith=true;通过baseOnWith的值来决定宽高比是二比一还是一比二，
    private float ratio=1;通过ratio的值来决定宽高比的比例；
    这样图片的宽高比例就不会随屏幕的变化而变化了*/
    private ImageView IdPhotoImageView;
    private String phoneFile="";
    private static final int WQ=1;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_document_information,container,false);
        initView();
        return view;

    }

    private void initView() {
        IdPhotoImageView=(ImageView)view.findViewById(R.id. IdPhotoImageView);
        IdPhotoImageView.setOnClickListener(this);
        phoneFile= Environment.getExternalStorageDirectory().getPath();
        phoneFile=phoneFile+"/"+"wangqing.png";
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.IdPhotoImageView:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri=Uri.fromFile(new File(phoneFile));
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
               startActivityForResult(intent,WQ);
        }
    }


}
