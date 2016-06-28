package com.example.administrator.fragmenttext.maillist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/2/26 10:06
 * 修改人：WangQing
 * 修改时间：2016/2/26 10:06
 * 修改备注：
 */
public class SideBar extends View {
    public static float RATIO;
    public  int textSize;
    // 触摸事件
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    // 26个字母
    public static String[] b = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#" };
    private int choose = -1;// 选中
    private Paint paint = new Paint();

    private TextView mTextDialog;

    public void setTextView(TextView mTextDialog) {
        this.mTextDialog = mTextDialog;
    }

    public SideBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SideBar(Context context) {
        super(context);
    }

    /**
     * 重写这个方法
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取焦点改变背景颜色.
        int height = getHeight();// 获取对应高度
        int width = getWidth(); // 获取对应宽度
        int singleHeight = height / b.length;// 获取每一个字母的高度

        for (int i = 0; i < b.length; i++) {
        //  paint.setColor(Color.rgb(33, 65, 98));
        //  paint.setColor(Color.BLUE);
            paint.setColor(Color.parseColor("#1abce8"));
            paint.setAntiAlias(true);
          /*  如果直接设置字体的大小，会出现在不同的分辨率上，字体大小不一样这种情况；*/
          /*  paint.setTextSize(40);*/
            paint.setTextSize(getTextSize());
            // 选中的状态
            if (i == choose) {
                paint.setColor(Color.parseColor("#EFEFF4"));
   //             paint.setColor(Color.parseColor("#CCCCCC"));
                paint.setFakeBoldText(true);
            }
            // x坐标等于中间-字符串宽度的一半.
            float xPos = width / 2 - paint.measureText(b[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(b[i], xPos, yPos, paint);
            paint.reset();// 重置画笔
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();// 点击y坐标
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * b.length);// 点击y坐标所占总高度的比例*b数组的长度就等于点击b中的个数.

        switch (action) {
            case MotionEvent.ACTION_UP:
                /*setBackgroundDrawable(new ColorDrawable(0x00000000));*/
                setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EFEFF4")));
//                setBackgroundColor(Color.parseColor("#66000000"));
                choose = -1;//
                invalidate();
                if (mTextDialog != null) {
                    mTextDialog.setVisibility(View.INVISIBLE);
                }
                break;

            default:
                setBackgroundColor(Color.parseColor("#EFEFF4"));
//                setBackgroundResource(R.drawable.sidebar_background);
                if (oldChoose != c) {
                    if (c >= 0 && c < b.length) {
                        if (listener != null) {
                            listener.onTouchingLetterChanged(b[c]);
                        }
                        if (mTextDialog != null) {
                            mTextDialog.setText(b[c]);
                            mTextDialog.setVisibility(View.VISIBLE);
                        }

                        choose = c;
                        invalidate();
                    }
                }

                break;
        }
        return true;
    }

    /**
     * 向外公开的方法
     *
     * @param onTouchingLetterChangedListener
     */
    public void setOnTouchingLetterChangedListener(
            OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    /**
     * 接口
     *
     * @author coder
     *
     */
    public interface OnTouchingLetterChangedListener {
        public void onTouchingLetterChanged(String s);
    }


    /*根据屏幕的分辨率来设置字体的大小,保证字体大小不变*/
    public int getTextSize() {
       /* 1.获取当前设备的屏幕大小*/
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        float screenWidth = dm2.widthPixels;
        float screenHeight = dm2.heightPixels;
      /*  2.计算与你开发时设定的屏幕大小的纵横比(这里假设你开发时定的屏幕大小是480*800)*/


        float ratioWidth = (float) screenWidth / 1080;
        float ratioHeight = (float) screenHeight / 1920;

        RATIO = Math.min(ratioWidth, ratioHeight);
        /*if (ratioWidth != ratioHeight) {
            if (RATIO == ratioWidth) {
                OFFSET_LEFT = 0;
                OFFSET_TOP = Math.round((screenHeight - 800 * RATIO) / 2);
            }else {
                OFFSET_LEFT = Math.round((screenWidth - 480 * RATIO) / 2);
                OFFSET_TOP = 0;
            }
        }*/

      /*  3.根据上一步计算出来的最小纵横比来确定字体的大小(假定在480*800屏幕下字体大小设定为35)*/

        textSize = Math.round(40 * RATIO);

       /* 4.根据上一步计算的字体大小来设定应用程序中字体的大小*/

        return textSize;
    }

}
