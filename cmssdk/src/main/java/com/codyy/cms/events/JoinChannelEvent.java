package com.codyy.cms.events;

import com.codyy.cms.agora.RtmStatusCode;

import io.agora.rtm.ErrorInfo;

public class JoinChannelEvent extends BaseEvent {
    public JoinChannelEvent(boolean isSuccess, ErrorInfo errorInfo) {
        super(isSuccess, errorInfo);
    }

    @Override
    public String getMsg() {
        if (errorInfo == null) return "加入组成功";
        String msg;
        switch (errorInfo.getErrorCode()) {
            case RtmStatusCode.JoinChannelError.JOIN_CHANNEL_ERR_OK:
                msg = "加入组成功";
                break;
            case RtmStatusCode.JoinChannelError.JOIN_CHANNEL_ERR_FAILURE:
                msg = "加入组失败。原因未知。";
                break;
            case RtmStatusCode.JoinChannelError.JOIN_CHANNEL_ERR_REJECTED:
                msg = "加入组被拒绝。原因可能是该用户已登录，SDK 未初始化或登录被服务器拒绝。";
                break;
            case RtmStatusCode.JoinChannelError.JOIN_CHANNEL_ERR_INVALID_ARGUMENT:
                msg = "无效的加入组参数。";
                break;
            case RtmStatusCode.JoinChannelError.JOIN_CHANNEL_TIMEOUT:
                msg = "加入组超时。目前的超时设置为4秒。";
                break;
            default:
                msg = "其他";
                break;
        }
        return msg;
    }
}
