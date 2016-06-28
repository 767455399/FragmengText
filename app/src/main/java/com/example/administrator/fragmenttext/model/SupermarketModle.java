package com.example.administrator.fragmenttext.model;

import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/22 20:15
 * 修改人：WangQing
 * 修改时间：2016/1/22 20:15
 * 修改备注：
 */
public class SupermarketModle {

    /**
     * leaveCount : null
     * mainExpress : null
     * saleAmount : null
     * score : null
     * scoreList : [["1.浙江中商超市有限公司",8],["2.满溢购物广场",7],["3.楼塔寿晓安批发部",7],["4.农发超市萧山新农都店",7],["5.爵贤临江购物中心",6],["6.临江世纪华联",6],["7.河上老胡子批发部",6],["8.时代联华新街店",6],["9.浙江中商超市有限公司义桥分公司",6],["10.左山世纪华联",5],["11.衙前佳乐美超市",5],["12.戴村中超",5],["13.红山家联超市",5],["14.河上楼春波批发部",5],["15.楼塔供销社批发部",5],["16.党湾时代联华",5],["17.好乐购超市瓜沥店",5],["18.世纪华联河上店",5],["19.楼塔常绿月田批发部",5],["20.南阳好又多超市",5],["21.中商超市长沙店",4],["22.靖江供销生活超市",4],["23.楼塔好又多",4],["24.温客隆超市惠南街",4],["25.衙前嘉佰乐",4],["26.楼塔马九丰批发部",4],["27.楼塔中超市",4],["28.杭州中商霞山超市有限公司",4],["29.楼塔世纪华联",4],["30.世纪联华闻堰店",4],["31.义蓬杭州华联",4],["32.坎山世纪华联",4],["33.头蓬吴江大润发",4],["34.前进时代联华",4],["35.坎山新益佳超市",4],["36.新湾中超",3],["37.楼塔润隆购物中心",3],["38.楼塔常绿明延批发部",3],["39.楼塔俞淼根副食品店",3],["40.客卖隆长山店",3],["41.瓜沥兴达粮油批发",2],["42.楼塔旺旺超市",2],["43.浦阳宾佳超市",2],["44.楼塔常绿朱义法副食",2],["45.楼塔河丰粮油店",2],["46.楼塔廖东月粮油店",2],["47.韩镭副食品店",1],["48.楼塔阿可批发部",1],["49.杭州湘湖购物中心有限公司",1],["50.楼塔盛良德批发部",1],["51.左山宾佳",1],["52.楼塔玲正粮油经营部",0],["53.孙小英酒水批发部",0],["54.临浦杭州华联",0],["55.长山郭玲玲副食品批发",0],["56.萧山1线车销",0],["57.好立方宁围镇二桥店",0],["58.萧山程从兵车销",0],["59.浙江供销生活超市靖江店",0],["60.闻堰新城生活超市",0],["61.新街鸿兴城杭州华联",0],["62.杭州全加惠贸易有限公司",0],["63.开发区品全购物中心",0],["64.楼塔常绿华辰超市批发",0],["65.八大村易买盛",0],["66.左山新益佳",0],["67.楼塔福薏欢",0],["68.楼塔楼叶红副食",0],["69.所前货郎购物中心",0],["70.新街府前87号",0],["71.义桥好立方",0],["72.义桥货郎先生，小商品直销超市",0],["73.瓜沥世纪华联东灵路店",0],["74.进化阿明特价店",0],["75.转塘姚辉粮油批发",0],["76.楼塔永浩批发部",0],["77.临浦山东炒货店",0],["78.楼塔常绿登安副食批发",0],["79.瓜沥世纪华联",0],["80.中商超市长河店",0],["81.崇化中商",0],["82.佳丽雅超市红山店",0],["83.所前国贤副食品店",0],["84.头蓬迦特购物中心",0],["85.闻堰好乐购超市",0],["86.新街长山超级购购物广场",0]]
     * signErrorCount : null
     * success : true
     * uid : null
     * userName : null
     * yearMonthInfo : 2015-01-01
     */

    private Object leaveCount;
    private Object mainExpress;
    private Object saleAmount;
    private Object score;
    private Object signErrorCount;
    private boolean success;
    private Object uid;
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

    public void setUid(Object uid) {
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

    public Object getUid() {
        return uid;
    }

    public Object getUserName() {
        return userName;
    }

    public String getYearMonthInfo() {
        return yearMonthInfo;
    }

    public List<List<String>> getScoreList() {
        return scoreList;
    }
}
