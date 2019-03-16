package com.codyy.cms.core.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 消息规则定义
 */
public class MessagesRuleDef {
    /**
     * {@link MessageName}
     * 消息名称
     */
    public String name;
    /**
     * 消息发送方式{@link MsgSendType}
     */
    public String sendType;
    /**
     * {@link MessageType}
     */
    public String type;
    /**
     * 发送方可能的角色，为空表示任何人
     */
    public ArrayList<String> senderRoles;
    /**
     * 接收方可能的角色，为空表示所有人
     */
    public ArrayList<String> receiverRoles;
    /**
     * Indicate if the message only sending to requester, default is false.
     */
    public boolean onlyReplySender = false;

    public MessagesRuleDef(String name, String sendType, String type, ArrayList<String> senderRoles, ArrayList<String> receiverRoles) {
        this.name = name;
        this.sendType = sendType;
        this.type = type;
        this.senderRoles = senderRoles;
        this.receiverRoles = receiverRoles;
    }

    public MessagesRuleDef(String name, String sendType, String type, ArrayList<String> senderRoles, ArrayList<String> receiverRoles, boolean onlyReplySender) {
        this.name = name;
        this.sendType = sendType;
        this.type = type;
        this.senderRoles = senderRoles;
        this.receiverRoles = receiverRoles;
        this.onlyReplySender = onlyReplySender;
    }

    private static ArrayList<String> asList(String... a) {
        return new ArrayList<>(Arrays.asList(a));
    }

    private static ArrayList<String> singletonList(String a) {
        return new ArrayList<>(Collections.singletonList(a));
    }

    private static final ArrayList<String> empty = new ArrayList<>();
    /**
     * 消息定义和规则定义
     */
    public static final MessagesRuleDef USER_INFO
            = new MessagesRuleDef(MessageName.USER_INFO, MessageType.USER, MsgSendType.CP2A, empty, empty);


    public static final MessagesRuleDef CLASS_SIGNIN
            = new MessagesRuleDef(MessageName.CLASS_SIGNIN, MessageType.CLASS, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessagesRuleDef CLASS_SUBMIT_TESTING
            = new MessagesRuleDef(MessageName.CLASS_SUBMIT_TESTING, MessageType.CLASS, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN));
    public static final MessagesRuleDef CLASS_HAND_UP
            = new MessagesRuleDef(MessageName.CLASS_HAND_UP, MessageType.CLASS, MsgSendType.CP2M, asList(ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN));
    public static final MessagesRuleDef CLASS_CANCEL_HAND_UP
            = new MessagesRuleDef(MessageName.CLASS_CANCEL_HAND_UP, MessageType.CLASS, MsgSendType.CP2M, asList(ClassUserRole.TEACHER, ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN));
    public static final MessagesRuleDef CLASS_END_SPEAKING
            = new MessagesRuleDef(MessageName.CLASS_END_SPEAKING, MessageType.CLASS, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.STUDENT), empty);
    public static final MessagesRuleDef CLASS_NOTIFY_VIDEO_RATE
            = new MessagesRuleDef(MessageName.CLASS_NOTIFY_VIDEO_RATE, MessageType.CLASS, MsgSendType.CP2P, singletonList(ClassUserRole.STUDENT), singletonList(ClassUserRole.ANONYMOUSE_ADMIN));


    public static final MessagesRuleDef TEXTCHAT_SEND_MSG
            = new MessagesRuleDef(MessageName.TEXTCHAT_SEND_MSG, MessageType.TEXTCHAT, MsgSendType.CP2A, empty, empty);


    public static final MessagesRuleDef SYS_CAPTURE_SCREEN_URL
            = new MessagesRuleDef(MessageName.SYS_CAPTURE_SCREEN_URL, MessageType.SYS, MsgSendType.CP2P, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.ASSISTANT, ClassUserRole.TEACHER, ClassUserRole.CLASS_ADMIN));
    public static final MessagesRuleDef SYS_NOTIFY_APP_STATUS
            = new MessagesRuleDef(MessageName.SYS_NOTIFY_APP_STATUS, MessageType.SYS, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN, ClassUserRole.ANONYMOUSE_ADMIN));
}
