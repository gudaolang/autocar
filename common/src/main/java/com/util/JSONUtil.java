package com.util;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.Map;

/**
 * @author lee
 * @Date :2018/5/9
 */

public class JsonUtil {

    /**
     * 将get请求参数转换为字符串
     */
    public static String getParam2Json(String str) {
        return JSON.toJSONString(Splitter.on('&').withKeyValueSeparator("=").split(str));
    }

    /**
     * 将字符串转换为get请求串
     */
    public static String json2GetParam(String jsonStr) {
        return Joiner.on('&').join(JSON.parseObject(jsonStr, Map.class).entrySet());
    }

    public static void main(String[] args) {

        String str = getParam2Json("brand=阿斯顿·马丁&brandId=2&carUuid=9c98029685ac4ddc926a5c6ca902236b&model=2003款 阿斯顿马丁DB7 Vantage&modelId=531&ownerId=2097&ownerMobile=17765678989&ownerName=小平津&plateNo=京XDCS237&repairId=2098&repairMobile=17765678990&repairName=xiao&serial=阿斯顿马丁DB7&serialId=36");

        System.out.println(str);

        String jsonStr = "{\"brand\":\"阿斯顿·马丁\",\"brandId\":\"2\",\"carUuid\":\"9c98029685ac4ddc926a5c6ca902236b\",\"model\":\"2003款 阿斯顿马丁DB7 Vantage\",\"modelId\":\"531\",\"ownerId\":\"2097\",\"ownerMobile\":\"17765678989\",\"ownerName\":\"小平津\",\"plateNo\":\"京XDCS237\",\"repairId\":\"2098\",\"repairMobile\":\"17765678990\",\"repairName\":\"xiao\",\"serial\":\"阿斯顿马丁DB7\",\"serialId\":\"36\"}";

        System.out.println(json2GetParam(jsonStr));

    }
}
