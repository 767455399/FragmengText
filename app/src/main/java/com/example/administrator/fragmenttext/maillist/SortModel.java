package com.example.administrator.fragmenttext.maillist;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/2/26 10:04
 * 修改人：WangQing
 * 修改时间：2016/2/26 10:04
 * 修改备注：
 */
public class SortModel {

    private String name; // 显示的数据
    private String sortLetters; // 显示数据拼音的首字母

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}