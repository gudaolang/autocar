package com.leren;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @Date:27/02/2018
 */

@Component
@PropertySource("classpath:application.properties")
public class GlobalComponentConfig {

    public static String ENVIRONMENT;

    public static String APP;

    public static boolean isDebug() {
        return "dev".equals(ENVIRONMENT);
    }

    @Value("${spring.profiles.active}")
    public void setENVIRONMENT(String env) {
        ENVIRONMENT = env;
    }

    @Value("${spring.application.name}")
    public void setAPP(String app) {
        APP = app;
    }

}
