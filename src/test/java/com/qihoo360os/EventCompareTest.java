package com.qihoo360os;

import com.qihoo360os.service.impl.EventCompareServiceImpl;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by i-hexiuyu on 2017/6/29.
 */
public class EventCompareTest {
    @Test
    public void EventCompareServiceTest(){
        EventCompareServiceImpl eventCompareService = new EventCompareServiceImpl();
        try {
            eventCompareService.eventCompare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
