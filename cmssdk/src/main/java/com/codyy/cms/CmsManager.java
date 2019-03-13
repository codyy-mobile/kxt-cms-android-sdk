package com.codyy.cms;

import com.codyy.cms.core.CmsEngine;
import com.codyy.cms.core.CmsEngineOpts;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.utils.EbusUtils;

public class CmsManager {
    public static void register(Object subscriber) {
        EbusUtils.register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EbusUtils.unregister(subscriber);
    }

    public static void init(CmsEngineOpts opts, int liveClassId) {
        CmsEngine.getInstance().init(opts, liveClassId);
    }

    public static void login(LoginOptions loginOptions) {
        CmsEngine.getInstance().login(loginOptions);
    }

    public static void logout() {
        CmsEngine.getInstance().logout();
    }
}
