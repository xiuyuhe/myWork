package com.qihoo360os.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/6/30.
 */
public class AmountStatisticsTool<T> {

    /**
     *  源文件中的 时间数据格式类型
     */
    public static final int SOURCE_DATE_SECOND = 1;
    public static final int SOURCE_DATE_DAY = 2;

    /**
     *  统计类型
     */
    public static final int COUNT_BY_DAY = 11;
    public static final int COUNT_BY_WEEK = 12;
    public static final int COUNT_BY_MONTH = 13;

    /**
     *  时间格式
     */
    public static final String SECOND_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final String DAY_FORMAT_STRING = "yyyy-MM-dd";
    public static final String WEEK_FORMAT_STRING = "yyyy--w";
    public static final String MONTH_FORMAT_STRING = "yyyy-MM";

    private Calendar calendar = Calendar.getInstance();

    /**
     *  按照指定方法，统计资源数量
     * @param start         查询起始时间（包含）
     * @param end           查询截止时间（包含）
     * @param countType     统计类型（COUNT_BY_DAY，COUNT_BY_WEEK，COUNT_BY_MONTH）
     * @param resourceMap   源数据
     * @return
     *              返回 {时间 ： 总量} 的Map
     * @throws AmountStatisticsExceptions
     */
    public Map<String, Integer> countAmount(String start, String end, Integer countType, Map<String, List<T>> resourceMap) throws AmountStatisticsExceptions {
        Integer resourceDateType = getResourceDateFormatType(resourceMap);
        checkCountType(countType, resourceDateType);
        Date startTime = translateString2Date(start, countType);
        Date endTime = addOneCycle(translateString2Date(end, countType), countType);
        checkCountPeriod(startTime, endTime, countType);
        HashMap<String, Integer> resultMap = accountDate(startTime, endTime, resourceMap, countType, resourceDateType);
        return resultMap;

    }

    /**
     *   检查 查询周期是否符合条件：
     *          1.起始时间不能晚于终止时间
     *          2.按周 和 按天 查询 不能查询3个月以上的
     * @param startTime
     * @param endTime
     * @param countType
     */
    private void checkCountPeriod(Date startTime, Date endTime, Integer countType) throws AmountStatisticsExceptions {
        if (countType == COUNT_BY_WEEK || countType == COUNT_BY_DAY){int days = (int) ((endTime.getTime() - startTime.getTime()) / (1000 * 3600 * 24));
            if(days > 90)
                throw new AmountStatisticsExceptions("按周或按天查询，不能大于三个月");
        }
        if(!startTime.before(endTime)){
            throw new AmountStatisticsExceptions("起始时间不能晚于终止时间");
        }
    }

    /**
     *  如果源文件时间是 天， 则不能按照天来统计
     * @param countType
     * @param resourceDateType
     * @throws Exception
     */
    private void checkCountType(Integer countType, Integer resourceDateType) throws AmountStatisticsExceptions {
        if (resourceDateType == SOURCE_DATE_DAY && countType == COUNT_BY_DAY)
            throw new AmountStatisticsExceptions("不能以该统计方式该格式源数据！");
    }

    /**
     *  方法用来计算 下一个周期的时间：下一天，下一周，或者下一个月
     * @param date
     * @param countType
     * @return
     */
    private Date addOneCycle(Date date, Integer countType) {
        calendar.setTime(date);
        switch (countType) {
            case COUNT_BY_DAY:
                calendar.add(Calendar.DATE, 1);
                break;
            case COUNT_BY_WEEK:
                calendar.add(Calendar.DATE, 7);
                break;
            case COUNT_BY_MONTH:
                calendar.add(Calendar.MONTH, 1);
                break;
        }
        return calendar.getTime();
    }

    /**
     * @param startTime    起始时间   （包含当天）
     * @param endTime      终止时间   （包含当天）
     * @param resourceMap  { DateString : List<T>   ... }
     * @param staticFlag   统计方法： 按天，按日，按周
     * @param resourceType 源文件的时间类型
     * @return {DateString : count ...}
     */
    private HashMap<String, Integer> accountDate(Date startTime, Date endTime, Map<String, List<T>> resourceMap, int staticFlag, int resourceType) throws AmountStatisticsExceptions {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<String, List<T>> entry : resourceMap.entrySet()) {
            Date date;
            date = stringToDate(entry.getKey(), resourceType);
            if (!date.before(startTime) && date.before(endTime)) {
                String staticString = dateToString(date, staticFlag);
                resultMap.put(staticString, resultMap.getOrDefault(staticString, 0) + entry.getValue().size());
            }
        }
        return resultMap;
    }

    /**
     *  将 要处理的 时间，按照统计方式，转化为 Date对象
     * @param date
     * @param static_flag
     * @return
     */
    private String dateToString(Date date, int static_flag) {
        String result = "";
        switch (static_flag) {
            case COUNT_BY_DAY:
                result = new SimpleDateFormat(DAY_FORMAT_STRING).format(date);
                break;
            case COUNT_BY_WEEK:
                result = new SimpleDateFormat(WEEK_FORMAT_STRING).format(date);
                break;
            case COUNT_BY_MONTH:
                result = new SimpleDateFormat(MONTH_FORMAT_STRING).format(date);
                break;
        }
        return result;
    }

    /**
     *  转换 源数据中 日期 到 Date 对象
     * @param dateString
     * @param dateFormat
     * @return
     */
    private Date stringToDate(String dateString, int dateFormat) throws AmountStatisticsExceptions {
        Date date = null ;
        try {
            switch (dateFormat) {
                case SOURCE_DATE_SECOND:
                    date = new SimpleDateFormat(SECOND_FORMAT_STRING).parse(dateString);
                    break;
                case SOURCE_DATE_DAY:
                    date = new SimpleDateFormat(DAY_FORMAT_STRING).parse(dateString);
                    break;
            }
        } catch (ParseException e) {
            throw new AmountStatisticsExceptions(" 源数据 转换 错误");
        }
        return date;
    }

    /**
     *  转换查询的参数
     *
     * @param timeStr
     * @param countType
     * @return
     * @throws Exception
     */
    private Date translateString2Date(String timeStr, Integer countType) throws AmountStatisticsExceptions {
        Date date;
        try {
            if (countType == COUNT_BY_DAY) {
                date = new SimpleDateFormat(DAY_FORMAT_STRING).parse(timeStr);
            } else if (countType == COUNT_BY_MONTH) {
                date = new SimpleDateFormat(MONTH_FORMAT_STRING).parse(timeStr);
            } else if (countType == COUNT_BY_WEEK) {
                date = new SimpleDateFormat(WEEK_FORMAT_STRING).parse(timeStr);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new AmountStatisticsExceptions("请输入合法的起止时间！");
        }
        return date;
    }


    private Integer getResourceDateFormatType(Map<String, List<T>> map) {
        int result = 0;
        for (Map.Entry<String, List<T>> entry : map.entrySet()) {
            String dateString = entry.getKey();
            result = getFormatType(dateString);
            break;
        }
        return result;
    }

    private Integer getFormatType(String dateString) {
        return dateString.split(" ").length == 2 ? SOURCE_DATE_SECOND : SOURCE_DATE_DAY;
    }

    private static class AmountStatisticsExceptions extends Exception {
        public AmountStatisticsExceptions() {
        }

        public AmountStatisticsExceptions(String message) {
            super(message);
        }
    }
}
