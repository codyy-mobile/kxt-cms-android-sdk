package com.codyy.cms.events;

import com.codyy.cms.agora.RtmStatusCode;

import io.agora.rtm.ErrorInfo;

public class LoginEvent extends BaseEvent {
    public LoginEvent(boolean isSuccess, ErrorInfo errorInfo) {
        super(isSuccess, errorInfo);
    }

    @Override
    public String getMsg() {
        if (errorInfo == null) return "登录成功";
        String msg;
        switch (errorInfo.getErrorCode()) {
            case RtmStatusCode.LoginError.LOGIN_ERR_OK:
                msg = "登录成功。没有错误。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_UNKNOWN:
                msg = "登录失败。原因未知。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_REJECTED:
                msg = "登录被拒绝。原因可能是该用户已登录，SDK 未初始化或登录被服务器拒绝。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_INVALID_ARGUMENT:
                msg = "无效的登录参数。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_INVALID_APP_ID:
                msg = "无效的App ID。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_INVALID_TOKEN:
                msg = "无效的Token。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_TOKEN_EXPIRED:
                msg = "Token 已过期，登录被拒绝。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_NOT_AUTHORIZED:
                msg = "未经授权的登录。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_ALREADY_LOGIN:
                msg = "用户已登录，或已正在登录 Agora RTM 系统。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_TIMEOUT:
                msg = "登录超时。目前的超时设置为4秒。";
                break;
            case RtmStatusCode.LoginError.LOGIN_ERR_TOO_OFTEN:
                msg = "登录或登出过于频繁。";
                break;
            default:
                msg = "其他";
                break;
        }
        return msg;
    }

}
