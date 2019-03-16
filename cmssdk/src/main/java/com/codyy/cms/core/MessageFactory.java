package com.codyy.cms.core;

import com.codyy.cms.core.definition.AppActive;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageHeader;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.events.sys.Screenshot;
import com.codyy.cms.events.sys.SwitchApp;
import com.codyy.cms.events.textchat.TextChatMsg;
import com.codyy.cms.ext.user.User;
import com.codyy.cms.ext.user.UserMsgModule;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class MessageFactory {
    private UserMsgModule userMsgModule;

    public void setUserMsgModule(UserMsgModule userMsgModule) {
        this.userMsgModule = userMsgModule;
    }

    /**
     * Return current user Id.
     *
     * @return
     */
    private int getUserId() {
        return this.userMsgModule.getMe().attributes.userId;
    }

    /**
     * Return all target user ids of message rule def.
     *
     * @param msgRuleDef
     * @return
     */
    private ArrayList<Integer> getTargetUserIds(MessagesRuleDef msgRuleDef) {
        if (msgRuleDef.receiverRoles != null) {
            ArrayList<Integer> userIds = new ArrayList<>();
            for (String classUserRole : msgRuleDef.receiverRoles) {
                LinkedList<Integer> ids = this.userMsgModule.getClassUserRoleIds(classUserRole);
                if (ids != null && ids.size() > 0) {
                    userIds.addAll(ids);
                }

            }
            return userIds;
        }
        return new ArrayList<>();
    }

    private String getClassUserRole(int userId) {
        return this.userMsgModule.getUserInfo(userId).attributes.classUserRole;
    }

    private String getDefaultClassUserRole() {
        return this.userMsgModule.getUserInfo(this.getUserId()).attributes.classUserRole;
    }

    private User getUser(int userId) {
        return this.userMsgModule.getUserInfo(userId);
    }

    private User getDefaultUser() {
        return this.userMsgModule.getUserInfo(this.getUserId());
    }

    public MessageHeader createMessageHeader(MessagesRuleDef msgRuleDef, int userId) {
        MessageHeader header = new MessageHeader();
        header.name = msgRuleDef.name;
        header.type = msgRuleDef.type;
        header.sendType = msgRuleDef.sendType;
        header.userId = userId;
        header.timestamp = System.currentTimeMillis();

        ArrayList<Integer> targetUserIds = this.getTargetUserIds(msgRuleDef);
        if (targetUserIds != null && targetUserIds.size() > 0) {
            header.targetUserIds = targetUserIds;
        }
        return header;
    }

    public MessageHeader createDefaultMessageHeader(MessagesRuleDef msgRuleDef) {
        int userId = this.userMsgModule.getUserInfo(this.getUserId()).attributes.userId;
        return this.createMessageHeader(msgRuleDef, userId);
    }

    /*start->userMsg*******************************************************************************/
    public Message createSendUserInfoMsg(User user) {
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.USER_INFO), user);
    }

    /*end->userMsg*********************************************************************************/
    /*start->class*********************************************************************************/

    /**
     * 名称：签到
     * name：class_signin(学员端发起)
     * <p>
     * 功能：学员点击签到按钮并通过信令消息通知教师和服务端匿名管理用户
     * <p>
     * 发送类型：CP2M（Student to Teacher & Assistant & Anonymouse_Admin）
     * <p>
     * Request：No body
     * <p>
     * Response: N/A
     *
     * @return Message
     */
    public Message createSignInMsg() {
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_SIGNIN));
    }

    /**
     * 名称：举手
     * name：class_hand_up（非老师发起)
     * <p>
     * 功能：学员点击请求发言按钮并通过信令消息通知教师
     * <p>
     * 发送类型：CP2M（No teacher to Teacher & Assistant & Anonymouse_Admin）
     *
     * @return Message
     */
    public Message createHandUpMsg() {
        try {
            return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_HAND_UP), new JSONObject().put("classUserRole", this.getDefaultClassUserRole()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 名称：取消举手
     * 消息名称：class_cancel_hand_up(非老师发起)
     * <p>
     * 功能：通过信令消息通知教师
     * <p>
     * 发送类型：CP2M（No teacher to Teacher & Assistant & Anonymouse_Admin）
     * <p>
     * Request：No body
     * <p>
     * Response: N/A
     *
     * @return Message
     */
    public Message createCancelHandUpMsg() {
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_CANCEL_HAND_UP));
    }

    /**
     * 名称：结束发言
     * 消息名称：class_end_speaking(教师端或学生自己发起)
     * <p>
     * 功能：教师终止某个学生发言或发言学生自己终止
     * <p>
     * 发送类型：CP2A（Teacher/Student to All）
     *
     * @return Message
     */
    public Message createEndSpeakerMsg() {
        User user = this.getDefaultUser();
        try {
            return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_END_SPEAKING), new JSONObject().put("userId", user.attributes.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 名称：发送视频码率
     * 消息名称：class_notify_video_rate(学员发起)
     * <p>
     * 功能：通过信令消息通知匿名管理员
     * <p>
     * 发送类型：CP2P（Student to Anonymouse_Admin）
     *
     * @param videoRate 视频码率
     * @return Message
     */
    public Message createNotifyVideoRateMsg(int videoRate) {
        try {
            return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_NOTIFY_VIDEO_RATE), new JSONObject().put("videoRate", videoRate));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 名称：学员提交试卷
     * 消息名称：class_submit_testing(学员发起)
     * <p>
     * 功能：学员答题后通过调用接口提交试卷答题内容，同时通过信令消息通知教师试卷已提交
     * <p>
     * 发送类型：CP2M（Student to Teacher & Assistant & Class_Admin）
     *
     * @param testId      试卷id
     * @param classTestId 课堂测验编号
     * @return Message
     */
    public Message createSubmitTestingMsg(int testId, int classTestId) {
        try {
            return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.CLASS_SUBMIT_TESTING), new JSONObject().put("testId", testId).put("classTestId", classTestId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*end->class***********************************************************************************/
    /*start->textchat******************************************************************************/

    /**
     * 名称：发送文字消息
     * 消息名称：textchat_send_msg(任何人发起)
     * <p>
     * 功能：通过信令消息通知所有人
     * <p>
     * 发送类型：CP2A（Anyone to All）
     */
    public Message createChatMsg(String msg) {
        User user = this.getDefaultUser();
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.TEXTCHAT_SEND_MSG), new TextChatMsg(user.attributes.classUserRole, user.attributes.userName, msg));
    }
    /*end->textchat********************************************************************************/
    /*start->sys***********************************************************************************/

    /**
     * 名称：截屏图片地址
     * 消息名称：sys_capture_screen_url(学员发起)
     * <p>
     * 功能：通过信令消息通知所有人
     * <p>
     * 发送类型：CP2P（Student to 发送者）
     *
     * @param originalMsgId originalMsgId
     * @param imageUrl      imageUrl
     * @param targetUserIds 消息接收人
     * @return Message
     */
    public Message createCaptureScreenUrlMsg(String originalMsgId, String imageUrl, ArrayList<Integer> targetUserIds) {
        User user = this.getDefaultUser();
        Message message = new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.SYS_CAPTURE_SCREEN_URL), new Screenshot(originalMsgId, imageUrl, user.attributes.classUserRole, user.env.getDevice(), user.env.getOs()));
        message.header.targetUserIds = targetUserIds;
        return message;
    }

    /**
     * 名称：通知应用程序切换
     * 消息名称：sys_switch_app(学员发起)
     * <p>
     * 功能：当学员把小阔客户端或app切换到后台运行时或从后台切换到前台时，通过信令消息通知教师和管理员
     * <p>
     * 发送类型：CP2M（Student to Teacher & Assistant & Anonymouse_Admin）
     *
     * @param action           AppActive
     * @param activeDuration   activeDuration
     * @param inactiveDuration inactiveDuration
     * @return Message
     */
    public Message createSwitchAppMsg(@AppActive String action, int activeDuration, int inactiveDuration) {
        User user = this.getDefaultUser();
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.SYS_NOTIFY_APP_STATUS), new SwitchApp(action, activeDuration, inactiveDuration, user.attributes.classUserRole, user.env.getDevice(), user.env.getOs()));
    }
    /*end->sys***********************************************************************************/

}
