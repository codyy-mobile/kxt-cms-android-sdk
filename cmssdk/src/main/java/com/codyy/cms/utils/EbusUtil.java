package com.codyy.cms.utils;

import org.greenrobot.eventbus.EventBus;

public class EbusUtil {
    /**
     * 是否订阅
     *
     * @param eventClass
     * @return
     */
    private static boolean hasSubscriberForEvent(Class<?> eventClass) {
        return EventBus.getDefault().hasSubscriberForEvent(eventClass);
    }

    public static void post(Object object) {
        if (hasSubscriberForEvent(object.getClass())) {
            EventBus.getDefault().post(object);
        }
    }

    public static void postSticky(Object object) {
        if (hasSubscriberForEvent(object.getClass())) {
            EventBus.getDefault().postSticky(object);
        }
    }
}
