package com.codyy.cms.utils;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

public class EbusUtils {
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
        } else {
            Logger.e(object.getClass().getSimpleName() + "has not Subscriber For Event");
        }
    }
    public static void postSticky(Object object) {
        if (hasSubscriberForEvent(object.getClass())) {
            EventBus.getDefault().postSticky(object);
        } else {
            Logger.e(object.getClass().getSimpleName() + "has not Subscriber For Event");
        }
    }
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }
}
