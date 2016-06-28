package com.example.administrator.fragmenttext.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/10 15:02
 * 修改人：WangQing
 * 修改时间：2015/12/10 15:02
 * 修改备注：
 */
public class CameraActivity extends BaseActivity implements View.OnClickListener {
    private Button takePhoto;
    private Button originalPhoto;
    private Button customCamera;
    private ImageView photoImageView;
    //图片路劲；
    private String photoFile;
    //获取系统返回的压缩照片；
    private static int RQ = 1;
    //获取相机的原图；
    private static int RQ1 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //图片保存路劲；
        photoFile = Environment.getExternalStorageDirectory().getPath();
        photoFile = photoFile + "/" + "wang.png";

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
        originalPhoto.setOnClickListener(this);
    }

    public void photograph(View view) {
        //调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, RQ);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.camera);
        photoImageView = (ImageView) findViewById(R.id.imageView);
        originalPhoto = (Button) findViewById(R.id.originalPhoto);
        customCamera=(Button)findViewById(R.id.customCamera);
        customCamera.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RQ) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                photoImageView.setImageBitmap(bitmap);
            } else if (requestCode == RQ1) {
              /*  Bitmap bitmap1=transImage(photoFile,480,800);
                photoImageView.setImageBitmap(bitmap1);*/
               /* FileInputStream fileInputStream = null;
                try {
                    fileInputStream=new FileInputStream(photoFile);
                    Bitmap bitmap1= BitmapFactory.decodeStream(fileInputStream);
                    photoImageView.setImageBitmap(bitmap1);
                   *//* 100*100*//*
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
                //将保存在本地的图片取出并缩小后显示在界面上
                Bitmap camorabitmap = BitmapFactory.decodeFile(photoFile);
                if (null != camorabitmap) {
                    // 下面这两句是对图片按照一定的比例缩放，这样就可以完美地显示出来。
                    int scale = reckonThumbnail(camorabitmap.getWidth(), camorabitmap.getHeight(), 800, 1280);
                   Bitmap bitmap = PicZoom(camorabitmap, camorabitmap.getWidth() /scale, camorabitmap.getHeight() /scale);
                    //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                    doCropPhoto(bitmap);
                    camorabitmap.recycle();
                    //将处理过的图片显示在界面上，并保存到本地
                    photoImageView.setImageBitmap(bitmap);


                }
            }
        }
    }

    protected void doCropPhoto(Bitmap data) {
        Intent intent = getCropImageIntent(data);
        startActivityForResult(intent, RQ1);
    }

    /* Matrix压缩法*/
    public Bitmap transImage(String fromFile, int width, int height) {
        Bitmap bitmap = BitmapFactory.decodeFile(fromFile);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        // 缩放图片的尺寸
        float scaleWidth = (float) width / bitmapWidth;
        float scaleHeight = (float) height / bitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        // 产生缩放后的Bitmap对象
        Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth,
                bitmapHeight, matrix, false);

        if (!bitmap.isRecycled()) {
            bitmap.recycle();// 记得释放资源，否则会内存溢出
        }
        if (!resizeBitmap.isRecycled()) {
            resizeBitmap.recycle();
        }
        return resizeBitmap;
    }

    public static int reckonThumbnail(int oldWidth, int oldHeight, int newWidth, int newHeight) {
        if ((oldHeight > newHeight && oldWidth > newWidth)
                || (oldHeight <= newHeight && oldWidth > newWidth)) {
            int be = (int) (oldWidth / (float) newWidth);
            if (be <= 1)
                be = 1;
            return be;
        } else if (oldHeight > newHeight && oldWidth <= newWidth) {
            int be = (int) (oldHeight / (float) newHeight);
            if (be <= 1)
                be = 1;
            return be;
        }
        return 1;
    }

    public static Bitmap PicZoom(Bitmap bmp, int width, int height) {
        int bmpWidth = bmp.getWidth();
        int bmpHeght = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) width / bmpWidth, (float) height / bmpHeght);

        return Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeght, matrix, true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.originalPhoto:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri = Uri.fromFile(new File(photoFile));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, RQ1);
                break;
            case R.id.customCamera:
                startActivity(new Intent(CameraActivity.this,CustomCameraActivity.class));

                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //裁剪照片
    public static Intent getCropImageIntent(Bitmap data) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");
        intent.putExtra("data", data);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 128);
        intent.putExtra("outputY", 128);
        intent.putExtra("return-data", true);
        return intent;
    }
}
