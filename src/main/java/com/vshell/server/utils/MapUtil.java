package com.vshell.server.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heroshen on 2017/12/19.
 */
public class MapUtil {

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     */
    public static Map bean2Map(Object bean, Integer offset, Integer pageSize) {
        Map returnMap = MapUtil.bean2Map(bean);
        if (pageSize != null) {
            returnMap.put("offset", offset != null ? offset : 0);
            returnMap.put("pageSize", pageSize != null ? pageSize : 0);
        }
        return returnMap;
    }

    public static Map bean2Map(Object bean) {
        Map returnMap = new HashMap();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }
}
