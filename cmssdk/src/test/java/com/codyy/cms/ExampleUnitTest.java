package com.codyy.cms;

import com.codyy.cms.events.cls.StartWarmupEvent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String name = "V3.2.0.2";
        String[] arrays = name.split("\\.");
        for (String s : arrays) {
            System.out.println(s);
        }
        assertEquals(4, 2 + 2);
        StartWarmupEvent warmupEvent = new StartWarmupEvent();
        warmupEvent.setPlayType("video");
        Object object = warmupEvent;
        ((StartWarmupEvent) object).getPlayType();
    }
}