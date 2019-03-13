package com.codyy.cms.utils;

import com.codyy.cms.agora.ErrorCode;

@Deprecated
public class GeneralEvent {
    public static String getEventString(int code) {
        String msg;
        switch (code) {
            case ErrorCode.SUCCESS:
                msg = "没有错误";
                break;
            case ErrorCode.LOGOUT_E_OTHER:
                msg = "未知原因导致退出登录,通常是由于网络问题引起的";
                break;
            case ErrorCode.LOGOUT_E_USER:
                msg = "用户登出";
                break;
            case ErrorCode.LOGOUT_E_NET:
                msg = "网络问题";
                break;
            case ErrorCode.LOGOUT_E_KICKED:
                msg = "该账户已在别处登录";
                break;
            case ErrorCode.LOGOUT_E_PACKET:
                msg = "已被弃用";
                break;
            case ErrorCode.LOGOUT_E_TOKENEXPIRED:
                msg = "SignalingToken 过期";
                break;
            case ErrorCode.LOGOUT_E_ALREADY_LOGOUT:
                msg = "在处于登出状态时再次调用了 logout()";
                break;
            case ErrorCode.LOGIN_E_OTHER:
                msg = "原因未知";
                break;
            case ErrorCode.LOGIN_E_NET:
                msg = "网络问题";
                break;
            case ErrorCode.LOGIN_E_FAILED:
                msg = "被服务器拒绝";
                break;
            case ErrorCode.LOGIN_E_CANCEL:
                msg = "用户已取消登录";
                break;
            case ErrorCode.LOGIN_E_TOKENEXPIRED:
                msg = "SignalingToken 过期，登录被拒";
                break;
            case ErrorCode.LOGIN_E_TOKENWRONG:
                msg = "SignalingToken 无效";
                break;
            case ErrorCode.LOGIN_E_TOKEN_KICKED:
                msg = "用户已使用更新后的 SignalingToken 在别处登录了系统";
                break;
            case ErrorCode.LOGIN_E_ALREADY_LOGIN:
                msg = "用户已登录，再次发起登录会触发该错误。可以忽视该错误";
                break;
            case ErrorCode.LOGIN_E_INVALID_USER:
                msg = "用户名不合法";
                break;
            case ErrorCode.JOINCHANNEL_E_OTHER:
                msg = "加入频道失败未知错误";
                break;
            case ErrorCode.SENDMESSAGE_E_OTHER:
                msg = "发送消息失败未知错误";
                break;
            case ErrorCode.SENDMESSAGE_E_TIMEOUT:
                msg = "发送消息超时";
                break;
            case ErrorCode.QUERYUSERNUM_E_OTHER:
                msg = "查询频道用户号码失败";
                break;
            case ErrorCode.QUERYUSERNUM_E_TIMEOUT:
                msg = "查询频道用户号码超时";
                break;
            case ErrorCode.LEAVECHANNEL_E_OTHER:
                msg = "未知原因导致退出频道";
                break;
            case ErrorCode.LEAVECHANNEL_E_KICKED:
                msg = "被管理员踢出频道";
                break;
            case ErrorCode.LEAVECHANNEL_E_BYUSER:
                msg = "用户不在频道内";
                break;
            case ErrorCode.LEAVECHANNEL_E_LOGOUT:
                msg = "登出时被踢出频道";
                break;
            case ErrorCode.LEAVECHANNEL_E_DISCONN:
                msg = "网络问题导致退出频道";
                break;
            case ErrorCode.INVITE_E_OTHER:
                msg = "呼叫失败";
                break;
            case ErrorCode.INVITE_E_REINVITE:
                msg = "重复呼叫";
                break;
            case ErrorCode.INVITE_E_NET:
                msg = "网络问题";
                break;
            case ErrorCode.INVITE_E_PEEROFFLINE:
                msg = "对方处于离线状态";
                break;
            case ErrorCode.INVITE_E_TIMEOUT:
                msg = "呼叫超时";
                break;
            case ErrorCode.GENERAL_E:
                msg = "一般错误";
                break;
            case ErrorCode.GENERAL_E_FAILED:
                msg = "一般错误 - 失败";
                break;
            case ErrorCode.GENERAL_E_UNKNOWN:
                msg = "一般错误 - 未知";
                break;
            case ErrorCode.GENERAL_E_NOT_LOGIN:
                msg = "一般错误 - 操作前没有登录";
                break;
            case ErrorCode.GENERAL_E_WRONG_PARAM:
                msg = "一般错误 - 参数调用失败";
                break;
            default:
                msg = "code:" + code + ",未知错误类型";
                break;
        }
        return msg;
    }
}
