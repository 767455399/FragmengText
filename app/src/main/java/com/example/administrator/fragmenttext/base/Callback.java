package com.example.administrator.fragmenttext.base;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/7 16:23
 * 修改人：WangQing
 * 修改时间：2016/1/7 16:23
 * 修改备注：
 */
public interface Callback<T> {
    /**
     * @param object
     */
    void onSucceed(T object);

    /**
     * @param
     * @param str
     */
    void onFailed(String str);
}
