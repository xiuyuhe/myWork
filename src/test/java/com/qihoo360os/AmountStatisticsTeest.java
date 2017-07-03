package com.qihoo360os;

import com.qihoo360os.common.utils.AmountStatisticsTool;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/6/30.
 */
public class AmountStatisticsTeest {

    @Test
    public void testDate() {
        try {
            AmountStatisticsTool<Object> tool = new AmountStatisticsTool<>();

            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse("2017/01/01 01:12");
            Date date2 = new SimpleDateFormat("yyyy-w").parse("2017-2");

            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(tool.addOneCycle(date, AmountStatisticsTool.COUNT_BY_MONTH)));
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        AmountStatisticsTool tool = new AmountStatisticsTool();
        String startTime = "2017-01-01";
        String endTime = "2017-03-11";
        HashMap<String, List<String>> map = new HashMap<>();

        map.put("2017-01-01 01:10:10", Arrays.asList("1","2","3"));
        map.put("2017-01-01 01:12:10", Arrays.asList("1","2"));
        map.put("2017-01-01 01:13:10", Arrays.asList("1"));
        map.put("2017-01-03 02:10:10", Arrays.asList("1","2"));
        map.put("2017-01-03 02:11:10", Arrays.asList("1","2","3","4"));
        map.put("2017-01-04 02:11:10", Arrays.asList("1"));
        map.put("2017-01-04 02:12:10", Arrays.asList("1","2"));
        map.put("2017-01-11 01:10:10", Arrays.asList("1"));
        map.put("2017-02-11 01:10:10", Arrays.asList("1","2"));
        map.put("2017-03-11 01:10:10", Arrays.asList("1","2","3"));
        String result = tool.countAmountApi(startTime, endTime, AmountStatisticsTool.COUNT_BY_DAY, map);
        System.out.println(result);

    }

}
