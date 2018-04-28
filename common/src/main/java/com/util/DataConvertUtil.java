package com.util;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @Date:23/02/2018
 */

public class DataConvertUtil {

    public static <T> List<T> map2List(List<Map<String, Object>> listMap, Class<T> clazz) {
        if (listMap != null && listMap.size() > 0) {
            String jsonStr = JSON.toJSONString(listMap);
            return JSON.parseArray(jsonStr, clazz);
        }
        return null;
    }
}
