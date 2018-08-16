package com.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

/**
 * projectName: base
 * Created by lee on 2018/8/13 15:49
 */
public class TemplateUtils {

    /**
     * 模板替换
     *
     * @param template 常量模板
     * @param params   要替换的数据
     * @return 模板信息
     */
    public static String processTemplate(String template, Map<String, Object> params) {
        if (template == null || params == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Matcher m = compile("\\$\\{\\w+\\}").matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String template = "我是${username},来自${province}";
        Map<String, Object> replaceParam = Maps.newHashMapWithExpectedSize(2);

        MapUtils.addToMap(replaceParam, "username", "小明");
        MapUtils.addToMap(replaceParam, "province", "湖南省");

        System.out.println(processTemplate(template, replaceParam));
    }
}
