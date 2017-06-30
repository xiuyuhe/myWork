package com.qihoo360os;

import com.qihoo360os.service.impl.EventCompareServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/6/29.
 */
public class EventCompareTest {
    Long startTime;
    Long endTime;

    @Before
    public void before(){
        startTime = System.currentTimeMillis();
    }

    @Test
    public void EventCompareServiceTest(){
        EventCompareServiceImpl eventCompareService = new EventCompareServiceImpl();
        try {
            eventCompareService.eventCompare();
//            eventCompareService.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestHash(){
        HashSet<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("3");
        set1.add("1");

        HashSet<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");

        HashSet<String> set3 = new HashSet<>();
        set3.add("2");
        set3.add("3");
        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());
        System.out.println(set3.hashCode());
        System.out.println(" --- ");

        EventCompareServiceImpl.EventSequence eventSequence1 = new EventCompareServiceImpl.EventSequence(set1);
        EventCompareServiceImpl.EventSequence eventSequence2 = new EventCompareServiceImpl.EventSequence(set2);
        EventCompareServiceImpl.EventSequence eventSequence3 = new EventCompareServiceImpl.EventSequence(set3);

        System.out.println(String.valueOf(eventSequence1.hashCode()));
        System.out.println(String.valueOf(eventSequence2.hashCode()));
        System.out.println(String.valueOf(eventSequence3.hashCode()));

        System.out.println(eventSequence1.equals(eventSequence2));
        System.out.println(eventSequence1.equals(eventSequence3));
        HashSet<EventCompareServiceImpl.EventSequence> set = new HashSet<>();
        set.add(eventSequence1);
        set.add(eventSequence2);
        set.add(eventSequence3);

    }



    @After
    public void after(){
        endTime = System.currentTimeMillis();
        System.out.println("方法运行时间 : " + (endTime - startTime) + " ms");
    }
}
