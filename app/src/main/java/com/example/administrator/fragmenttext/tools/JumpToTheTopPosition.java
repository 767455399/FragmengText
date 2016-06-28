package com.example.administrator.fragmenttext.tools;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/25 13:45
 * 修改人：WangQing
 * 修改时间：2016/3/25 13:45
 * 修改备注：
 */
public class JumpToTheTopPosition {
private boolean move;
    public void moveToPosition(final int n,RecyclerView recyclerView) {

        final LinearLayoutManager mLinearLayoutManager=(LinearLayoutManager)recyclerView.getLayoutManager();
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mLinearLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem ){
            //当要置顶的项在当前显示的第一个项的前面时
            recyclerView.scrollToPosition(n);
        }else if ( n <= lastItem ){
            //当要置顶的项已经在屏幕上显示时
            int top = recyclerView.getChildAt(n - firstItem).getTop();
            recyclerView.scrollBy(0, top);
        }else{
            //当要置顶的项在当前显示的最后一项的后面时
            recyclerView.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
            move = true;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (move) {
                    move = false;
                    int offset = n - mLinearLayoutManager.findFirstVisibleItemPosition();
                    if (offset >= 0 && offset <= recyclerView.getChildCount()) {
                        recyclerView.scrollBy(0, recyclerView.getChildAt(offset).getTop());
                    }
                }
            }
        });

    }


}
