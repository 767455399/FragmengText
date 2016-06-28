package com.example.administrator.fragmenttext.addresspick;

import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/16 16:15
 * 修改人：WangQing
 * 修改时间：2016/1/16 16:15
 * 修改备注：
 */
public class Province {

    private String name;
    private List<City> city;

    public List<City> getCities() {
        return city;
    }

    public void setCities(List<City> cities) {
        this.city = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class City{
        private String name;
        private List<String> area;

        public List<String> getArea() {
            return area;
        }

        public void setArea(List<String> counties) {
            this.area = counties;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
