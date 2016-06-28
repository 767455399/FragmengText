package com.example.administrator.fragmenttext.model;

import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/2/17 11:09
 * 修改人：WangQing
 * 修改时间：2016/2/17 11:09
 * 修改备注：
 */
public class WeatherModle {

    /**
     * realtime : {"wind":{"windspeed":"7.0","direct":"东风","power":"1级","offset":null},"time":"09:00:00","weather":{"humidity":"81","img":"1","info":"多云","temperature":"6"},"dataUptime":"1455673023","date":"2016-02-17","city_code":"101200101","city_name":"武汉","week":"3","moon":"正月初十"}
     * life : {"date":"2016-2-17","info":{"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","阴天，且天气寒冷，推荐您在室内进行低强度运动；若坚持户外运动，请选择合适的运动并注意保暖。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["易发","昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":["较差","气象条件较不利于空气污染物稀释、扩散和清除。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}}
     * weather : [{"date":"2016-02-17","week":"三","nongli":"正月初十","info":{"dawn":null,"day":["2","阴","13","无持续风向","微风","07:02"],"night":["0","晴","0","无持续风向","微风","18:11"]}},{"date":"2016-02-18","week":"四","nongli":"正月十一","info":{"dawn":["0","晴","0","无持续风向","微风","18:11"],"day":["1","多云","16","无持续风向","微风","07:01"],"night":["1","多云","3","无持续风向","微风","18:12"]}},{"date":"2016-02-19","week":"五","nongli":"正月十二","info":{"dawn":["1","多云","3","无持续风向","微风","18:12"],"day":["1","多云","13","无持续风向","微风","07:00"],"night":["0","晴","0","无持续风向","微风","18:13"]}},{"date":"2016-02-20","week":"六","nongli":"正月十三","info":{"dawn":["0","晴","0","无持续风向","微风","18:13"],"day":["1","多云","12","无持续风向","微风","06:59"],"night":["1","多云","2","无持续风向","微风","18:14"]}},{"date":"2016-02-21","week":"日","nongli":"正月十四","info":{"dawn":["1","多云","2","无持续风向","微风","18:14"],"day":["7","小雨","8","无持续风向","微风","06:58"],"night":["7","小雨","3","无持续风向","微风","18:14"]}},{"date":"2016-02-22","week":"一","nongli":"正月十五","info":{"dawn":null,"day":["3","阵雨","9","西北风","微风","07:30"],"night":["2","阴","4","西北风","微风","19:30"]}},{"date":"2016-02-23","week":"二","nongli":"正月十六","info":{"dawn":null,"day":["3","阵雨","11","东北风","微风","07:30"],"night":["3","阵雨","4","东北风","微风","19:30"]}}]
     * pm25 : {"key":"","show_desc":"0","pm25":{"curPm":"101","pm25":"64","pm10":"101","level":"2","quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年02月17日09时","cityName":"武汉"}
     * isForeign : 0
     */

    private ResultEntity result;
    /**
     * result : {"realtime":{"wind":{"windspeed":"7.0","direct":"东风","power":"1级","offset":null},"time":"09:00:00","weather":{"humidity":"81","img":"1","info":"多云","temperature":"6"},"dataUptime":"1455673023","date":"2016-02-17","city_code":"101200101","city_name":"武汉","week":"3","moon":"正月初十"},"life":{"date":"2016-2-17","info":{"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","阴天，且天气寒冷，推荐您在室内进行低强度运动；若坚持户外运动，请选择合适的运动并注意保暖。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["易发","昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":["较差","气象条件较不利于空气污染物稀释、扩散和清除。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}},"weather":[{"date":"2016-02-17","week":"三","nongli":"正月初十","info":{"dawn":null,"day":["2","阴","13","无持续风向","微风","07:02"],"night":["0","晴","0","无持续风向","微风","18:11"]}},{"date":"2016-02-18","week":"四","nongli":"正月十一","info":{"dawn":["0","晴","0","无持续风向","微风","18:11"],"day":["1","多云","16","无持续风向","微风","07:01"],"night":["1","多云","3","无持续风向","微风","18:12"]}},{"date":"2016-02-19","week":"五","nongli":"正月十二","info":{"dawn":["1","多云","3","无持续风向","微风","18:12"],"day":["1","多云","13","无持续风向","微风","07:00"],"night":["0","晴","0","无持续风向","微风","18:13"]}},{"date":"2016-02-20","week":"六","nongli":"正月十三","info":{"dawn":["0","晴","0","无持续风向","微风","18:13"],"day":["1","多云","12","无持续风向","微风","06:59"],"night":["1","多云","2","无持续风向","微风","18:14"]}},{"date":"2016-02-21","week":"日","nongli":"正月十四","info":{"dawn":["1","多云","2","无持续风向","微风","18:14"],"day":["7","小雨","8","无持续风向","微风","06:58"],"night":["7","小雨","3","无持续风向","微风","18:14"]}},{"date":"2016-02-22","week":"一","nongli":"正月十五","info":{"dawn":null,"day":["3","阵雨","9","西北风","微风","07:30"],"night":["2","阴","4","西北风","微风","19:30"]}},{"date":"2016-02-23","week":"二","nongli":"正月十六","info":{"dawn":null,"day":["3","阵雨","11","东北风","微风","07:30"],"night":["3","阵雨","4","东北风","微风","19:30"]}}],"pm25":{"key":"","show_desc":"0","pm25":{"curPm":"101","pm25":"64","pm10":"101","level":"2","quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年02月17日09时","cityName":"武汉"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public static class ResultEntity {
        /**
         * wind : {"windspeed":"7.0","direct":"东风","power":"1级","offset":null}
         * time : 09:00:00
         * weather : {"humidity":"81","img":"1","info":"多云","temperature":"6"}
         * dataUptime : 1455673023
         * date : 2016-02-17
         * city_code : 101200101
         * city_name : 武汉
         * week : 3
         * moon : 正月初十
         */

        private RealtimeEntity realtime;
        /**
         * date : 2016-2-17
         * info : {"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","阴天，且天气寒冷，推荐您在室内进行低强度运动；若坚持户外运动，请选择合适的运动并注意保暖。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["易发","昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":["较差","气象条件较不利于空气污染物稀释、扩散和清除。"],"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}
         */

        private LifeEntity life;
        /**
         * key :
         * show_desc : 0
         * pm25 : {"curPm":"101","pm25":"64","pm10":"101","level":"2","quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"}
         * dateTime : 2016年02月17日09时
         * cityName : 武汉
         */

        private PmEntity pm25;
        private int isForeign;
        /**
         * date : 2016-02-17
         * week : 三
         * nongli : 正月初十
         * info : {"dawn":null,"day":["2","阴","13","无持续风向","微风","07:02"],"night":["0","晴","0","无持续风向","微风","18:11"]}
         */

        private List<WeatherEntity> weather;

        public void setRealtime(RealtimeEntity realtime) {
            this.realtime = realtime;
        }

        public void setLife(LifeEntity life) {
            this.life = life;
        }

        public void setPm25(PmEntity pm25) {
            this.pm25 = pm25;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public void setWeather(List<WeatherEntity> weather) {
            this.weather = weather;
        }

        public RealtimeEntity getRealtime() {
            return realtime;
        }

        public LifeEntity getLife() {
            return life;
        }

        public PmEntity getPm25() {
            return pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public List<WeatherEntity> getWeather() {
            return weather;
        }

        public static class RealtimeEntity {
            /**
             * windspeed : 7.0
             * direct : 东风
             * power : 1级
             * offset : null
             */

            private WindEntity wind;
            private String time;
            /**
             * humidity : 81
             * img : 1
             * info : 多云
             * temperature : 6
             */

            private WeatherEntity weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setWeather(WeatherEntity weather) {
                this.weather = weather;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public WindEntity getWind() {
                return wind;
            }

            public String getTime() {
                return time;
            }

            public WeatherEntity getWeather() {
                return weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public String getDate() {
                return date;
            }

            public String getCity_code() {
                return city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public String getWeek() {
                return week;
            }

            public String getMoon() {
                return moon;
            }

            public static class WindEntity {
                private String windspeed;
                private String direct;
                private String power;
                private Object offset;

                public void setWindspeed(String windspeed) {
                    this.windspeed = windspeed;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public void setOffset(Object offset) {
                    this.offset = offset;
                }

                public String getWindspeed() {
                    return windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public String getPower() {
                    return power;
                }

                public Object getOffset() {
                    return offset;
                }
            }

            public static class WeatherEntity {
                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getHumidity() {
                    return humidity;
                }

                public String getImg() {
                    return img;
                }

                public String getInfo() {
                    return info;
                }

                public String getTemperature() {
                    return temperature;
                }
            }
        }

        public static class LifeEntity {
            private String date;
            private InfoEntity info;

            public void setDate(String date) {
                this.date = date;
            }

            public void setInfo(InfoEntity info) {
                this.info = info;
            }

            public String getDate() {
                return date;
            }

            public InfoEntity getInfo() {
                return info;
            }

            public static class InfoEntity {
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> wuran;
                private List<String> chuanyi;

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public void setWuran(List<String> wuran) {
                    this.wuran = wuran;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public List<String> getWuran() {
                    return wuran;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }
            }
        }

        public static class PmEntity {
            private String key;
            private String show_desc;
            /**
             * curPm : 101
             * pm25 : 64
             * pm10 : 101
             * level : 2
             * quality : 良
             * des : 今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。
             */

            private Pm25Entity pm25;
            private String dateTime;
            private String cityName;

            public void setKey(String key) {
                this.key = key;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public void setPm25(Pm25Entity pm25) {
                this.pm25 = pm25;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getKey() {
                return key;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public Pm25Entity getPm25() {
                return pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public static class Pm25Entity {
                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getCurPm() {
                    return curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public String getLevel() {
                    return level;
                }

                public String getQuality() {
                    return quality;
                }

                public String getDes() {
                    return des;
                }
            }
        }

        public static class WeatherEntity {
            private String date;
            private String week;
            private String nongli;
            /**
             * dawn : null
             * day : ["2","阴","13","无持续风向","微风","07:02"]
             * night : ["0","晴","0","无持续风向","微风","18:11"]
             */

            private InfoEntity info;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public void setInfo(InfoEntity info) {
                this.info = info;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getNongli() {
                return nongli;
            }

            public InfoEntity getInfo() {
                return info;
            }

            public static class InfoEntity {
                private Object dawn;
                private List<String> day;
                private List<String> night;

                public void setDawn(Object dawn) {
                    this.dawn = dawn;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }

                public Object getDawn() {
                    return dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public List<String> getNight() {
                    return night;
                }
            }
        }
    }
}
