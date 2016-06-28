package com.example.administrator.fragmenttext.base;

import java.lang.reflect.Method;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/23 9:38
 * 修改人：WangQing
 * 修改时间：2015/12/23 9:38
 * 修改备注：
 */
public class MeizuSmartBarUtil {

    /**
     * 判断设备是否支持smart bar
     *
     * @return boolean true支持,false不支持
     */
    public static boolean hasSmartBar() {
        try {
            Method method = Class.forName("android.os.Build").getMethod("hasSmartBar");
            return (Boolean) method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
