package com.example.administrator.fragmenttext.widget.roboto;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.example.administrator.fragmenttext.widget.FontPath;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/17 18:03
 * 修改人：WangQing
 * 修改时间：2015/12/17 18:03
 * 修改备注：
 */
public class RobotoNormalTextView extends AppCompatTextView {

    public RobotoNormalTextView(Context context) {
        this(context, null);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        setTypeface(Typeface.createFromAsset(context.getAssets(), FontPath.NORMAL));
    }

    public RobotoNormalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        setTypeface(Typeface.createFromAsset(context.getAssets(), FontPath.NORMAL));
    }

    public RobotoNormalTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        setTypeface(Typeface.createFromAsset(context.getAssets(), FontPath.NORMAL));
    }
}
