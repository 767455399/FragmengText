package com.example.administrator.fragmenttext.ui.adapter;

import android.text.TextUtils;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/28 11:42
 * 修改人：WangQing
 * 修改时间：2015/12/28 11:42
 * 修改备注：
 */
public class StringUtil {

    /**
     * 去掉所有空格
     *
     * @param string
     * @return
     */
    public static String removeSpace(String string) {
        String noSpaceStr = "";
        if (!TextUtils.isEmpty(string)) {
            noSpaceStr = string.trim().replace(" ", "");
        }
        return noSpaceStr;
    }

}
