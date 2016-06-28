package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/25 13:49
 * 修改人：WangQing
 * 修改时间：2016/1/25 13:49
 * 修改备注：
 */
public class NewNetWorkListModle {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("salesMan")
    @Expose
    private String salesMan;
    @SerializedName("sn")
    @Expose
    private String sn;
    @SerializedName("stn")
    @Expose
    private String stn;
    @SerializedName("t")
    @Expose
    private String t;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The salesMan
     */
    public String getSalesMan() {
        return salesMan;
    }

    /**
     *
     * @param salesMan
     * The salesMan
     */
    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    /**
     *
     * @return
     * The sn
     */
    public String getSn() {
        return sn;
    }

    /**
     *
     * @param sn
     * The sn
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     *
     * @return
     * The stn
     */
    public String getStn() {
        return stn;
    }

    /**
     *
     * @param stn
     * The stn
     */
    public void setStn(String stn) {
        this.stn = stn;
    }

    /**
     *
     * @return
     * The t
     */
    public String getT() {
        return t;
    }

    /**
     *
     * @param t
     * The t
     */
    public void setT(String t) {
        this.t = t;
    }

}
