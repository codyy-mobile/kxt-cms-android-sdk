package com.codyy.cms.core;

import android.text.TextUtils;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageHeader;

public class MessageEngine {

    /**
     * Validate message fields.
     *
     * @param {Message} message
     * @private
     * @memberof MessageEngine
     */
    private void validateMsg(Message message) throws CmsException {
        if (message.header == null) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_HEADER, "Message header is null.");
        }

        MessageHeader header = message.header;
        if (TextUtils.isEmpty(header.getName())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_NAME, "Message name is not set.");
        }

        if (TextUtils.isEmpty(header.getType())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_TYPE, "Message type is not set.");
        }

        if (TextUtils.isEmpty(header.getSendType())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_SENDTYPE, "Message sendType is not set.");
        }
    }
}
