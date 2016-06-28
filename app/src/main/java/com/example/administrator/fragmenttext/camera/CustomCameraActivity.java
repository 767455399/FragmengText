package com.example.administrator.fragmenttext.camera;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/18 19:43
 * 修改人：WangQing
 * 修改时间：2015/12/18 19:43
 * 修改备注：
 */
public class CustomCameraActivity extends BaseActivity implements View.OnClickListener {
    private Camera myCamera;
    private Button takePhotoButton;
    private SurfaceView surfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        setContentView(R.layout.activity_custom_camera);
        takePhotoButton=(Button)findViewById(R.id.takePhotoButton);
        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        takePhotoButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.takePhotoButton:
                break;
            default:
                break;
        }
    }
}
