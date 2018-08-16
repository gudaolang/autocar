package com.util.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class DateUtil {


    /**
     * 秒 - 毫秒数
     */
    private static final long SECOND = 1000;
    /**
     * 分 - 毫秒数
     */
    private static final long MINUTE = SECOND * 60;
    /**
     * 小时 - 毫秒数
     */
    private static final long HOUR = MINUTE * 60;
    /**
     * 天 - 毫秒数
     */
    private static final long DAY = HOUR * 24;
    /**
     * 日期格式:yyyy-MM-dd
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final int MIN_TIME = 0;
    private static final int MAX_HOUR_OF_DAY = 23;
    private static final int MAX_MINUTE_OR_SECONDS = 59;

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期格式化
     *
     * @param date    Date
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 格式化日期
     *
     * @param date 日期对象
     * @return yyyy-MM-dd
     */
    public static String formatDate(Date date) {
        return formatDate(date, DATE_FORMAT);
    }

    /**
     * 格式化日期
     *
     * @param date 日期对象
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, DATETIME_FORMAT);
    }


    /**
     * 获取当前年份
     *
     * @return year
     */
    public static int getCurrYear() {
        Calendar instance = Calendar.getInstance();
        return instance.get(Calendar.YEAR);
    }

    /**
     * 获取当前日期月份
     *
     * @return month
     */
    public static int getCurrMonth() {
        Calendar instance = Calendar.getInstance();
        return instance.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前日期所在当月的天数
     *
     * @return day
     */
    public static int getCurrDay() {
        return getDayOfMonth(new Date());
    }

    /**
     * 将字符串日期转换成日期
     *
     * @param date    要转换的日期
     * @param pattern 字符串日期格式
     * @return date
     */
    public static Date parseDate(String date, String pattern) {
        Date d = null;
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            d = df.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将字符串日期转换为 yyyy-MM-dd 格式
     *
     * @param date 日期字符串
     * @return date
     */
    public static Date parseDate(String date) {
        return parseDate(date, DATE_FORMAT);
    }

    /**
     * 将字符串日期转换为 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param datetime 日期字符串
     * @return date
     */
    public static Date parseDateTime(String datetime) {
        return parseDate(datetime, DATETIME_FORMAT);
    }


    /**
     * 获取指定日期是周天数
     *
     * @param date 日期
     * @return 周天数
     */
    public static int getDayOfWeek(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int d = instance.get(Calendar.DAY_OF_WEEK);

        return d == 1 ? 7 : d - 1;
    }

    /**
     * 获取指定日期是是当月第几天
     *
     * @param date 日期
     * @return 周天数
     */
    public static int getDayOfMonth(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前小时
     *
     * @param date 日期
     * @return 小时
     */
    public static int getHourOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前分钟
     *
     * @param date 日期
     * @return 分钟
     */
    public static int getMinute(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(Calendar.MINUTE);
    }


    /**
     * 日期加减-月份
     *
     * @param date  日期
     * @param month 加减的月
     * @return 日期
     */
    public static Date addMonth(Date date, int month) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MONTH, month);
        return instance.getTime();
    }

    /**
     * 日期加减-天
     *
     * @param date 日期
     * @param day  加减的天数
     * @return 日期
     */
    public static Date addDay(Date date, int day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, day);
        return instance.getTime();
    }


    /**
     * 日期加减-小时
     *
     * @param date 日期
     * @param hour 加减小时
     * @return 日期
     */
    public static Date addHour(Date date, int hour) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR, hour);
        return instance.getTime();
    }

    /**
     * 根据时间戳 获取当天最小时间戳
     *
     * @param mills 参数时间戳
     * @return 最小时间戳
     */
    public static Long getDayMinMills(Long mills) {
        return getDayMills(mills, 0);
    }

    /**
     * 根据时间戳 获取当天最大时间戳
     *
     * @param mills 参数时间戳
     * @return 最大时间戳
     */
    public static Long getDayMaxMills(Long mills) {
        return getDayMills(mills, 1);
    }

    @SuppressWarnings("all")
    public static Long getDayMills(Long mills, int tag) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH), day = calendar.get(Calendar.DAY_OF_MONTH);
        if (tag == 0) {
            calendar.set(year, month, day, MIN_TIME, MIN_TIME, MIN_TIME);
            calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
            logger.info("min:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
        }
        if (tag == 1) {
            calendar.set(year, month, day, MAX_HOUR_OF_DAY, MAX_MINUTE_OR_SECONDS, MAX_MINUTE_OR_SECONDS);
            calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
            logger.info("max:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
        }
        return calendar.getTimeInMillis();
    }

    /**
     * 获取本周最小时间戳
     *
     * @param timeMills 时间戳
     * @return 周最小时间戳
     */
    public static Long getWeekMinMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        return getDayMinMills(calendar.getTimeInMillis() + DAY);
    }

    /**
     * 获取本周最大时间戳
     *
     * @param timeMills 时间戳
     * @return 周最大时间戳
     */
    public static Long getWeekMaxMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        return getDayMaxMills(calendar.getTimeInMillis() + DAY);
    }

    /**
     * 获取本月最小时间戳
     *
     * @param timeMills 时间戳
     * @return 月最小时间戳
     */
    public static Long getMonthMinMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getDayMinMills(calendar.getTimeInMillis());
    }

    /**
     * 获取本月最大时间戳
     *
     * @param timeMills 时间戳
     * @return 月最大时间戳
     */
    public static Long getMonthMaxMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getDayMaxMills(calendar.getTimeInMillis());
    }


    /**
     * 获取本季度最小时间戳
     *
     * @param timeMills 时间戳
     * @return 本季度最小时间戳
     */
    public static Long getQuarterMinMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3);
        return getMonthMinMills(calendar.getTimeInMillis());
    }

    /**
     * 获取本季度最大时间戳
     *
     * @param timeMills 时间戳
     * @return 本季度最大时间戳
     */
    public static Long getQuarterMaxMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 + 2);
        return getMonthMaxMills(calendar.getTimeInMillis());
    }


    /**
     * 获取半年最小时间戳
     *
     * @param timeMills 时间戳
     * @return 半年最小时间戳
     */
    public static Long getHalfYearMinMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) <= 5 ? 0 : 6);
        return getMonthMinMills(calendar.getTimeInMillis());
    }

    /**
     * 获取半年最大时间戳
     *
     * @param timeMills 时间戳
     * @return 半年最大时间戳
     */
    public static Long getHalfYearMaxMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) <= 5 ? 6 : 11);
        return getMonthMaxMills(calendar.getTimeInMillis());
    }

    /**
     * 获取年最小时间戳
     *
     * @param timeMills 时间戳
     * @return 年最小时间戳
     */
    public static Long getYearMinMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        return getMonthMinMills(calendar.getTimeInMillis());
    }

    /**
     * 获取年最大时间戳
     *
     * @param timeMills 时间戳
     * @return 年最大时间戳
     */
    public static Long getYearMaxMills(Long timeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        return getMonthMaxMills(calendar.getTimeInMillis());
    }


    public static void main(String[] args) {

        logger.info("日期格式化 - yyyy-MM-dd > " + formatDate(new Date()));
        logger.info("日期格式化 - yyyy-MM-ddHH:mm:ss > " + formatDateTime(new Date()));

        logger.info("获取当前年份 > " + getCurrYear());
        logger.info("获取当前月份 > " + getCurrMonth());
        logger.info("获取当前日期在本月天数 > " + getCurrDay());

        logger.info("将字符串日期转换为日期 > " + parseDate("2018-08-03", "yyyy-MM-dd"));
        logger.info("将字符串日期转换为日期 > " + parseDate("2018-08-03"));
        logger.info("将字符串日期转换为日期 > " + parseDateTime("2018-08-03 23:23:10"));

        logger.info("获取指定日期是周天数 > " + getDayOfWeek(new Date()));
        logger.info("获取指定日期是是当月第几天 > " + getDayOfMonth(new Date()));
        logger.info("获取当前小时 > " + getHourOfDay(new Date()));
        logger.info("获取当前分钟 > " + getMinute(new Date()));
        logger.info("日期加减 - 月 > " + addMonth(new Date(), 1));
        logger.info("日期加减 - 天 > " + addDay(new Date(), 29));
        logger.info("日期加减 - 小时 > " + addHour(new Date(), 12));

        logger.info("获取指定日期 最小毫秒数 > " + getDayMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期 最小周毫秒数 > " + getWeekMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期 最大周毫秒数 > " + getWeekMaxMills(System.currentTimeMillis()));

        logger.info("获取指定日期 最小月毫秒数 > " + getMonthMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期 最大月毫秒数 > " + getMonthMaxMills(System.currentTimeMillis()));

        logger.info("获取指定日期所在季度最小毫秒数 > " + getQuarterMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期所在季度最大毫秒数 > " + getQuarterMaxMills(System.currentTimeMillis()));

        logger.info("获取指定日期所在半年最小毫秒数 > " + getHalfYearMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期所在半年最大毫秒数 > " + getHalfYearMaxMills(System.currentTimeMillis()));

        logger.info("获取指定日期所在年最小毫秒数 > " + getYearMinMills(System.currentTimeMillis()));
        logger.info("获取指定日期所在年最大毫秒数 > " + getYearMaxMills(System.currentTimeMillis()));
    }
}
