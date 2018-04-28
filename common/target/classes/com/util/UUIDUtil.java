package com.util;

import java.util.UUID;

/**
 * @author lee
 * @Date:28/03/2018
 */

public class UUIDUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
