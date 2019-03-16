package com.codyy.cms;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.codyy.cms.core.CmsEngine;
import com.codyy.cms.core.CmsEngineOpts;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.core.definition.AppActive;
import com.codyy.cms.provider.CmsLifecycleObserver;
import com.codyy.cms.utils.EbusUtils;

public class CmsManager {
    /**
     * 注册事件监听
     *
     * @param subscriber 订阅者
     */
    public static void register(Object subscriber) {
        if (subscriber instanceof FragmentActivity) {
            ((FragmentActivity) subscriber).getLifecycle().addObserver(new CmsLifecycleObserver());
        } else if (subscriber instanceof Fragment) {
            ((Fragment) subscriber).getLifecycle().addObserver(new CmsLifecycleObserver());
        } else {
            throw new IllegalArgumentException("subscriber must be extends support v4 package FragmentActivity or  Fragment");
        }
        EbusUtils.register(subscriber);
    }

    /**
     * 解除事件监听
     *
     * @param subscriber 订阅者
     */
    public static void unregister(Object subscriber) {
        EbusUtils.unregister(subscriber);
    }

    /**
     * 初始化CmsEngine
     *
     * @param opts        配置参数
     * @param liveClassId 课堂id
     */
    public static void init(CmsEngineOpts opts, int liveClassId) {
        CmsEngine.getInstance().init(opts, liveClassId);
    }

    /**
     * 登录
     *
     * @param loginOptions 配置参数
     */
    public static void login(LoginOptions loginOptions) {
        CmsEngine.getInstance().login(loginOptions);
    }

    /**
     * 点名-签到
     */
    public static void sendSignInMsg() {
        CmsEngine.getInstance().sendSignInMsg();
    }

    /**
     * 举手发言
     */
    public static void sendHandingUpMsg() {
        CmsEngine.getInstance().sendHandingUpMsg();
    }

    /**
     * 取消举手
     */
    public static void sendCancelHandingUpMsg() {
        CmsEngine.getInstance().sendCancelHandingUpMsg();
    }

    /**
     * 结束发言
     */
    public static void sendEndSpeakingMsg() {
        CmsEngine.getInstance().sendEndSpeakingMsg();
    }

    /**
     * 发送截屏图片地址
     * @param originalMsgId 发送截图指令的消息Id
     * @param imageUrl 截图地址
     */
    public static void sendCaptureScreenUrlMsg(@NonNull String originalMsgId, @NonNull String imageUrl) {
        CmsEngine.getInstance().sendCaptureScreenUrlMsg(originalMsgId, imageUrl);
    }

    /**
     * 发送认真度通知
     * @param action {@link AppActive} "active"|"inactive", //切到前台或后台
     * @param activeDuration 单位分钟
     * @param inactiveDuration 单位分钟
     */
    public static void sendAppSwitchedMsg(@AppActive String action, int activeDuration, int inactiveDuration) {
        CmsEngine.getInstance().sendAppSwitchedMsg(action, activeDuration, inactiveDuration);
    }

    /**
     * 发送讨论消息
     * @param msg 非空消息内容
     */
    public static void sendChatMsg(@NonNull String msg) {
        CmsEngine.getInstance().sendChatMsg(msg);
    }
}
