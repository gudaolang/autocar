package com.leren.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lee
 * @Date:24/02/2018
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("当前时间为:" + DATE_FORMAT.format(new Date(System.currentTimeMillis())));
    }

}
