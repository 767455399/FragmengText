package com.example.administrator.fragmenttext.addresspick;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/28 10:47
 * 修改人：WangQing
 * 修改时间：2016/1/28 10:47
 * 修改备注：
 */
public class FullyGriView extends LinearLayout{
    private BaseAdapter adapter;
    private OnItemClickListener listener;
    public FullyGriView(Context context) {
        super(context);
    }

    public FullyGriView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullyGriView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FullyGriView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setAdapter(BaseAdapter adapter,int lineHeight){
        this.adapter = adapter;
        removeAllViews();
        int itemCount = adapter.getCount();
        if (itemCount > 0) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setMotionEventSplittingEnabled(false);
            linearLayout.setWeightSum(4);
            addView(linearLayout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            for (int i = 0; i < itemCount; i++) {
                View view = adapter.getView(i, null, null);
                final int finalI = i;
                view.findViewById(R.id.itemIndexServiceView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(finalI);
                        }
                    }
                });
                view.setLayoutParams(new LayoutParams(lineHeight, lineHeight));
                if (linearLayout.getChildCount() < 4) {
                    linearLayout.addView(view);
                } else {
                    linearLayout = new LinearLayout(getContext());
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    linearLayout.setMotionEventSplittingEnabled(false);
                    linearLayout.setWeightSum(4);
                    linearLayout.addView(view);
                    addView(linearLayout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                }
            }
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnItemClickListener {
        void onClick(int position);
    }
}
