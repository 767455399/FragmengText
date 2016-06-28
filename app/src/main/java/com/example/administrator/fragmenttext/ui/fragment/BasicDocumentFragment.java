package com.example.administrator.fragmenttext.ui.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.anim.SuccessView;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.jack.anim.JackAnim;
import com.jack.anim.Techniques;

import java.util.zip.Inflater;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/16 18:32
 * 修改人：WangQing
 * 修改时间：2015/12/16 18:32
 * 修改备注：
 */
public class BasicDocumentFragment extends BaseFragment{
    View view;
    private SuccessView dataSubmittedSuccessfullySuccessView;
    private RelativeLayout dataSubmittedSuccessfullyRelativeLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_basicdocument,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        dataSubmittedSuccessfullySuccessView=(SuccessView)view.findViewById(R.id.dataSubmittedSuccessfullySuccessView);
        dataSubmittedSuccessfullyRelativeLayout=(RelativeLayout)view.findViewById(R.id.dataSubmittedSuccessfullyRelativeLayout);

    }

    @Override
    protected void loadDate() {
        JackAnim.with(Techniques.FadeIn).duration(700).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                dataSubmittedSuccessfullyRelativeLayout.setAlpha(1f);
                dataSubmittedSuccessfullySuccessView.startAnim();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(dataSubmittedSuccessfullyRelativeLayout);
    }
}
