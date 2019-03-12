package com.codyy.cms.utils;

import org.jdeferred2.android.AndroidDeferredManager;

public class DeferredUtils {

    private static final AndroidDeferredManager deferredManager = new AndroidDeferredManager();

    public static AndroidDeferredManager defer() {
        return deferredManager;
    }
}
