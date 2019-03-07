package com.codyy.cms.agora;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * created by lijian on 2019.03.07
 *
 * @version 2.4
 */
@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {
    /**
     * 没有错误
     */
    int SUCCESS = 0;
    /**
     * 未知原因导致退出登录，通常是由于网络问题引起的
     */
    int LOGOUT_E_OTHER = 100;
    /**
     * 用户登出
     */
    int LOGOUT_E_USER = 101;
    /**
     * 网络问题
     */
    int LOGOUT_E_NET = 102;
    /**
     * 该账户已在别处登录
     */
    int LOGOUT_E_KICKED = 103;
    @Deprecated
    int LOGOUT_E_PACKET = 104;
    /**
     * SignalingToken 过期
     */
    int LOGOUT_E_TOKENEXPIRED = 105;
    @Deprecated
    int LOGOUT_E_OLDVERSION = 106;
    @Deprecated
    int LOGOUT_E_TOKENWRONG = 107;
    /**
     * 在处于登出状态时再次调用了 logout()
     */
    int LOGOUT_E_ALREADY_LOGOUT = 108;
    /**
     * 原因未知
     */
    int LOGIN_E_OTHER = 200;
    /**
     * 网络问题
     */
    int LOGIN_E_NET = 201;
    /**
     * 被服务器拒绝
     */
    int LOGIN_E_FAILED = 202;
    /**
     * 用户已取消登录
     */
    int LOGIN_E_CANCEL = 203;
    /**
     * SignalingToken 过期，登录被拒
     */
    int LOGIN_E_TOKENEXPIRED = 204;
    @Deprecated
    int LOGIN_E_OLDVERSION = 205;
    /**
     * SignalingToken 无效
     */
    int LOGIN_E_TOKENWRONG = 206;
    /**
     * 用户已使用更新后的 SignalingToken 在别处登录了系统
     */
    int LOGIN_E_TOKEN_KICKED = 207;
    /**
     * 用户已登录，再次发起登录会触发该错误。可以忽视该错误
     */
    int LOGIN_E_ALREADY_LOGIN = 208;
    /**
     * 用户名不合法
     */
    int LOGIN_E_INVALID_USER = 209;
    /**
     * 加入频道失败未知错误
     */
    int JOINCHANNEL_E_OTHER = 300;
    /**
     * 发送消息失败未知错误
     */
    int SENDMESSAGE_E_OTHER = 400;
    /**
     * 发送消息超时
     */
    int SENDMESSAGE_E_TIMEOUT = 401;
    /**
     * 查询频道用户号码失败
     */
    int QUERYUSERNUM_E_OTHER = 500;
    /**
     * 查询频道用户号码超时
     */
    int QUERYUSERNUM_E_TIMEOUT = 501;
    @Deprecated
    int QUERYUSERNUM_E_BYUSER = 502;
    /**
     * 未知原因导致退出频道
     */
    int LEAVECHANNEL_E_OTHER = 600;
    /**
     * 被管理员踢出频道
     */
    int LEAVECHANNEL_E_KICKED = 601;
    /**
     * 用户不在频道内
     */
    int LEAVECHANNEL_E_BYUSER = 602;
    /**
     * 登出时被踢出频道
     */
    int LEAVECHANNEL_E_LOGOUT = 603;
    /**
     * 网络问题导致退出频道
     */
    int LEAVECHANNEL_E_DISCONN = 604;
    /**
     * 呼叫失败
     */
    int INVITE_E_OTHER = 700;
    /**
     * 重复呼叫
     */
    int INVITE_E_REINVITE = 701;
    /**
     * 网络问题
     */
    int INVITE_E_NET = 702;
    /**
     * 对方处于离线状态
     */
    int INVITE_E_PEEROFFLINE = 703;
    /**
     * 呼叫超时
     */
    int INVITE_E_TIMEOUT = 704;
    @Deprecated
    int INVITE_E_CANTRECV = 705;
    /**
     * 一般错误
     */
    int GENERAL_E = 1000;
    /**
     * 一般错误 - 失败
     */
    int GENERAL_E_FAILED = 1001;
    /**
     * 一般错误 - 未知
     */
    int GENERAL_E_UNKNOWN = 1002;

    /**
     * 一般错误 - 操作前没有登录
     */
    int GENERAL_E_NOT_LOGIN = 1003;
    /**
     * 一般错误 - 参数调用失败
     */
    int GENERAL_E_WRONG_PARAM = 1004;

}
