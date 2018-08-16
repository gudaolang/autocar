package com.util;

/**
 *
 */

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author Administrator
 */
public class MapUtils {

    private static final Logger logger = LoggerFactory.getLogger(MapUtils.class);


    public static HashMap<String, Object> getHashMap() {
        return new HashMap<>(1 << 4);
    }


    public static void addToMap(Map<String, Object> map, String key, Object o) {
        if (o != null) {
            if (o instanceof String) {
                if (StringUtils.isEmpty((String) o)) {
                    return;
                }
            }
            map.put(key, o);
        }
    }

    public static void addPercentToMap(Map<String, Object> map, String key, Object o) {
        addToMap(map, key, "%", o, "%");
    }

    public static void addLeftPercentToMap(Map<String, Object> map, String key, Object o) {
        addToMap(map, key, "%", o, null);
    }

    public static void addRightPercentToMap(Map<String, Object> map, String key, Object o) {
        addToMap(map, key, null, o, "%");
    }

    public static void addToMap(Map<String, Object> map, String key, String sBef, Object o, String sAft) {
        if (o != null) {
            if (o instanceof String) {
                if (StringUtils.isEmpty((String) o)) {
                    return;
                }
            }
            if (StringUtils.isEmpty(sBef) && (StringUtils.isEmpty(sAft))) {
                map.put(key, String.valueOf(o));
            } else if (!StringUtils.isEmpty(sBef) && (StringUtils.isEmpty(sAft))) {
                map.put(key, sBef + String.valueOf(o));
            } else if (StringUtils.isEmpty(sBef) && (!StringUtils.isEmpty(sAft))) {
                map.put(key, String.valueOf(o) + sAft);
            } else if (!StringUtils.isEmpty(sBef) && (!StringUtils.isEmpty(sAft))) {
                map.put(key, sBef + String.valueOf(o) + sAft);
            }
        }
    }

    /**
     * 将Object转换成map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> bean2Map(Object obj) {
        Map<String, Object> map = getHashMap();
        try {
            if (obj != null) {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    // 过滤class属性
                    if (key != null && !"class".equals(key)) {
                        // 得到property对应的getter方法
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        if (Objects.nonNull(value) && value instanceof String && StringUtils.isNotBlank((String) value)) {
                            map.put(key, value);
                        }
                    }
                }
            }
            return map;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return map;
        }
    }

    /**
     * @param obj
     * @return
     */
    public static Map<String, Object> bean2MapWithEmpty(Object obj) {
        Map<String, Object> map = getHashMap();
        try {
            if (obj != null) {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    // 过滤class属性
                    if (key != null && !"class".equals(key)) {
                        // 得到property对应的getter方法
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        if (Objects.nonNull(value)) {
                            map.put(key, value);
                        }
                    }
                }
            }
            return map;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return map;
        }
    }

    /**
     * bean转map，bean中为空的在map中也未空，但是键是有的。
     */
    public static Map<String, Object> bean2MapWithAllKey(Object obj) {
        Map<String, Object> map = getHashMap();
        try {
            if (obj != null) {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    // 过滤class属性
                    if (key != null && !"class".equals(key)) {
                        // 得到property对应的getter方法
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        map.put(key, value);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return map;
        }
    }

    /**
     * 检测一个实体bean是否存在空属性
     *
     * @param obj
     * @return
     */
    public static boolean isExistNullVal(Object obj) {
        try {
            if (obj != null) {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    // 过滤class属性
                    if (key != null && !"class".equals(key)) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        return value == null;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * 将map转化为实体bean T (复杂类型)
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        if (map != null && map.size() > 0) {
            String jsonStr = JSON.toJSONString(map);
            return JSON.parseObject(jsonStr, clazz);
        }
        return null;
    }

    /**
     *  将ListMap转化为实体List(复杂类型)
     */
    public static <T> List<T> map2Array(List<Map<String, Object>> results, Class<T> clazz) {
        if (results != null && results.size() > 0) {
            String jsonStr = JSON.toJSONString(results);
            return JSON.parseArray(jsonStr, clazz);
        }
        return null;
    }

    /**
     * 将map转成字符串
     *
     * @param map         参数
     * @param splitSymbol 连接符
     * @return string 返回序列化后的字符串
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String serializeWithSplit(Map<String, Object> map, String splitSymbol)
            throws UnsupportedEncodingException {

        return serializeWithSplit(map, splitSymbol, true);
    }

    /**
     * @param map         参数
     * @param splitSymbol 分割标识
     * @return String 返回序列化后的字符串
     * @throws UnsupportedEncodingException
     */
    public static String serializeWithSplit(Map<String, Object> map, String splitSymbol, boolean isNeedEncode)
            throws UnsupportedEncodingException {

        SortedMap<String, Object> treeMap = new TreeMap<>(map);

        Set<Entry<String, Object>> set = treeMap.entrySet();
        Iterator<Entry<String, Object>> iter = set.iterator();

        StringBuilder builder = new StringBuilder();
        while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            Object val = entry.getValue();
            String symbol = iter.hasNext() ? splitSymbol : "";

            builder.append(key);
            builder.append('=');
            builder.append(isNeedEncode ? URLEncoder.encode(val.toString(), StandardCharsets.UTF_8.name()) : val.toString());
            builder.append(symbol);
        }
        return builder.toString();
    }
}
