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
            //eventCompareService.eventCompare();
            eventCompareService.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @After
    public void after(){
        endTime = System.currentTimeMillis();
        System.out.println("方法运行时间 : " + (endTime - startTime) + " ms");
    }
}
