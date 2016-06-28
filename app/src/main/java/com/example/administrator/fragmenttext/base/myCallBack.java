package com.example.administrator.fragmenttext.base;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/22 17:21
 * 修改人：WangQing
 * 修改时间：2016/1/22 17:21
 * 修改备注：
 */
public interface myCallBack<T> {
    public void Success(T object);
    public void Fail(String fail);
}
