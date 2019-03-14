package com.codyy.cms.ext.user;

import android.util.SparseArray;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.core.definition.NoChatScope;
import com.codyy.cms.core.definition.SpeakingState;
import com.codyy.cms.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserMsgModule extends AbstractMsgModule {
    private SparseArray<User> userInfoMap;
    private Map<String, LinkedList<Integer>> classUserRolesMap;
    private int myUserId;
    private String[] watchMsgNames = {
            MessagesRuleDef.USER_ONLINE.name,
            MessagesRuleDef.USER_OFFLIE.name,
            MessagesRuleDef.USER_INFO.name,
            MessagesRuleDef.CLASS_SIGNIN.name,
            MessagesRuleDef.CLASS_HAND_UP.name,
            MessagesRuleDef.CLASS_CANCEL_HAND_UP.name,
            MessagesRuleDef.CLASS_SELECT_SPEAKER.name,
            MessagesRuleDef.CLASS_SWITCH_SPEAKER.name,
            MessagesRuleDef.CLASS_CLEAR_ALL_HAND_UP.name,
            MessagesRuleDef.TEXTCHAT_DISABLE_CHAT.name,
            MessagesRuleDef.TEXTCHAT_ENABLE_CHAT.name,
    };

    public UserMsgModule(User user, MessageEngine messageEngine, MessageFactory messageFactory) {
        super(messageEngine, messageFactory);
        this.userInfoMap = new SparseArray<>();
        this.classUserRolesMap = new HashMap<>();
        this.setCurrentUser(user);
        this.setClassUserRole(user);
    }

    /**
     * 设置当前用户
     */
    public void setCurrentUser(User my) {
        this.myUserId = my.getAttributes().getUserId();
        this.userInfoMap.put(my.getAttributes().getUserId(), my);
    }

    public void setClassUserRole(User my) {
        LinkedList<Integer> rolesList = this.classUserRolesMap.get(my.getAttributes().getClassUserRole());

        if (rolesList == null) {
            rolesList = new LinkedList<>();
            this.classUserRolesMap.put(my.getAttributes().getClassUserRole(), rolesList);
        }
        rolesList.add(my.getAttributes().getUserId());
    }

    /**
     * Return current user.
     */
    public User getMe() {
        return this.userInfoMap.get(this.myUserId);
    }

    /**
     * Return user info map.
     */
    public SparseArray<User> getUserInfoMap() {
        return this.userInfoMap;
    }

    /**
     * Return current user info.
     *
     * @param userId
     * @return
     */
    public User getUserInfo(int userId) {
        return this.userInfoMap.get(userId);
    }

    /**
     * Return info of all users maintained by current client.
     *
     * @return
     */
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < this.userInfoMap.size(); i++) {
            list.add(userInfoMap.get(userInfoMap.keyAt(i)));
        }
        return list;
    }

    /**
     * Return user count of current channel.
     *
     * @return
     */
    public int getUserCount() {
        return this.userInfoMap.size();
    }

    /**
     * 更新所有用户信息，一般在初始化的时候调用
     */
    public void updateUsers(SparseArray<User> userInfoMap) {
        this.userInfoMap = userInfoMap;
    }

    /**
     * 返回某类课堂角色用户的id列表
     *
     * @param {ClassUserRole} classUserRole
     * @returns {Set<number>}
     * @memberof UserMsgModule
     */
    public LinkedList<Integer> getClassUserRoleIds(String classUserRole) {
        return this.classUserRolesMap.get(classUserRole);
    }

    public boolean isOnline(Integer userId) {
        if (userId == null) {
            return this.getMe().states.isOnline;
        } else {
            User user = this.userInfoMap.get(userId);
            return user != null && user.states.isOnline;
        }
    }

    public boolean allowChat(Integer userId) {
        if (userId == null) {
            return this.getMe().states.allowChat;
        } else {
            User user = this.userInfoMap.get(userId);
            return user != null && user.states.allowChat;
        }
    }

    public boolean isHandingUp(Integer userId) {
        if (userId == null) {
            return this.getMe().states.isHandingUp;
        } else {
            User user = this.userInfoMap.get(userId);
            return user != null && user.states.isHandingUp;
        }
    }

    public boolean isSignedIn(Integer userId) {
        if (userId == null) {
            return this.getMe().states.isSignedIn;
        } else {
            User user = this.userInfoMap.get(userId);
            return user != null && user.states.isSignedIn;
        }
    }

    public String getSpeakingState(Integer userId) {
        if (userId == null) {
            return this.getMe().states.speakingState;
        } else {
            User user = this.userInfoMap.get(userId);
            return user == null ? SpeakingState.NO : user.states.speakingState;
        }
    }

    /**
     * 广播发送用户信息
     * Call by anyone.
     *
     * @memberof UserMsgModule
     */
    public void sendUserInfoMsg() {
        this.sendMessage(this.getMessageFactory().createSendUserInfoMsg(this.getMe()));
    }

    @Override
    public String getType() {
        return MessageType.USER;
    }

    @Override
    public ArrayList<String> getWatchMsgNames() {

        return new ArrayList<>(Arrays.asList(watchMsgNames));
    }

    @Override
    public void handle(String msgName, Message msg) {
        User user = this.userInfoMap.get(msg.header.userId);
        if (user == null) {
            user = new User(new LoginOptions(msg.header.userId));
            this.userInfoMap.put(msg.header.userId, user);
        }
        switch (msgName) {
            case MessageName.USER_ONLINE:
//                boolean oldValue = user.states.isOnline;
                user.states.isOnline = true;
//                this.notifyStateUpdated(UserStateType.IS_ONLINE, oldValue, true, user);
                break;
            case MessageName.USER_OFFLIE:
//                oldValue = user.states.isOnline;
                user.states.isOnline = false;
//                this.notifyStateUpdated(UserStateType.IS_ONLINE, oldValue, false, user);
                break;
            case MessageName.USER_INFO:
                Message<User> message = GsonUtils.bean2Bean(msg, new TypeToken<Message<User>>() {
                }.getType());
                user.attributes.classUserRole = message.body.attributes.classUserRole;
                user.attributes.userName = message.body.attributes.userName;
                this.userInfoMap.put(msg.header.userId, user);
                this.setClassUserRole(user);
//                User newValue = (User) CombineUtils.combineSydwCore(msg.body,user);
//                this.notifyStateUpdated(UserStateType.USER, user, newValue);
                break;

            case MessageName.TEXTCHAT_DISABLE_CHAT:
                try {
                    JSONObject object = new JSONObject((String) msg.body);
                    if (NoChatScope.SINGLE.equals(object.optString("scope"))) {
                        user = this.userInfoMap.get(object.optInt("userId"));
//                    boolean oldValue = user.states.allowChat;
                        user.states.allowChat = false;
//                    this.notifyStateUpdated(UserStateType.ALLOW_CHAT, oldValue, false, user);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                if (msg.body.scope === NoChatScope.SINGLE) {
//                    user = this.userInfoMap.get(msg.body.userId);
//                    let oldValue = user.states.allowChat
//                    user.states.allowChat = false;
//                    this.notifyStateUpdated(UserStateType.ALLOW_CHAT, oldValue, false, user);
//                }
                break;
            case MessageName.TEXTCHAT_ENABLE_CHAT:
//                if (msg.body.scope === NoChatScope.SINGLE) {
//                    user = this.userInfoMap.get(msg.body.userId);
//                    let oldValue = user.states.allowChat
//                    user.states.allowChat = true;
//                    this.notifyStateUpdated(UserStateType.ALLOW_CHAT, oldValue, true, user);
//                }
                break;

            case MessageName.CLASS_SIGNIN:
//                oldValue = user.states.isSignedIn;
                user.states.isSignedIn = true;
                user.attributes.signinTimes++;
//                this.notifyStateUpdated(UserStateType.IS_SIGNED_IN, oldValue, true, user);
                break;
            case MessageName.CLASS_HAND_UP:
//                oldValue = user.states.isHandingUp;
                user.states.isHandingUp = true;
//                this.notifyStateUpdated(UserStateType.IS_HANDING_UP, oldValue, true, user);
                break;
            case MessageName.CLASS_CANCEL_HAND_UP:
//                oldValue = user.states.isHandingUp;
                user.states.isHandingUp = false;
//                this.notifyStateUpdated(UserStateType.IS_HANDING_UP, oldValue, false, user);
                break;
            case MessageName.CLASS_SELECT_SPEAKER:
//                let selectedUser = this.userInfoMap.get(msg.body.userId);
//                let oldSpeaking = selectedUser.states.speakingState;
//                selectedUser.states.speakingState = msg.body.method;
//                this.notifyStateUpdated(UserStateType.SPEAKING_STATE, oldSpeaking, selectedUser.states.speakingState, selectedUser);
                break;
            case MessageName.CLASS_SWITCH_SPEAKER:
//                let oldUser = this.userInfoMap.get(msg.body.oldUserId);
//                oldSpeaking = oldUser.states.speakingState;
//                oldUser.states.speakingState = SpeakingState.NO;
//                // Firstly notify old user the speaking was cancelled.
//                this.notifyStateUpdated(UserStateType.SPEAKING_STATE, oldSpeaking, SpeakingState.NO, oldUser);
//
//                // Secondary notify user user the speaking is updated.
//                selectedUser = this.userInfoMap.get(msg.body.userId);
//                selectedUser.states.speakingState = msg.body.method;
//                this.notifyStateUpdated(UserStateType.SPEAKING_STATE, oldSpeaking, selectedUser.states.speakingState, selectedUser);
                break;
            case MessageName.CLASS_CLEAR_ALL_HAND_UP:
//                if (this.getMe().states.isHandingUp) {
//                    let oldValue = this.getMe().states.isHandingUp;
//                    this.notifyStateUpdated(UserStateType.IS_HANDING_UP, oldValue, false, this.getMe());
//                }
        }
    }

}
