package com.example.administrator.fragmenttext.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.fragmenttext.R;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/21 20:01
 * 修改人：WangQing
 * 修改时间：2015/12/21 20:01
 * 修改备注：
 */
public class FragmentUtil {


    public static void replace(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean addToBackStack, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.replace(containerId, fragment, tag);
        fragmentTransaction.commit();
    }

    public static void replaceWithAnim(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean addToBackStack, String tag) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_in, R.anim.fragment_out, R.anim.fragment_pop_in, R.anim.fragment_pop_out);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.replace(containerId, fragment, tag);
        fragmentTransaction.commit();
    }

}
