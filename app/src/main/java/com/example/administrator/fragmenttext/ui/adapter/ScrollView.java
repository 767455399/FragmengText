package com.example.administrator.fragmenttext.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/3 14:12
 * 修改人：WangQing
 * 修改时间：2015/12/3 14:12
 * 修改备注：
 */
public class ScrollView extends RelativeLayout {
    public ImageView img;
    public ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        img = new ImageView(context);
        img.setImageResource(R.mipmap.ic_launcher);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        img.setScaleType(ImageView.ScaleType.CENTER);
        addView(img, params);
    }

    public void scrollTo(){
        img.scrollTo(-10, -10);
    }

    public void scrollBy(){
        img.scrollBy(-10, -10);
    }

    public void reset(){
        img.scrollTo(0, 0);
    }
}