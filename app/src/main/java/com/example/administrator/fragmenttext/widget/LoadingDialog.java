package com.example.administrator.fragmenttext.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/25 14:58
 * 修改人：WangQing
 * 修改时间：2016/3/25 14:58
 * 修改备注：
 */
public class LoadingDialog extends Dialog{
    public LoadingDialog(Context context) {
        super(context, R.style.LoadingDialogStyle);
        View rootView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(rootView);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
