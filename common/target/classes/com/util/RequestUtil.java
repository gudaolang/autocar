package com.util;

import com.util.result.ErrorInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangShuzheng
 * @Date:13/03/2018
 */

public class RequestUtil {

    public static final String ERROR_VIEW = "error";
    /**
     * 网宿cdn的真实ip
     */
    private static final String WS_CDN = "Cdn-Src-Ip";
    /**
     * 获取代理ip
     */
    private static final String LX_CDN = "HTTP_CLIENT_IP";
    /**
     * 获取代理ip
     */
    private static final String XF_IP = "X-Forwarded-For";
    private static final String PROXY_IP = "Proxy-Client-IP";
    private static final String REAL_IP = "WL-Proxy-Client-IP";
    private static final String UNKNOWM = "unknown";
    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader(WS_CDN);
        if (StringUtils.isEmpty(ip) || UNKNOWM.equalsIgnoreCase(ip)) {
            ip = request.getHeader(LX_CDN);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWM.equalsIgnoreCase(ip)) {
            ip = request.getHeader(XF_IP);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWM.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_IP);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWM.equalsIgnoreCase(ip)) {
            ip = request.getHeader(REAL_IP);
        }
        if (StringUtils.isEmpty(ip) || UNKNOWM.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取basePath
     */
    public static String getBasePath(HttpServletRequest request) {
        StringBuffer basePath = new StringBuffer();
        String scheme = request.getScheme();
        String domain = request.getServerName();
        int port = request.getServerPort();
        basePath.append(scheme);
        basePath.append("://");
        basePath.append(domain);
        if (HTTP.equalsIgnoreCase(scheme) && 80 != port) {
            basePath.append(":").append(String.valueOf(port));
        } else if (HTTPS.equalsIgnoreCase(scheme) && port != 443) {
            basePath.append(":").append(String.valueOf(port));
        }
        return basePath.toString();
    }


    /**
     * 获取请求参数
     */
    public static Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            result.put(parameterName, request.getParameter(parameterName));
        }
        return result;
    }


    public static ErrorInfo<String> getExceptionJSON(HttpServletRequest req, Exception e) {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMsg(e.toString());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            r.setCode(400);
        } else {
            r.setCode(500);
        }
        r.setResult(ERROR_VIEW);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
