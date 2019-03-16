package com.codyy.cms.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.codyy.cms.CmsManager;
import com.codyy.cms.core.CmsEngineOpts;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.core.definition.ClassUserRole;
import com.codyy.cms.core.definition.UserRole;
import com.codyy.cms.events.ConnectionStateChangedEvent;
import com.codyy.cms.events.JoinChannelEvent;
import com.codyy.cms.events.LoginEvent;
import com.codyy.cms.events.MemberCountChangedEvent;
import com.codyy.cms.events.cls.AdjustVideoEvent;
import com.codyy.cms.events.cls.BeginTestCardEvent;
import com.codyy.cms.events.cls.BeginTestingEvent;
import com.codyy.cms.events.cls.ClearAllHandUpEvent;
import com.codyy.cms.events.cls.ClsEndEvent;
import com.codyy.cms.events.cls.ClsStartEvent;
import com.codyy.cms.events.cls.EndExplainTestingEvent;
import com.codyy.cms.events.cls.EndSigninEvent;
import com.codyy.cms.events.cls.EndSpeakingEvent;
import com.codyy.cms.events.cls.EndTestCardEvent;
import com.codyy.cms.events.cls.EndTestingEvent;
import com.codyy.cms.events.cls.ExplainTestingEvent;
import com.codyy.cms.events.cls.SelectSpeakerEvent;
import com.codyy.cms.events.cls.SharingDesktopEvent;
import com.codyy.cms.events.cls.StartSigninEvent;
import com.codyy.cms.events.cls.StartWarmupEvent;
import com.codyy.cms.events.cls.StopWarmupEvent;
import com.codyy.cms.events.textchat.TextChatDelMsgEvent;
import com.codyy.cms.events.textchat.TextChatEnabledEvent;
import com.codyy.cms.events.textchat.TextChatMsgEvent;
import com.codyy.cms.events.whiteboard.WhiteBoardEvent;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    //    final AndroidDeferredManager dm = new AndroidDeferredManager();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CmsManager.register(this);
        editText = findViewById(R.id.userId);
        CmsManager.init(new CmsEngineOpts("6ddb8bc251564e95af743486e76dc40e", ""), 1);
        Log.e("Create",System.currentTimeMillis()+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CmsManager.unregister(this);
    }

    /**
     * 订阅CMS SDK 连接状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ConnectionStateChangedEvent event) {
        Logger.d(event.getMsg());
    }

    /**
     * 订阅CMS SDK 登录状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginEvent event) {
        Logger.d(event.getMsg());
    }

    /**
     * 订阅CMS SDK 加入组状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(JoinChannelEvent event) {
        Logger.d(event.getMsg());
    }

    /**
     * 订阅CMS SDK 在线人数变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MemberCountChangedEvent event) {
        Logger.d("在线人数：" + event.count);
    }

    /**
     * 订阅开始暖场事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(StartWarmupEvent event) {
        Logger.d("开始暖场：" + event.getPlayType());
    }

    /**
     * 订阅开始暖场事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(StopWarmupEvent event) {
        Logger.d("结束暖场");
    }

    /**
     * 订阅开始上课事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClsStartEvent event) {
        Logger.d("开始上课：");
    }

    /**
     * 订阅结束上课事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClsEndEvent event) {
        Logger.d("结束上课：");
    }

    /**
     * 订阅开始点名事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(StartSigninEvent event) {
        Logger.d("开始点名");
    }

    /**
     * 订阅结束点名事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndSigninEvent event) {
        Logger.d("结束点名");
    }

    /**
     * 订阅清空举手事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClearAllHandUpEvent event) {
        Logger.d("清空举手");
    }

    /**
     * 订阅指定发言（连麦用此消息）事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SelectSpeakerEvent event) {
        Logger.d("指定发言（连麦用此消息）");
    }

    /**
     * 订阅结束发言事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndSpeakingEvent event) {
        Logger.d("结束发言");
    }

    /**
     * 订阅开始测验事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BeginTestingEvent event) {
        Logger.d("开始测验");
    }

    /**
     * 订阅结束测验事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndTestingEvent event) {
        Logger.d("结束测验");
    }

    /**
     * 订阅开始答题卡答题事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BeginTestCardEvent event) {
        Logger.d("开始答题卡答题");
    }

    /**
     * 订阅结束答题卡答题事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndTestCardEvent event) {
        Logger.d("结束答题卡答题");
    }

    /**
     * 订阅开始/结束共享桌面事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SharingDesktopEvent event) {
        if (event.isSharing()) {
            Logger.d("开始共享桌面");
        } else {
            Logger.d("结束共享桌面");

        }
    }

    /**
     * 订阅教师端画面缩放或全屏事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AdjustVideoEvent event) {
        Logger.d("教师端画面缩放或全屏");
    }

    /**
     * 订阅文字接收事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TextChatMsgEvent event) {
        Logger.d("接收文字");
    }

    /**
     * 订阅删除文字消息事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TextChatDelMsgEvent event) {
        Logger.d("删除文字消息");
    }

    /**
     * 订阅设置/取消某人禁言事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TextChatEnabledEvent event) {
        if (event.isEnabled())
            Logger.d("设置某人禁言");
        else
            Logger.d("取消某人禁言");
    }

    /**
     * 订阅白板事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(WhiteBoardEvent event) {
        Logger.d("白板");
    }

    public void login(View view) {
        String userId = editText.getText().toString();
        CmsManager.login(new LoginOptions(Integer.valueOf(userId), userId, UserRole.STUDENT, ClassUserRole.STUDENT, BuildConfig.DEBUG));
    }

}
