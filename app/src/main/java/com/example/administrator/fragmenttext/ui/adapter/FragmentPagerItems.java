package com.example.administrator.fragmenttext.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.example.administrator.fragmenttext.ui.fragment.ContactsFragment;
import com.example.administrator.fragmenttext.ui.fragment.DocumentInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.NbaYesterdayFragmnet;
import com.example.administrator.fragmenttext.ui.fragment.PersonalCenterFragment;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/16 16:39
 * 修改人：WangQing
 * 修改时间：2015/12/16 16:39
 * 修改备注：
 */
public class FragmentPagerItems extends PagerItems<FragmentPagerItem> {

    public FragmentPagerItems(Context context) {
        super(context);
    }

    public static Creator with(Context context) {
        return new Creator(context);
    }

    public static class Creator {

        private final FragmentPagerItems items;

        public Creator(Context context) {
            items = new FragmentPagerItems(context);
        }

        public Creator add(@StringRes int title, Class<? extends Fragment> clazz) {
            return add(FragmentPagerItem.of(items.getContext().getString(title), clazz));
        }

        public Creator add(@StringRes int title, Class<? extends Fragment> clazz, Bundle args) {
            return add(FragmentPagerItem.of(items.getContext().getString(title), clazz, args));
        }

        public Creator add(@StringRes int title, float width, Class<? extends Fragment> clazz) {
            return add(FragmentPagerItem.of(items.getContext().getString(title), width, clazz));
        }

        public Creator add(@StringRes int title, float width, Class<? extends Fragment> clazz,
                           Bundle args) {
            return add(FragmentPagerItem.of(items.getContext().getString(title), width, clazz, args));
        }

        public Creator add(CharSequence title, Class<ContactsFragment> clazz) {
            return add(FragmentPagerItem.of(title, clazz));
        }

        public Creator add(CharSequence title, Class<? extends Fragment> clazz, Bundle args) {
            return add(FragmentPagerItem.of(title, clazz, args));
        }

        public Creator add(FragmentPagerItem item) {
            items.add(item);
            return this;
        }

        public FragmentPagerItems create() {
            return items;
        }



    }

}