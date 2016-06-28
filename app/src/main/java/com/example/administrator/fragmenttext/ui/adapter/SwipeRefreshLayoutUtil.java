package com.example.administrator.fragmenttext.ui.adapter;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/12 16:05
 * 修改人：WangQing
 * 修改时间：2016/1/12 16:05
 * 修改备注：
 */
public class SwipeRefreshLayoutUtil {

    public static void initStyle(SwipeRefreshLayout swipeRefreshLayout) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(
                    R.color.loading_color_1,
                    R.color.loading_color_2,
                    R.color.loading_color_3,
                    R.color.loading_color_4,
                    R.color.loading_color_5);
        }
    }

}
