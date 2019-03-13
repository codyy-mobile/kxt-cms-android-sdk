package com.codyy.cms.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.codyy.cms.core.CmsEngine;
import com.codyy.cms.core.CmsEngineOpts;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.core.definition.ClassUserRole;
import com.codyy.cms.core.definition.UserRole;
import com.codyy.cms.events.ConnectionStateChangedEvent;
import com.codyy.cms.events.JoinChannelEvent;
import com.codyy.cms.events.LoginEvent;
import com.codyy.cms.events.MemberCountChangedEvent;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    //    final AndroidDeferredManager dm = new AndroidDeferredManager();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        editText = findViewById(R.id.userId);
        CmsEngine.getInstance().init(new CmsEngineOpts("6ddb8bc251564e95af743486e76dc40e", ""), 1);
    }

    /**
     * 订阅连接状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ConnectionStateChangedEvent event) {
        Logger.d(event.getMsg());
    }

    /**
     * 订阅登录状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginEvent event) {
        Logger.d(event.getMsg());
    }
    /**
     * 订阅加入组状态变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(JoinChannelEvent event) {
        Logger.d(event.getMsg());
    }

    /**
     * 订阅在线人数变化事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MemberCountChangedEvent event) {
        Logger.d("在线人数：" + event.count);
    }

    public void login(View view) {
        String userId = editText.getText().toString();
        CmsEngine.getInstance().login(new LoginOptions(Integer.valueOf(userId), userId, UserRole.STUDENT, ClassUserRole.STUDENT, BuildConfig.DEBUG));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        CmsEngine.getInstance().logout();
    }
}
