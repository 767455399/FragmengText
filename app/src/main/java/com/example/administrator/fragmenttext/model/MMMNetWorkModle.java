package com.example.administrator.fragmenttext.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/27 9:47
 * 修改人：WangQing
 * 修改时间：2016/1/27 9:47
 * 修改备注：
 */
public class MMMNetWorkModle {
    @SerializedName("agent")
    @Expose
    private Object agent;
    @SerializedName("contectId")
    @Expose
    private Object contectId;
    @SerializedName("contectId2")
    @Expose
    private Object contectId2;
    @SerializedName("contectList")
    @Expose
    private Object contectList;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("inOut")
    @Expose
    private Integer inOut;
    @SerializedName("isAll")
    @Expose
    private Integer isAll;
    @SerializedName("l1")
    @Expose
    private java.util.List<Object> l1 = new ArrayList<Object>();
    @SerializedName("l2")
    @Expose
    private java.util.List<Object> l2 = new ArrayList<Object>();
    @SerializedName("l3")
    @Expose
    private java.util.List<Object> l3 = new ArrayList<Object>();
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("lineId")
    @Expose
    private Object lineId;
    @SerializedName("lines")
    @Expose
    private java.util.List<Object> lines = new ArrayList<Object>();
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.administrator.fragmenttext.model.MMMNetWorkModle.MMMNetWorkModleList> list = new ArrayList<com.example.administrator.fragmenttext.model.MMMNetWorkModle.MMMNetWorkModleList>();
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("lxr2")
    @Expose
    private Object lxr2;
    @SerializedName("mobile")
    @Expose
    private Object mobile;
    @SerializedName("mobile2")
    @Expose
    private Object mobile2;
    @SerializedName("ns")
    @Expose
    private Object ns;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("pageIndex")
    @Expose
    private Integer pageIndex;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("phone2")
    @Expose
    private Object phone2;
    @SerializedName("position")
    @Expose
    private Object position;
    @SerializedName("position2")
    @Expose
    private Object position2;
    @SerializedName("realName")
    @Expose
    private Object realName;
    @SerializedName("salesManId")
    @Expose
    private Object salesManId;
    @SerializedName("shopPhone")
    @Expose
    private Object shopPhone;
    @SerializedName("simpleAgentInfo")
    @Expose
    private java.util.List<Object> simpleAgentInfo = new ArrayList<Object>();
    @SerializedName("simpleLineInfo")
    @Expose
    private java.util.List<Object> simpleLineInfo = new ArrayList<Object>();
    @SerializedName("simpleShopInfo")
    @Expose
    private java.util.List<Object> simpleShopInfo = new ArrayList<Object>();
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("visitInfo")
    @Expose
    private Object visitInfo;

    /**
     *
     * @return
     * The agent
     */
    public Object getAgent() {
        return agent;
    }

    /**
     *
     * @param agent
     * The agent
     */
    public void setAgent(Object agent) {
        this.agent = agent;
    }

    /**
     *
     * @return
     * The contectId
     */
    public Object getContectId() {
        return contectId;
    }

    /**
     *
     * @param contectId
     * The contectId
     */
    public void setContectId(Object contectId) {
        this.contectId = contectId;
    }

    /**
     *
     * @return
     * The contectId2
     */
    public Object getContectId2() {
        return contectId2;
    }

    /**
     *
     * @param contectId2
     * The contectId2
     */
    public void setContectId2(Object contectId2) {
        this.contectId2 = contectId2;
    }

    /**
     *
     * @return
     * The contectList
     */
    public Object getContectList() {
        return contectList;
    }

    /**
     *
     * @param contectList
     * The contectList
     */
    public void setContectList(Object contectList) {
        this.contectList = contectList;
    }

    /**
     *
     * @return
     * The distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The inOut
     */
    public Integer getInOut() {
        return inOut;
    }

    /**
     *
     * @param inOut
     * The inOut
     */
    public void setInOut(Integer inOut) {
        this.inOut = inOut;
    }

    /**
     *
     * @return
     * The isAll
     */
    public Integer getIsAll() {
        return isAll;
    }

    /**
     *
     * @param isAll
     * The isAll
     */
    public void setIsAll(Integer isAll) {
        this.isAll = isAll;
    }

    /**
     *
     * @return
     * The l1
     */
    public java.util.List<Object> getL1() {
        return l1;
    }

    /**
     *
     * @param l1
     * The l1
     */
    public void setL1(java.util.List<Object> l1) {
        this.l1 = l1;
    }

    /**
     *
     * @return
     * The l2
     */
    public java.util.List<Object> getL2() {
        return l2;
    }

    /**
     *
     * @param l2
     * The l2
     */
    public void setL2(java.util.List<Object> l2) {
        this.l2 = l2;
    }

    /**
     *
     * @return
     * The l3
     */
    public java.util.List<Object> getL3() {
        return l3;
    }

    /**
     *
     * @param l3
     * The l3
     */
    public void setL3(java.util.List<Object> l3) {
        this.l3 = l3;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Object getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The lineId
     */
    public Object getLineId() {
        return lineId;
    }

    /**
     *
     * @param lineId
     * The lineId
     */
    public void setLineId(Object lineId) {
        this.lineId = lineId;
    }

    /**
     *
     * @return
     * The lines
     */
    public java.util.List<Object> getLines() {
        return lines;
    }

    /**
     *
     * @param lines
     * The lines
     */
    public void setLines(java.util.List<Object> lines) {
        this.lines = lines;
    }

    /**
     *
     * @return
     * The list
     */
    public java.util.List<com.example.administrator.fragmenttext.model.MMMNetWorkModle.MMMNetWorkModleList> getList() {
        return list;
    }

    /**
     *
     * @param list
     * The list
     */
    public void setList(java.util.List<com.example.administrator.fragmenttext.model.MMMNetWorkModle.MMMNetWorkModleList> list) {
        this.list = list;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Object getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The lxr2
     */
    public Object getLxr2() {
        return lxr2;
    }

    /**
     *
     * @param lxr2
     * The lxr2
     */
    public void setLxr2(Object lxr2) {
        this.lxr2 = lxr2;
    }

    /**
     *
     * @return
     * The mobile
     */
    public Object getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     * The mobile
     */
    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     * The mobile2
     */
    public Object getMobile2() {
        return mobile2;
    }

    /**
     *
     * @param mobile2
     * The mobile2
     */
    public void setMobile2(Object mobile2) {
        this.mobile2 = mobile2;
    }

    /**
     *
     * @return
     * The ns
     */
    public Object getNs() {
        return ns;
    }

    /**
     *
     * @param ns
     * The ns
     */
    public void setNs(Object ns) {
        this.ns = ns;
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
     * The phone
     */
    public Object getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The phone2
     */
    public Object getPhone2() {
        return phone2;
    }

    /**
     *
     * @param phone2
     * The phone2
     */
    public void setPhone2(Object phone2) {
        this.phone2 = phone2;
    }

    /**
     *
     * @return
     * The position
     */
    public Object getPosition() {
        return position;
    }

    /**
     *
     * @param position
     * The position
     */
    public void setPosition(Object position) {
        this.position = position;
    }

    /**
     *
     * @return
     * The position2
     */
    public Object getPosition2() {
        return position2;
    }

    /**
     *
     * @param position2
     * The position2
     */
    public void setPosition2(Object position2) {
        this.position2 = position2;
    }

    /**
     *
     * @return
     * The realName
     */
    public Object getRealName() {
        return realName;
    }

    /**
     *
     * @param realName
     * The realName
     */
    public void setRealName(Object realName) {
        this.realName = realName;
    }

    /**
     *
     * @return
     * The salesManId
     */
    public Object getSalesManId() {
        return salesManId;
    }

    /**
     *
     * @param salesManId
     * The salesManId
     */
    public void setSalesManId(Object salesManId) {
        this.salesManId = salesManId;
    }

    /**
     *
     * @return
     * The shopPhone
     */
    public Object getShopPhone() {
        return shopPhone;
    }

    /**
     *
     * @param shopPhone
     * The shopPhone
     */
    public void setShopPhone(Object shopPhone) {
        this.shopPhone = shopPhone;
    }

    /**
     *
     * @return
     * The simpleAgentInfo
     */
    public java.util.List<Object> getSimpleAgentInfo() {
        return simpleAgentInfo;
    }

    /**
     *
     * @param simpleAgentInfo
     * The simpleAgentInfo
     */
    public void setSimpleAgentInfo(java.util.List<Object> simpleAgentInfo) {
        this.simpleAgentInfo = simpleAgentInfo;
    }

    /**
     *
     * @return
     * The simpleLineInfo
     */
    public java.util.List<Object> getSimpleLineInfo() {
        return simpleLineInfo;
    }

    /**
     *
     * @param simpleLineInfo
     * The simpleLineInfo
     */
    public void setSimpleLineInfo(java.util.List<Object> simpleLineInfo) {
        this.simpleLineInfo = simpleLineInfo;
    }

    /**
     *
     * @return
     * The simpleShopInfo
     */
    public java.util.List<Object> getSimpleShopInfo() {
        return simpleShopInfo;
    }

    /**
     *
     * @param simpleShopInfo
     * The simpleShopInfo
     */
    public void setSimpleShopInfo(java.util.List<Object> simpleShopInfo) {
        this.simpleShopInfo = simpleShopInfo;
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
     * The visitInfo
     */
    public Object getVisitInfo() {
        return visitInfo;
    }

    /**
     *
     * @param visitInfo
     * The visitInfo
     */
    public void setVisitInfo(Object visitInfo) {
        this.visitInfo = visitInfo;
    }
    public class MMMNetWorkModleList{
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

}


