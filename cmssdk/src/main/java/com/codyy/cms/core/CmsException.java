package com.codyy.cms.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CmsException extends Exception {
    private CmsErrorCode cmsErrorCode;

    public CmsException(CmsErrorCode cmsErrorCode, String message) {
        super(message);
        this.cmsErrorCode = cmsErrorCode;
    }

    public CmsErrorCode getCmsErrorCode() {
        return cmsErrorCode;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CmsErrorCode {
        int COMMON_ERROR = 1001;
        int NO_PARAMETER = 1002;
        int MSG_NO_HEADER = 2001;
        int MSG_NO_NAME = 2002;
        int MSG_NO_TYPE = 2003;
        int MSG_NO_SENDTYPE = 2004;
        int MSG_NO_SENDERACCOUNT = 2005;
        int MSG_TARGETS_OUT_OF_LIMIT = 2006;

    }

}
