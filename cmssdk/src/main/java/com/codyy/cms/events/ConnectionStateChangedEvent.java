package com.codyy.cms.events;

import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_BANNED_BY_SERVER;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_INTERRUPTED;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_LOGIN;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_LOGIN_FAILURE;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_LOGIN_SUCCESS;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_LOGIN_TIMEOUT;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionChangeReason.CONNECTION_CHANGE_REASON_LOGOUT;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionState.CONNECTION_STATE_ABORTED;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionState.CONNECTION_STATE_CONNECTED;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionState.CONNECTION_STATE_CONNECTING;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionState.CONNECTION_STATE_DISCONNECTED;
import static com.codyy.cms.agora.RtmStatusCode.ConnectionState.CONNECTION_STATE_RECONNECTING;

public class ConnectionStateChangedEvent {
    public int state;
    public int reason;

    public ConnectionStateChangedEvent(int state, int reason) {
        this.state = state;
        this.reason = reason;
    }

    public String getMsg() {
        StringBuilder stringBuilder = new StringBuilder();
        getCompose(stringBuilder, "state", state, getStateDesc(state));
        getCompose(stringBuilder, "reason", reason, getReasonDesc(reason));
        return stringBuilder.toString();
    }

    private StringBuilder getCompose(StringBuilder stringBuilder, String title, int code, String desc) {
        stringBuilder.append(" ");
        stringBuilder.append(title);
        stringBuilder.append(":");
        stringBuilder.append(code);
        stringBuilder.append(";desc:");
        stringBuilder.append(desc);
        return stringBuilder;
    }

    private String getStateDesc(int state) {
        String desc;
        switch (state) {
            case CONNECTION_STATE_DISCONNECTED:
                desc = "初始状态。SDK 未连接到 Agora RTM 系统。";
                break;
            case CONNECTION_STATE_CONNECTING:
                desc = "SDK 正在登录 Agora RTM 系统。";
                break;
            case CONNECTION_STATE_CONNECTED:
                desc = "SDK 已登录 Agora RTM 系统。";
                break;
            case CONNECTION_STATE_RECONNECTING:
                desc = "SDK 正在重新登录 Agora RTM 系统。";
                break;
            case CONNECTION_STATE_ABORTED:
                desc = " SDK 停止登录 Agora RTM 系统。";
                break;
            default:
                desc = "其他";
                break;
        }
        return desc;
    }

    private String getReasonDesc(int reason) {
        String desc;
        switch (reason) {
            case CONNECTION_CHANGE_REASON_LOGIN:
                desc = "CONNECTION_CHANGE_REASON_LOGIN";
                break;
            case CONNECTION_CHANGE_REASON_LOGIN_SUCCESS:
                desc = "CONNECTION_CHANGE_REASON_LOGIN_SUCCESS";
                break;
            case CONNECTION_CHANGE_REASON_LOGIN_FAILURE:
                desc = "CONNECTION_CHANGE_REASON_LOGIN_FAILURE";
                break;
            case CONNECTION_CHANGE_REASON_LOGIN_TIMEOUT:
                desc = "CONNECTION_CHANGE_REASON_LOGIN_TIMEOUT";
                break;
            case CONNECTION_CHANGE_REASON_INTERRUPTED:
                desc = "CONNECTION_CHANGE_REASON_INTERRUPTED";
                break;
            case CONNECTION_CHANGE_REASON_LOGOUT:
                desc = "CONNECTION_CHANGE_REASON_LOGOUT";
                break;
            case CONNECTION_CHANGE_REASON_BANNED_BY_SERVER:
                desc = "CONNECTION_CHANGE_REASON_BANNED_BY_SERVER";
                break;
            default:
                desc = "其他原因";
                break;
        }
        return desc;
    }
}
