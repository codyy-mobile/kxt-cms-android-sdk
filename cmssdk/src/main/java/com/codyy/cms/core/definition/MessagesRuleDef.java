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
    public static final MessagesRuleDef USER_ONLINE
            = new MessagesRuleDef(MessageName.USER_ONLINE, MessageType.USER, MsgSendType.CP2A, empty, empty);
    public static final MessagesRuleDef USER_OFFLIE
            = new MessagesRuleDef(MessageName.USER_OFFLIE, MessageType.USER, MsgSendType.CP2A, empty, empty);
    public static final MessagesRuleDef USER_INFO
            = new MessagesRuleDef(MessageName.USER_INFO, MessageType.USER, MsgSendType.CP2A, empty, empty);


    public static final MessagesRuleDef CLASS_START_WARMINGUP
            = new MessagesRuleDef(MessageName.CLASS_START_WARMINGUP, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_STOP_WARMINGUP
            = new MessagesRuleDef(MessageName.CLASS_STOP_WARMINGUP, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_START
            = new MessagesRuleDef(MessageName.CLASS_START, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_END
            = new MessagesRuleDef(MessageName.CLASS_END, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_START_SIGNIN
            = new MessagesRuleDef(MessageName.CLASS_START_SIGNIN, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_SIGNIN
            = new MessagesRuleDef(MessageName.CLASS_SIGNIN, MessageType.CLASS, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessagesRuleDef CLASS_HAND_UP
            = new MessagesRuleDef(MessageName.CLASS_HAND_UP, MessageType.CLASS, MsgSendType.CP2M, asList(ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT));
    public static final MessagesRuleDef CLASS_CANCEL_HAND_UP
            = new MessagesRuleDef(MessageName.CLASS_CANCEL_HAND_UP, MessageType.CLASS, MsgSendType.CP2M, asList(ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT));
    public static final MessagesRuleDef CLASS_CLEAR_ALL_HAND_UP
            = new MessagesRuleDef(MessageName.CLASS_CLEAR_ALL_HAND_UP, MessageType.CLASS, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessagesRuleDef CLASS_SELECT_SPEAKER
            = new MessagesRuleDef(MessageName.CLASS_SELECT_SPEAKER, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_END_SPEAKING
            = new MessagesRuleDef(MessageName.CLASS_END_SPEAKING, MessageType.CLASS, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.STUDENT), empty);
    public static final MessagesRuleDef CLASS_SWITCH_SPEAKER
            = new MessagesRuleDef(MessageName.CLASS_SWITCH_SPEAKER, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_BEGIN_TESTING
            = new MessagesRuleDef(MessageName.CLASS_BEGIN_TESTING, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_END_TESTING
            = new MessagesRuleDef(MessageName.CLASS_END_TESTING, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_EXPLAIN_TESTING
            = new MessagesRuleDef(MessageName.CLASS_EXPLAIN_TESTING, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_EXIT_EXPLAINING_TEST
            = new MessagesRuleDef(MessageName.CLASS_EXIT_EXPLAINING_TEST, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_BEGIN_TESTCARD
            = new MessagesRuleDef(MessageName.CLASS_BEGIN_TESTCARD, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_END_TESTCARD
            = new MessagesRuleDef(MessageName.CLASS_END_TESTCARD, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_TESTCARD_RESULT
            = new MessagesRuleDef(MessageName.CLASS_TESTCARD_RESULT, MessageType.CLASS, MsgSendType.CP2M, singletonList(ClassUserRole.ANONYMOUSE_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT));
    public static final MessagesRuleDef CLASS_START_SHARING_DESKTOP
            = new MessagesRuleDef(MessageName.CLASS_START_SHARING_DESKTOP, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_STOP_SHARING_DESKTOP
            = new MessagesRuleDef(MessageName.CLASS_STOP_SHARING_DESKTOP, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef CLASS_ADJUST_VIDEO
            = new MessagesRuleDef(MessageName.CLASS_ADJUST_VIDEO, MessageType.CLASS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);


    public static final MessagesRuleDef TEXTCHAT_SEND_MSG
            = new MessagesRuleDef(MessageName.TEXTCHAT_SEND_MSG, MessageType.TEXTCHAT, MsgSendType.CP2A, empty, empty);
    public static final MessagesRuleDef TEXTCHAT_DELETE_MSG
            = new MessagesRuleDef(MessageName.TEXTCHAT_DELETE_MSG, MessageType.TEXTCHAT, MsgSendType.CP2M, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), empty);

    public static final MessagesRuleDef TEXTCHAT_DISABLE_CHAT
            = new MessagesRuleDef(MessageName.TEXTCHAT_DISABLE_CHAT, MessageType.TEXTCHAT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef TEXTCHAT_ENABLE_CHAT
            = new MessagesRuleDef(MessageName.TEXTCHAT_ENABLE_CHAT, MessageType.TEXTCHAT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);

    public static final MessagesRuleDef TEXTCHAT_ASK_QUESTION
            = new MessagesRuleDef(MessageName.TEXTCHAT_ASK_QUESTION, MessageType.TEXTCHAT, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessagesRuleDef TEXTCHAT_SHOW_QUESTION
            = new MessagesRuleDef(MessageName.TEXTCHAT_SHOW_QUESTION, MessageType.TEXTCHAT, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessagesRuleDef TEXTCHAT_HIDE_QUESTION
            = new MessagesRuleDef(MessageName.TEXTCHAT_HIDE_QUESTION, MessageType.TEXTCHAT, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessagesRuleDef TEXTCHAT_ANSWER_QUESTION
            = new MessagesRuleDef(MessageName.TEXTCHAT_ANSWER_QUESTION, MessageType.TEXTCHAT, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);


    public static final MessagesRuleDef WHITEBOARD_CREATE_BOARD
            = new MessagesRuleDef(MessageName.WHITEBOARD_CREATE_BOARD, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_DELETE_BOARD
            = new MessagesRuleDef(MessageName.WHITEBOARD_DELETE_BOARD, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_SELECT_BOARD
            = new MessagesRuleDef(MessageName.WHITEBOARD_SELECT_BOARD, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_SCROLL_BOARD
            = new MessagesRuleDef(MessageName.WHITEBOARD_SCROLL_BOARD, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_SWITCH_PAGE
            = new MessagesRuleDef(MessageName.WHITEBOARD_SWITCH_PAGE, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_FREE_OPERATION
            = new MessagesRuleDef(MessageName.WHITEBOARD_FREE_OPERATION, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_SELECT_BRUSH
            = new MessagesRuleDef(MessageName.WHITEBOARD_SELECT_BRUSH, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_POINTER_MOVE
            = new MessagesRuleDef(MessageName.WHITEBOARD_POINTER_MOVE, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_FREE_DRAWING
            = new MessagesRuleDef(MessageName.WHITEBOARD_FREE_DRAWING, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_DRAW_TEXT
            = new MessagesRuleDef(MessageName.WHITEBOARD_DRAW_TEXT, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_DRAW_SHAPE
            = new MessagesRuleDef(MessageName.WHITEBOARD_DRAW_SHAPE, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_ERASE_OBJECT
            = new MessagesRuleDef(MessageName.WHITEBOARD_ERASE_OBJECT, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_UNDO_REDO
            = new MessagesRuleDef(MessageName.WHITEBOARD_UNDO_REDO, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessagesRuleDef WHITEBOARD_CLEAR_ALL
            = new MessagesRuleDef(MessageName.WHITEBOARD_CLEAR_ALL, MessageType.WHITEBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);

    // 这个消息的接收者为发送消息的人。
    public static final MessagesRuleDef SYS_CAPTURE_SCREEN
            = new MessagesRuleDef(MessageName.SYS_CAPTURE_SCREEN, MessageType.SYS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty, true);
    public static final MessagesRuleDef SYS_CAPTURE_SCREEN_URL
            = new MessagesRuleDef(MessageName.SYS_CAPTURE_SCREEN_URL, MessageType.SYS, MsgSendType.CP2P, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.ASSISTANT, ClassUserRole.TEACHER, ClassUserRole.CLASS_ADMIN));
    public static final MessagesRuleDef SYS_SWITCH_APP
            = new MessagesRuleDef(MessageName.SYS_SWITCH_APP, MessageType.SYS, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessagesRuleDef SYS_LOCK_KEYBOARD
            = new MessagesRuleDef(MessageName.SYS_LOCK_KEYBOARD, MessageType.SYS, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
}
