package com.example.administrator.fragmenttext.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/25 15:31
 * 修改人：WangQing
 * 修改时间：2015/12/25 15:31
 * 修改备注：
 */
public class MyQrCodeActivity extends BaseActivity{
    private ImageView qrImageView;
    private ImageView headPortraitImageView;
    int imagewidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        setContentView(R.layout.activity_my_qr_code);
        qrImageView=(ImageView)findViewById(R.id.qrImageView);
        headPortraitImageView=(ImageView)findViewById(R.id.headPortraitImageView);
        Picasso.with(MyQrCodeActivity.this).load("http://g.hiphotos.baidu.com/image/pic/item/94cad1c8a786c917914baed1cd3d70cf3ac7578a.jpg").placeholder(R.drawable.b).error(R.drawable.c).into(headPortraitImageView);
       /* 在界面初始化时获取imageview的宽和高，因为界面初始化绘制控件需要一定的时间，在控件绘制完成前去获取界面的宽高是获取不到的，
        这时我们要开启一个线程来监听控件是否绘制完成，这个线程仍然是在主线程中，而且这个线程被放在了最后执行，所以在它执行之前，界面已经绘制好了，这个时候我们就可以得到我们想要的界面的宽高了。
        */

        qrImageView.post(new Runnable() {
            @Override
            public void run() {
                imagewidth=(qrImageView.getWidth());
                try {
                    qrImageView.setImageBitmap(Create2DCode("767455399",imagewidth,imagewidth));
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * 用字符串生成二维码
     * @param
     * @return
     * @throws WriterException
     */
    public static Bitmap Create2DCode(String text,int qrwidth,int qrheight ) throws WriterException {

        //生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    //  hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, qrwidth, qrheight,hints);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        //二维矩阵转为一维像素数组,也就是一直横着排了
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(matrix.get(x, y)){
                    pixels[y * width + x] = 0xff000000;
                } else {
                    pixels[y * width + x] = 0xffffffff;
                }

            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //通过像素数组生成bitmap,具体参考api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
