package com.codyy.cms.core;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageHeader;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.ext.user.User;
import com.codyy.cms.ext.user.UserMsgModule;

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
    private User getDefaultUser()  {
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

    public Message createSendUserInfoMsg(User user) {
        return new Message<>(this.createDefaultMessageHeader(MessagesRuleDef.USER_INFO), user);
    }

}
