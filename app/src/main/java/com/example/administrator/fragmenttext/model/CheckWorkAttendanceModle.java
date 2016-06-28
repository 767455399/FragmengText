package com.example.administrator.fragmenttext.model;

import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/22 16:58
 * 修改人：WangQing
 * 修改时间：2016/1/22 16:58
 * 修改备注：
 */
public class CheckWorkAttendanceModle {

    /**
     * leaveCount : null
     * mainExpress : null
     * saleAmount : null
     * score : null
     * scoreList : [[" ","旷工天数","0.0天","1",null,null],[" ","旷勤次数","0.0次","1",null,null],[" ","病假天数","0.0天","1",null,null],[" ","事假天数","0.0天","1",null,null]]
     * signErrorCount : null
     * success : true
     * uid : 全勤奖金
     * userName : null
     * yearMonthInfo : 2015-01-06
     */

    private Object leaveCount;
    private Object mainExpress;
    private Object saleAmount;
    private Object score;
    private Object signErrorCount;
    private boolean success;
    private String uid;
    private Object userName;
    private String yearMonthInfo;
    private List<List<String>> scoreList;

    public void setLeaveCount(Object leaveCount) {
        this.leaveCount = leaveCount;
    }

    public void setMainExpress(Object mainExpress) {
        this.mainExpress = mainExpress;
    }

    public void setSaleAmount(Object saleAmount) {
        this.saleAmount = saleAmount;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public void setSignErrorCount(Object signErrorCount) {
        this.signErrorCount = signErrorCount;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public void setYearMonthInfo(String yearMonthInfo) {
        this.yearMonthInfo = yearMonthInfo;
    }

    public void setScoreList(List<List<String>> scoreList) {
        this.scoreList = scoreList;
    }

    public Object getLeaveCount() {
        return leaveCount;
    }

    public Object getMainExpress() {
        return mainExpress;
    }

    public Object getSaleAmount() {
        return saleAmount;
    }

    public Object getScore() {
        return score;
    }

    public Object getSignErrorCount() {
        return signErrorCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getUid() {
        return uid;
    }

    public Object getUserName() {
        return userName;
    }

    public String getYearMonthInfo() {
        return yearMonthInfo;
    }
  /*  这里应为我们要获取的数组里面的数据不是键值对，而是字符串，所以list里面的参数应该为String，如果数组里面的数据为键值对，那么我们在List里面的参数应该为modle*/

    public List<List<String>> getScoreList() {
        return scoreList;
    }
}
