package com.qihoo360os;

import com.qihoo360os.common.utils.AmountStatisticsTool;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/6/30.
 */
public class AmountStatisticsTeest {

    @Test
    public void testDate(){
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse("2017/01/01 01:12");
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        AmountStatisticsTool tool = new AmountStatisticsTool();
        String startTime = "2017/01/01";
        String endTime = "2017/01/10";
        HashMap<String, List<String>> map = new HashMap<>();
        String[] day1 = {"A", "B", "C"};
        String[] day2 = {"A", "B", "C","D"};
        String[] day3 = {"A", "B", "C","E"};
        String[] day4 = {"A", "B", "C","E"};
        map.put("2017/01/01 01:10", Arrays.asList(day1));
        map.put("2017/01/01 01:12", Arrays.asList(day2));
        map.put("2017/01/01 01:13", Arrays.asList(day2));
        map.put("2017/01/03 02:10", Arrays.asList(day3));
        map.put("2017/01/03 02:11", Arrays.asList(day3));
        map.put("2017/01/11 01:10", Arrays.asList(day4));
        try {
            Map<String, Integer> result = tool.amountStatic(
                    new SimpleDateFormat("yyyy/MM/dd").parse(startTime),
                    new SimpleDateFormat("yyyy/MM/dd").parse(endTime),
                    AmountStatisticsTool.FLAG_STATICBY_DEFAULT,
                    map);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
