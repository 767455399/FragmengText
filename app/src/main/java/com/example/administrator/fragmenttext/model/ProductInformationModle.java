package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/25 10:18
 * 修改人：WangQing
 * 修改时间：2016/1/25 10:18
 * 修改备注：
 */
public class ProductInformationModle {
    @SerializedName("leaveCount")
    @Expose
    private Object leaveCount;
    @SerializedName("mainExpress")
    @Expose
    private Object mainExpress;
    @SerializedName("saleAmount")
    @Expose
    private Object saleAmount;
    @SerializedName("score")
    @Expose
    private Object score;
    @SerializedName("scoreList")
    @Expose
    private List<List<String>> scoreList = new ArrayList<List<String>>();
    @SerializedName("signErrorCount")
    @Expose
    private Object signErrorCount;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("uid")
    @Expose
    private Object uid;
    @SerializedName("userName")
    @Expose
    private Object userName;
    @SerializedName("yearMonthInfo")
    @Expose
    private String yearMonthInfo;

    /**
     *
     * @return
     * The leaveCount
     */
    public Object getLeaveCount() {
        return leaveCount;
    }

    /**
     *
     * @param leaveCount
     * The leaveCount
     */
    public void setLeaveCount(Object leaveCount) {
        this.leaveCount = leaveCount;
    }

    /**
     *
     * @return
     * The mainExpress
     */
    public Object getMainExpress() {
        return mainExpress;
    }

    /**
     *
     * @param mainExpress
     * The mainExpress
     */
    public void setMainExpress(Object mainExpress) {
        this.mainExpress = mainExpress;
    }

    /**
     *
     * @return
     * The saleAmount
     */
    public Object getSaleAmount() {
        return saleAmount;
    }

    /**
     *
     * @param saleAmount
     * The saleAmount
     */
    public void setSaleAmount(Object saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     *
     * @return
     * The score
     */
    public Object getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Object score) {
        this.score = score;
    }

    /**
     *
     * @return
     * The scoreList
     */
    public List<List<String>> getScoreList() {
        return scoreList;
    }

    /**
     *
     * @param scoreList
     * The scoreList
     */
    public void setScoreList(List<List<String>> scoreList) {
        this.scoreList = scoreList;
    }

    /**
     *
     * @return
     * The signErrorCount
     */
    public Object getSignErrorCount() {
        return signErrorCount;
    }

    /**
     *
     * @param signErrorCount
     * The signErrorCount
     */
    public void setSignErrorCount(Object signErrorCount) {
        this.signErrorCount = signErrorCount;
    }

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The uid
     */
    public Object getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     * The uid
     */
    public void setUid(Object uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     * The userName
     */
    public Object getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The userName
     */
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The yearMonthInfo
     */
    public String getYearMonthInfo() {
        return yearMonthInfo;
    }

    /**
     *
     * @param yearMonthInfo
     * The yearMonthInfo
     */
    public void setYearMonthInfo(String yearMonthInfo) {
        this.yearMonthInfo = yearMonthInfo;
    }


}
