package com.example.tests;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * 时间操作工具类
 *
 * @author : chenYanXin
 * @date : 2019-01-03 14:41
 */
public class DateUtil {

    private final static String DEFAULT_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    private final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final static String START_DAY = "00:00:00";
    private final static String MIDDAY = "12:00:00";
    private final static String END_DAY = "23:59:59";
    public LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * 默认格式解析日期
     */
    public static DateUtil now() {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = LocalDateTime.now();
        return dateUtil;
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(TemporalAdjuster date) {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = dateUtil.localDateTime.with(date);
        return dateUtil;
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(String date) {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.parseOf(date);
    }

    /**
     * 默认格式解析日期
     */
    public static DateUtil date(String date, String pattern) {
        DateUtil dateUtil = new DateUtil();
        dateUtil.localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return dateUtil;
    }

    /**
     * 默认格式解析日期 格式不对返回当前时间
     */
    public DateUtil parseOf(String srcDate) {
        String patStr;
        int startOfHour = 11;
        if (srcDate.contains(" ")) {
            patStr = DEFAULT_FULL_PATTERN.substring(0, srcDate.length());
            localDateTime = LocalDateTime.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
        } else if (srcDate.contains("-") && srcDate.length() <= startOfHour - 1) {
            patStr = DEFAULT_FULL_PATTERN.substring(0, startOfHour - 1);
            LocalDate localDate = LocalDate.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
            localDateTime = localDate.atStartOfDay();
        } else if (srcDate.contains(":") && startOfHour + srcDate.length() <= DEFAULT_FULL_PATTERN.length()) {
            patStr = DEFAULT_FULL_PATTERN.substring(startOfHour);
            LocalTime localTime = LocalTime.parse(srcDate, DateTimeFormatter.ofPattern(patStr));
            localDateTime = localDateTime.with(localTime);
        } else {
            return now();
        }
        return this;
    }

    /**
     * 按指定格式解析日期
     */
    public DateUtil parseOf(String date, String pattern) {
        localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return this;
    }

    /**
     * 一天的开始
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String startOfDay() {
        return localDateTime.toLocalDate() + " " + START_DAY;
    }

    /**
     * 正中
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String midOfDay() {
        return localDateTime.toLocalDate() + " " + MIDDAY;
    }

    /**
     * 一天的结束
     *
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public String endOfDay() {
        return localDateTime.toLocalDate() + " " + END_DAY;
    }

    /**
     * 月第一天
     */
    public DateUtil firstDayOfMonth() {
        localDateTime = localDateTime.withDayOfMonth(1);
        return this;
    }

    /**
     * 月最后一天
     */
    public DateUtil lastDayOfMonth() {
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        return this;
    }

    /**
     * 获得年
     *
     * @return 数字年
     */
    public int getYear() {
        return localDateTime.getYear();
    }

    /**
     * 获得月
     *
     * @return 数字月
     */
    public int getMonth() {
        return localDateTime.getMonth().getValue();
    }

    /**
     * 获得月
     *
     * @return 格式字符串
     */
    public String getMonth(String pattern) {
        int zero = 0;
        if (pattern.length() >= 2) {
            zero = 2;
        }
        return String.format("%0" + zero + "d", localDateTime.getMonth().getValue());
    }

    /**
     * 格式化输出
     *
     * @return 格式字符串
     */
    public String format() {
        return format(DEFAULT_PATTERN);
    }

    /**
     * 自定义格式化输出
     *
     * @return 格式字符串
     */
    public String format(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = DEFAULT_PATTERN;
        }
        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
    }

    /**
     * 设置时间
     */
    public DateUtil with(TemporalAdjuster adjuster) {
        localDateTime = localDateTime.with(adjuster);
        return this;
    }

    /**
     * 指定 {@code Year}
     *
     * @param year 年份
     */
    public DateUtil setYear(int year) {
        localDateTime = localDateTime.withYear(year);
        return this;
    }

    /**
     * 指定月 ValueRange.of(1, 12)
     *
     * @param month 月
     */
    public DateUtil setMonth(int month) {
        localDateTime = localDateTime.withMonth(month);
        return this;
    }

    /**
     * 指定一月中的第几天 ValueRange.of(1, 28-31)
     *
     * @param dayOfMonth 一月中的第几天
     */
    public DateUtil setDayOfMonth(int dayOfMonth) {
        localDateTime = localDateTime.withDayOfMonth(dayOfMonth);
        return this;
    }

    /**
     * 指定一年中的第几天 ValueRange.of(1, 365, 366))
     *
     * @param dayOfYear 一年中的第几天
     */
    public DateUtil setDayOfYear(int dayOfYear) {
        localDateTime = localDateTime.withDayOfYear(dayOfYear);
        return this;
    }

    /**
     * 指定小时 ValueRange.of(0, 23)
     *
     * @param hour 小时
     */
    public DateUtil setHour(int hour) {
        localDateTime = localDateTime.withHour(hour);
        return this;
    }

    /**
     * 指定分钟 ValueRange.of(0, 59)
     *
     * @param minute 分钟
     */
    public DateUtil setMinute(int minute) {
        localDateTime = localDateTime.withMinute(minute);
        return this;
    }

    /**
     * 指定秒 ValueRange.of(0, 59)
     *
     * @param second 秒
     */
    public DateUtil setSecond(int second) {
        localDateTime = localDateTime.withSecond(second);
        return this;
    }

    /**
     * 指定毫秒 ValueRange.of(0, 999999999))
     *
     * @param nanoOfSecond 毫秒
     */
    public DateUtil setNano(int nanoOfSecond) {
        localDateTime = localDateTime.withNano(nanoOfSecond);
        return this;
    }

    /**
     * 加多少年
     *
     * @param years 要加的年数
     */
    public DateUtil plusYears(long years) {
        localDateTime = localDateTime.plusYears(years);
        return this;
    }

    /**
     * 加多少月
     *
     * @param months 要加的月数
     */
    public DateUtil plusMonths(long months) {
        localDateTime = localDateTime.plusMonths(months);
        return this;
    }

    /**
     * 加多少周
     *
     * @param weeks 周数
     */
    public DateUtil plusWeeks(long weeks) {
        localDateTime = localDateTime.plusWeeks(weeks);
        return this;
    }

    /**
     * 加多少天
     *
     * @param days 天数
     */
    public DateUtil plusDays(long days) {
        localDateTime = localDateTime.plusDays(days);
        return this;
    }

    /**
     * 加多少小时
     *
     * @param hours 小时数
     */
    public DateUtil plusHours(long hours) {
        localDateTime = localDateTime.plusHours(hours);
        return this;
    }

    /**
     * 加多少分钟
     *
     * @param minutes 分钟数
     */
    public DateUtil plusMinutes(long minutes) {
        localDateTime = localDateTime.plusMinutes(minutes);
        return this;
    }

    /**
     * 加多少秒
     *
     * @param seconds 秒数
     */
    public DateUtil plusSeconds(long seconds) {
        localDateTime = localDateTime.plusSeconds(seconds);
        return this;
    }

    /**
     * 加多少毫秒
     *
     * @param nanos 毫秒数
     */
    public DateUtil plusNanos(long nanos) {
        localDateTime = localDateTime.plusNanos(nanos);
        return this;
    }

    /**
     * 减去一个日期 Period.of(2018,1,18) Duration
     *
     * @param amountToSubtract 日期
     */
    public DateUtil minus(TemporalAmount amountToSubtract) {
        localDateTime = localDateTime.minus(amountToSubtract);
        return this;
    }

    /**
     * 减去一个日期 Period.of(2018,1,18) Duration
     *
     * @param amountToSubtract 日期
     * @param unit             单位
     */
    public DateUtil minus(long amountToSubtract, TemporalUnit unit) {
        localDateTime = localDateTime.minus(amountToSubtract, unit);
        return this;
    }

    /**
     * 减多少年
     *
     * @param years 年数
     */
    public DateUtil minusYears(long years) {
        return (years == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-years));
    }

    /**
     * 减多少月
     *
     * @param months 月数
     */
    public DateUtil minusMonths(long months) {
        return (months == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-months));
    }

    /**
     * 减多少周
     *
     * @param weeks 周数
     */
    public DateUtil minusWeeks(long weeks) {
        return (weeks == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1) : plusWeeks(-weeks));
    }

    /**
     * 减多少天
     *
     * @param days 天数
     */
    public DateUtil minusDays(long days) {
        return (days == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-days));
    }

    /**
     * 减多少小时
     *
     * @param hours 小时数
     */
    public DateUtil minusHours(long hours) {
        localDateTime = localDateTime.minusHours(hours);
        return this;
    }

    /**
     * 减多少分钟
     *
     * @param minutes 分钟数
     */
    public DateUtil minusMinutes(long minutes) {
        localDateTime = localDateTime.minusMinutes(minutes);
        return this;
    }

    /**
     * 减多少秒
     *
     * @param seconds 秒数
     */
    public DateUtil minusSeconds(long seconds) {
        localDateTime = localDateTime.minusSeconds(seconds);
        return this;
    }

    /**
     * 减多少毫秒
     *
     * @param nanos 毫秒数
     */
    public DateUtil minusNanos(long nanos) {
        localDateTime = localDateTime.minusNanos(nanos);
        return this;
    }

    @Override
    public String toString() {
        return format();
    }
}
