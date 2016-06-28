package com.example.administrator.fragmenttext.model.weather;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/4/13 16:11
 * 修改人：WangQing
 * 修改时间：2016/4/13 16:11
 * 修改备注：
 */
public class VoiceSMSModle {

    /**
     * success : true
     * error_code : 0
     * reason : Succes
     */

    private boolean success;
    private int error_code;
    private String reason;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
