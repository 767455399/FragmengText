package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/27 14:33
 * 修改人：WangQing
 * 修改时间：2016/1/27 14:33
 * 修改备注：
 */
public class DisplayStandardModle {
    @SerializedName("applyCount")
    @Expose
    private Object applyCount;
    @SerializedName("article")
    @Expose
    private Object article;
    @SerializedName("articleReaderList")
    @Expose
    private List<Object> articleReaderList = new ArrayList<Object>();
    @SerializedName("companyCode")
    @Expose
    private String companyCode;
    @SerializedName("count")
    @Expose
    private Object count;
    @SerializedName("dataList")
    @Expose
    private List<List<String>> dataList = new ArrayList<List<String>>();
    @SerializedName("leaveCount")
    @Expose
    private Object leaveCount;
    @SerializedName("msgNum")
    @Expose
    private Object msgNum;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("pageIndex")
    @Expose
    private Integer pageIndex;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("readerId")
    @Expose
    private Object readerId;
    @SerializedName("salesmanid")
    @Expose
    private Object salesmanid;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("typeList")
    @Expose
    private List<TypeListModle> typeList = new ArrayList<TypeListModle>();
    @SerializedName("userId")
    @Expose
    private String userId;

    /**
     *
     * @return
     * The applyCount
     */
    public Object getApplyCount() {
        return applyCount;
    }

    /**
     *
     * @param applyCount
     * The applyCount
     */
    public void setApplyCount(Object applyCount) {
        this.applyCount = applyCount;
    }

    /**
     *
     * @return
     * The article
     */
    public Object getArticle() {
        return article;
    }

    /**
     *
     * @param article
     * The article
     */
    public void setArticle(Object article) {
        this.article = article;
    }

    /**
     *
     * @return
     * The articleReaderList
     */
    public List<Object> getArticleReaderList() {
        return articleReaderList;
    }

    /**
     *
     * @param articleReaderList
     * The articleReaderList
     */
    public void setArticleReaderList(List<Object> articleReaderList) {
        this.articleReaderList = articleReaderList;
    }

    /**
     *
     * @return
     * The companyCode
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     *
     * @param companyCode
     * The companyCode
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     *
     * @return
     * The count
     */
    public Object getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Object count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The dataList
     */
    public List<List<String>> getDataList() {
        return dataList;
    }

    /**
     *
     * @param dataList
     * The dataList
     */
    public void setDataList(List<List<String>> dataList) {
        this.dataList = dataList;
    }

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
     * The msgNum
     */
    public Object getMsgNum() {
        return msgNum;
    }

    /**
     *
     * @param msgNum
     * The msgNum
     */
    public void setMsgNum(Object msgNum) {
        this.msgNum = msgNum;
    }

    /**
     *
     * @return
     * The pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     *
     * @param pageCount
     * The pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     *
     * @return
     * The pageIndex
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     *
     * @param pageIndex
     * The pageIndex
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     *
     * @return
     * The pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     *
     * @param pageSize
     * The pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     *
     * @return
     * The readerId
     */
    public Object getReaderId() {
        return readerId;
    }

    /**
     *
     * @param readerId
     * The readerId
     */
    public void setReaderId(Object readerId) {
        this.readerId = readerId;
    }

    /**
     *
     * @return
     * The salesmanid
     */
    public Object getSalesmanid() {
        return salesmanid;
    }

    /**
     *
     * @param salesmanid
     * The salesmanid
     */
    public void setSalesmanid(Object salesmanid) {
        this.salesmanid = salesmanid;
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
     * The typeList
     */
    public List<TypeListModle> getTypeList() {
        return typeList;
    }

    /**
     *
     * @param typeList
     * The typeList
     */
    public void setTypeList(List<TypeListModle> typeList) {
        this.typeList = typeList;
    }

    /**
     *
     * @return
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }


    public class TypeListModle {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("typeName")
        @Expose
        private String typeName;

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
         * The typeName
         */
        public String getTypeName() {
            return typeName;
        }

        /**
         *
         * @param typeName
         * The typeName
         */
        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

    }
}
