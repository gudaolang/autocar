package com.leren;

/**
 * @author lee
 * @Date:2018/4/18
 */

public class CacheConstants {

    private static final String GLOBAL_USER_TOKEN_PREFIX = "global_token";
    private static final String GLOBAL_USER_PREFIX = "global_user";
    private static final String USER_RETRY_PREFIX = "global_user_retry_time";

    public static String globalToken(String code) {
        return GLOBAL_USER_TOKEN_PREFIX + code;
    }

    public static String user(String code) {
        return GLOBAL_USER_PREFIX + code;
    }

    public static String userRetry(String code) {
        return USER_RETRY_PREFIX + code;
    }

}
