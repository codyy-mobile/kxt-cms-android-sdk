package com.codyy.cms.agora;

public interface RtmStatusCode {
    interface GetMembersError {
        int GET_MEMBERS_ERR_OK = 0;
        int GET_MEMBERS_ERR_FAILURE = 1;
        int GET_MEMBERS_ERR_REJECTED = 2;
        int GET_MEMBERS_ERR_TIMEOUT = 3;
    }

    interface ChannelMessageState {
        int CHANNEL_MESSAGE_INIT = 0;
        int CHANNEL_MESSAGE_FAILURE = 1;
        int CHANNEL_MESSAGE_RECEIVED_BY_SERVER = 2;
        int CHANNEL_MESSAGE_SENT_TIMEOUT = 4;
    }

    interface LeaveChannelError {
        int LEAVE_CHANNEL_ERR_OK = 0;
        int LEAVE_CHANNEL_ERR_FAILURE = 1;
        int LEAVE_CHANNEL_ERR_REJECTED = 2;
    }

    interface JoinChannelError {
        int JOIN_CHANNEL_ERR_OK = 0;
        int JOIN_CHANNEL_ERR_FAILURE = 1;
        int JOIN_CHANNEL_ERR_REJECTED = 2;
        int JOIN_CHANNEL_ERR_INVALID_ARGUMENT = 3;
        int JOIN_CHANNEL_TIMEOUT = 4;
        int JOIN_CHANNEL_NULL = 5;
    }

    interface PeerMessageState {
        int PEER_MESSAGE_INIT = 0;
        int PEER_MESSAGE_FAILURE = 1;
        int PEER_MESSAGE_PEER_UNREACHABLE = 2;
        int PEER_MESSAGE_RECEIVED_BY_PEER = 3;
        int PEER_MESSAGE_SENT_TIMEOUT = 4;
    }

    interface ConnectionChangeReason {
        int CONNECTION_CHANGE_REASON_LOGIN = 1;
        int CONNECTION_CHANGE_REASON_LOGIN_SUCCESS = 2;
        int CONNECTION_CHANGE_REASON_LOGIN_FAILURE = 3;
        int CONNECTION_CHANGE_REASON_LOGIN_TIMEOUT = 4;
        int CONNECTION_CHANGE_REASON_INTERRUPTED = 5;
        int CONNECTION_CHANGE_REASON_LOGOUT = 6;
        int CONNECTION_CHANGE_REASON_BANNED_BY_SERVER = 7;
    }

    interface ConnectionState {
        /**
         * 初始状态。SDK 未连接到 Agora RTM 系统。</br>
         * <ul>
         * <li>
         * App 调用方法 login 时，SDK 开始登录 Agora RTM 系统，触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_CONNECTING} 状态。
         * </li>
         * </ul>
         */
        int CONNECTION_STATE_DISCONNECTED = 1;
        /**
         * SDK 正在登录 Agora RTM 系统。</br>
         * <ul>
         * <li>
         * 方法调用成功时，SDK 会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_CONNECTED} 状态。
         * </li>
         * <li>
         * 方法调用失败，SDK 会触发回调 onConnectionStateChanged，并切换到 {@link ConnectionState#CONNECTION_STATE_DISCONNECTED} 状态。
         * </li>
         * </ul>
         */
        int CONNECTION_STATE_CONNECTING = 2;
        /**
         * SDK 已登录 Agora RTM 系统。</br>
         * <ul>
         * <li>
         * 如果 SDK 与 Agora RTM 系统的连接由于网络问题中断，SDK 会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_RECONNECTING} 状态。
         * </li>
         * <li>
         * 如果 SDK 因为相同 ID 已在其他实例或设备中登录等原因被服务器禁止登录，会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_ABORTED} 状态。
         * </li>
         * <li>
         * 如果 App 调用方法 logout ，SDK 登出 Agora RTM 系统成功，会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_DISCONNECTED} 状态。
         * </li>
         * </ul>
         */
        int CONNECTION_STATE_CONNECTED = 3;
        /**
         * SDK 正在重新登录 Agora RTM 系统。</br>
         * <ul>
         * <li>
         * 如果 SDK 重新登录 Agora RTM 系统成功，会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_CONNECTED} 状态。
         * </li>
         * <li>
         * 如果 SDK 重新登录 Agora RTM 系统失败，会保持 {@link  ConnectionState#CONNECTION_STATE_RECONNECTING} 状态。
         * </li>
         * <li>
         * 如果登录被服务器拒绝，SDK 会触发回调 onConnectionStateChanged，并切换到 {@link  ConnectionState#CONNECTION_STATE_CONNECTED} 状态。
         * </li>
         * </ul>
         */
        int CONNECTION_STATE_RECONNECTING = 4;
        /**
         * SDK 停止登录 Agora RTM 系统。</br>
         * 原因可能为：</br>
         * <ul>
         * <li>
         * 另一实例已经以同一用户 ID 登录 Agora RTM 系统。
         * </li>
         * <li>
         * token 已过期。
         * </li>
         * </ul>
         * 请在调用方法 logout 后，调用方法 login 登录 Agora RTM 系统。
         */
        int CONNECTION_STATE_ABORTED = 5;
    }

    interface LogoutError {
        /**
         * 登出成功。没有错误。
         */
        int LOGOUT_ERR_OK = 0;
        /**
         * 登出失败。原因可能是 SDK 未初始化，或用户未登录。
         */
        int LOGOUT_ERR_REJECTED = 1;
    }

    interface LoginError {
        int LOGIN_ERR_OK = 0;
        int LOGIN_ERR_UNKNOWN = 1;
        int LOGIN_ERR_REJECTED = 2;
        int LOGIN_ERR_INVALID_ARGUMENT = 3;
        int LOGIN_ERR_INVALID_APP_ID = 4;
        int LOGIN_ERR_INVALID_TOKEN = 5;
        int LOGIN_ERR_TOKEN_EXPIRED = 6;
        int LOGIN_ERR_NOT_AUTHORIZED = 7;
        int LOGIN_ERR_ALREADY_LOGIN = 8;
        int LOGIN_ERR_TIMEOUT = 9;
        int LOGIN_ERR_TOO_OFTEN = 10;
    }
}
