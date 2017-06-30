package com.qihoo360os.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i-hexiuyu on 2017/6/30.
 */
public class AmountStatisticsTool<T> {

    public static final int DATE_FORMAT_HOUR = 1;
    public static final int DATE_FORMAT_DAY = 2;
    public static final int DATE_FORMAT_MOUNTH = 3;

    public static final int FLAG_STATICBY_DAY = 11;
    public static final int FLAG_STATICBY_WEEK = 12;
    public static final int FLAG_STATICBY_MOUNTH = 13;

    public static final String SECOND_FORMAT_STRING = "yyyy/MM/dd HH:mm:ss";
    public static final String DAY_FORMAT_STRING = "yyyy/MM/dd";
    public static final String WEEK_FORMAT_STRING = "";
    public static final String MONTH_FORMAT_STRING = "yyyy/MM";


    public Map<String, Integer> countAmount(String start, String end, Integer countType, Map<String, List<T>> resourceMap) throws Exception {
        Integer resourceDateType = getResourceDateFormatType(resourceMap);
        checkCount(countType, resourceDateType);
        Date startTime = getStartTime(start, countType);
        Date endTime = getEndTime(end, countType);
        HashMap<String, Integer> resultMap = new HashMap<>();
        return resultMap = accountDate(startTime, endTime, resourceMap, countType, resourceDateType);

    }

    private void checkCount(Integer countType, Integer resourceDateType) throws Exception {
        if (resourceDateType == DATE_FORMAT_DAY && countType == FLAG_STATICBY_DAY)
            throw new Exception("day source data can't statistic in day type");
    }

    private Date getStartTime(String start, Integer countType) throws Exception {
        Date date = null;
        try {
            if (countType == FLAG_STATICBY_DAY) {
                date = new SimpleDateFormat(DAY_FORMAT_STRING).parse(start);
            } else if (countType == FLAG_STATICBY_MOUNTH) {
                date = new SimpleDateFormat(MONTH_FORMAT_STRING).parse(start);
            } else if (countType == FLAG_STATICBY_WEEK) {
                date = new SimpleDateFormat(WEEK_FORMAT_STRING).parse(start);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("请输入合法的起止时间！");
        }
        return date;
    }

    private Date getEndTime(String end, Integer countType) {
        return null;
    }


    /**
     * @param startTime    起始时间   （包含当天）
     * @param endTime      终止时间   （包含当天）
     * @param resourceMap  { DateString : List<T>   ... }
     * @param staticFlag   统计方法： 按照默认，按天，按日，按周
     * @param resourceType 源文件的时间类型
     * @return {DateString : count ...}
     */
    private HashMap<String, Integer> accountDate(Date startTime, Date endTime, Map<String, List<T>> resourceMap, int staticFlag, int resourceType) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<String, List<T>> entry : resourceMap.entrySet()) {
            Date date = stringToDate(entry.getKey(), resourceType);
            if (!date.before(startTime) && !date.after(endTime)) {
                String staticString = dateToString(date, staticFlag);
                resultMap.put(staticString, resultMap.getOrDefault(staticString, 0) + entry.getValue().size());
            }
        }
        return resultMap;
    }

    private String dateToString(Date date, int static_flag) {
        String result = "";
        switch (static_flag) {
            case FLAG_STATICBY_DAY:
                result = new SimpleDateFormat("yyyy/MM/dd").format(date);
                break;
            case FLAG_STATICBY_MOUNTH:
                break;
        }
        return result;
    }

    public Date stringToDate(String dateString, int dateFormat) {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        switch (dateFormat) {
            case DATE_FORMAT_HOUR:
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                break;
            case DATE_FORMAT_DAY:
                sdf = new SimpleDateFormat("yyyy/MM/dd");
                break;
        }
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public Integer getResourceDateFormatType(Map<String, List<T>> map) {
        int result = 0;
        for (Map.Entry<String, List<T>> entry : map.entrySet()) {
            String dateString = entry.getKey();
            result = getFormatType(dateString);
            break;
        }
        return result;
    }

    public Integer getFormatType(String dateString) {
        return dateString.split(" ").length == 2 ? DATE_FORMAT_HOUR : dateString.split(" ")[0].split("/").length == 3 ? DATE_FORMAT_DAY : DATE_FORMAT_MOUNTH;
    }
}
