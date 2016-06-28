package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/2/16 11:10
 * 修改人：WangQing
 * 修改时间：2016/2/16 11:10
 * 修改备注：
 */
public class FamousQuotesModle {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("result")
    @Expose
    private List<Famous> result = new ArrayList<Famous>();
    @SerializedName("error_code")
    @Expose
    private Integer errorCode;
    @SerializedName("reason")
    @Expose
    private String reason;

    /**
     *
     * @return
     * The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     *
     * @param total
     * The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     *
     * @return
     * The result
     */
    public List<Famous> getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(List<Famous> result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @param errorCode
     * The error_code
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     *
     * @return
     * The reason
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     * The reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

}
