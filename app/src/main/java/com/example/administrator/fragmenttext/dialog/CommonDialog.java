package com.example.administrator.fragmenttext.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/31 10:47
 * 修改人：WangQing
 * 修改时间：2015/12/31 10:47
 * 修改备注：
 */
public class CommonDialog extends Dialog {
    private TextView titleTextView;
    private TextView contentTextView;
    private Button leftSure,rigntCancle;
    private Context context;
    public CommonDialog(Context context) {
        super(context);
    }

    public CommonDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public CommonDialog(Context context, String titleString, String content,final Listener listener) {
        super(context, R.style.CommonCenterDialogStyle);
        this.context=context;
        View view= LayoutInflater.from(context).inflate(R.layout.dialog_common,null);
        leftSure=(Button) view.findViewById(R.id.leftSure);
        rigntCancle=(Button) view.findViewById(R.id.rigntCancle);
        titleTextView=(TextView)view.findViewById(R.id.titleTextView);
        contentTextView=(TextView)view.findViewById(R.id.contentTextView);
        rigntCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onRightButtonClick();
            }
        });
        leftSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onLeftButtonClick();
            }
        });
        contentTextView.setText(content);
        titleTextView.setText(titleString);
        setCanceledOnTouchOutside(false);
        setContentView(view);

    }
    public void setContentTextSize(float size){
        contentTextView.setTextSize(size);
    }
    public void setLeftButtonListener(View.OnClickListener listener){
        leftSure.setOnClickListener(listener);
    }
    public void setRightButtonListener(View.OnClickListener listener){
        rigntCancle.setOnClickListener(listener);
    }
    public void setLeftButtonText(String str){
        leftSure.setText(str);
    }
    public void setRightButtonText(String str){
        rigntCancle.setText(str);
    }
    public void setLeftButtonText(int stringRes){
        leftSure.setText(context.getString(stringRes));
    }
    public void setRightButtonText(int stringRes){
        rigntCancle.setText(context.getString(stringRes));
    }

    public interface Listener {
        void onLeftButtonClick();

        void onRightButtonClick();
    }
}
