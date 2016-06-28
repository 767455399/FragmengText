package com.example.administrator.fragmenttext.addresspick;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/28 11:24
 * 修改人：WangQing
 * 修改时间：2016/1/28 11:24
 * 修改备注：
 */
public class FixRatioLinearLayout extends LinearLayout{
    private boolean baseOnWith = true;
    private float ratio = 1;
    public FixRatioLinearLayout(Context context) {
        super(context);
    }

    public FixRatioLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixRatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FixRatioFrameLayout);
        ratio = typedArray.getFloat(R.styleable.FixRatioFrameLayout_ratio, 1f);
        baseOnWith = typedArray.getBoolean(R.styleable.FixRatioFrameLayout_baseOnWidth, true);
        typedArray.recycle();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FixRatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (baseOnWith) {
            height = (int) (width * ratio);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        } else {
            width = (int) (height * ratio);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
