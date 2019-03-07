package com.codyy.cms.core.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 消息规则定义
 */
public class MessageRuleDef {
    /**
     * {@link MessageName}
     * 消息名称
     */
    private String name;
    /**
     * 消息发送方式
     */
    private String sendType;
    /**
     * 发送方可能的角色，为空表示任何人
     */
    private ArrayList<String> senderRoles;
    /**
     * 接收方可能的角色，为空表示所有人
     */
    private ArrayList<String> receiverRoles;

    public MessageRuleDef(String name, String sendType, ArrayList<String> senderRoles, ArrayList<String> receiverRoles) {
        this.name = name;
        this.sendType = sendType;
        this.senderRoles = senderRoles;
        this.receiverRoles = receiverRoles;
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
    public static final MessageRuleDef USER_ONLINE
            = new MessageRuleDef(MessageName.USER_ONLINE, MsgSendType.CP2A, empty, empty);
    public static final MessageRuleDef USER_OFFLIE
            = new MessageRuleDef(MessageName.USER_OFFLIE, MsgSendType.CP2A, empty, empty);
    public static final MessageRuleDef USER_INFO
            = new MessageRuleDef(MessageName.USER_INFO, MsgSendType.CP2A, empty, empty);


    public static final MessageRuleDef CLASS_START_WARMINGUP
            = new MessageRuleDef(MessageName.CLASS_START_WARMINGUP, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_STOP_WARMINGUP
            = new MessageRuleDef(MessageName.CLASS_STOP_WARMINGUP, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_START
            = new MessageRuleDef(MessageName.CLASS_START, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_END
            = new MessageRuleDef(MessageName.CLASS_END, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_START_SIGNIN
            = new MessageRuleDef(MessageName.CLASS_START_SIGNIN, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_SIGNIN
            = new MessageRuleDef(MessageName.CLASS_SIGNIN, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessageRuleDef CLASS_HAND_UP
            = new MessageRuleDef(MessageName.CLASS_HAND_UP, MsgSendType.CP2M, asList(ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT));
    public static final MessageRuleDef CLASS_CANCEL_HAND_UP
            = new MessageRuleDef(MessageName.CLASS_CANCEL_HAND_UP, MsgSendType.CP2M, asList(ClassUserRole.STUDENT, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ANONYMOUSE_ADMIN, ClassUserRole.ASSISTANT));
    public static final MessageRuleDef CLASS_CLEAR_ALL_HAND_UP
            = new MessageRuleDef(MessageName.CLASS_CLEAR_ALL_HAND_UP, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessageRuleDef CLASS_SELECT_SPEAKER
            = new MessageRuleDef(MessageName.CLASS_SELECT_SPEAKER, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_END_SPEAKING
            = new MessageRuleDef(MessageName.CLASS_END_SPEAKING, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.STUDENT), empty);
    public static final MessageRuleDef CLASS_SWITCH_SPEAKER
            = new MessageRuleDef(MessageName.CLASS_SWITCH_SPEAKER, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_BEGIN_TESTING
            = new MessageRuleDef(MessageName.CLASS_BEGIN_TESTING, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_END_TESTING
            = new MessageRuleDef(MessageName.CLASS_END_TESTING, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_EXPLAIN_TESTING
            = new MessageRuleDef(MessageName.CLASS_EXPLAIN_TESTING, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_EXIT_EXPLAINING_TEST
            = new MessageRuleDef(MessageName.CLASS_EXIT_EXPLAINING_TEST, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_BEGIN_TESTCARD
            = new MessageRuleDef(MessageName.CLASS_BEGIN_TESTCARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_END_TESTCARD
            = new MessageRuleDef(MessageName.CLASS_END_TESTCARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_TESTCARD_RESULT
            = new MessageRuleDef(MessageName.CLASS_TESTCARD_RESULT, MsgSendType.CP2M, singletonList(ClassUserRole.ANONYMOUSE_ADMIN), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT));
    public static final MessageRuleDef CLASS_START_SHARING_DESKTOP
            = new MessageRuleDef(MessageName.CLASS_START_SHARING_DESKTOP, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_STOP_SHARING_DESKTOP
            = new MessageRuleDef(MessageName.CLASS_STOP_SHARING_DESKTOP, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef CLASS_ADJUST_VIDEO
            = new MessageRuleDef(MessageName.CLASS_ADJUST_VIDEO, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);


    public static final MessageRuleDef TEXTCHAT_SEND_MSG
            = new MessageRuleDef(MessageName.TEXTCHAT_SEND_MSG, MsgSendType.CP2A, empty, empty);
    public static final MessageRuleDef TEXTCHAT_DELETE_MSG
            = new MessageRuleDef(MessageName.TEXTCHAT_DELETE_MSG, MsgSendType.CP2M, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.CLASS_ADMIN), empty);
    public static final MessageRuleDef TEXTCHAT_DISABLE_ALL_CHAT
            = new MessageRuleDef(MessageName.TEXTCHAT_DISABLE_ALL_CHAT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef TEXTCHAT_ENABLE_ALL_CHAT
            = new MessageRuleDef(MessageName.TEXTCHAT_ENABLE_ALL_CHAT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef TEXTCHAT_ASK_QUESTION
            = new MessageRuleDef(MessageName.TEXTCHAT_ASK_QUESTION, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessageRuleDef TEXTCHAT_SHOW_QUESTION
            = new MessageRuleDef(MessageName.TEXTCHAT_SHOW_QUESTION, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessageRuleDef TEXTCHAT_HIDE_QUESTION
            = new MessageRuleDef(MessageName.TEXTCHAT_HIDE_QUESTION, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);
    public static final MessageRuleDef TEXTCHAT_ANSWER_QUESTION
            = new MessageRuleDef(MessageName.TEXTCHAT_ANSWER_QUESTION, MsgSendType.CP2A, asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT), empty);


    public static final MessageRuleDef WHITEBOARD_CREATE_BOARD
            = new MessageRuleDef(MessageName.WHITEBOARD_CREATE_BOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_DELETE_BOARD
            = new MessageRuleDef(MessageName.WHITEBOARD_DELETE_BOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_SELECT_BOARD
            = new MessageRuleDef(MessageName.WHITEBOARD_SELECT_BOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_SCROLL_BOARD
            = new MessageRuleDef(MessageName.WHITEBOARD_SCROLL_BOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_SWITCH_PAGE
            = new MessageRuleDef(MessageName.WHITEBOARD_SWITCH_PAGE, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_FREE_OPERATION
            = new MessageRuleDef(MessageName.WHITEBOARD_FREE_OPERATION, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_SELECT_BRUSH
            = new MessageRuleDef(MessageName.WHITEBOARD_SELECT_BRUSH, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_POINTER_MOVE
            = new MessageRuleDef(MessageName.WHITEBOARD_POINTER_MOVE, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_FREE_DRAWING
            = new MessageRuleDef(MessageName.WHITEBOARD_FREE_DRAWING, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_DRAW_TEXT
            = new MessageRuleDef(MessageName.WHITEBOARD_DRAW_TEXT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_DRAW_SHAPE
            = new MessageRuleDef(MessageName.WHITEBOARD_DRAW_SHAPE, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_ERASE_OBJECT
            = new MessageRuleDef(MessageName.WHITEBOARD_ERASE_OBJECT, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_UNDO_REDO
            = new MessageRuleDef(MessageName.WHITEBOARD_UNDO_REDO, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef WHITEBOARD_CLEAR_ALL
            = new MessageRuleDef(MessageName.WHITEBOARD_CLEAR_ALL, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);


    public static final MessageRuleDef SYS_CAPTURE_SCREEN
            = new MessageRuleDef(MessageName.SYS_CAPTURE_SCREEN, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
    public static final MessageRuleDef SYS_CAPTURE_SCREEN_URL
            = new MessageRuleDef(MessageName.SYS_CAPTURE_SCREEN_URL, MsgSendType.CP2P, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.ASSISTANT, ClassUserRole.TEACHER, ClassUserRole.CLASS_ADMIN));
    public static final MessageRuleDef SYS_SWITCH_APP
            = new MessageRuleDef(MessageName.SYS_SWITCH_APP, MsgSendType.CP2M, singletonList(ClassUserRole.STUDENT), asList(ClassUserRole.TEACHER, ClassUserRole.ASSISTANT, ClassUserRole.ANONYMOUSE_ADMIN));
    public static final MessageRuleDef SYS_LOCK_KEYBOARD
            = new MessageRuleDef(MessageName.SYS_LOCK_KEYBOARD, MsgSendType.CP2A, singletonList(ClassUserRole.TEACHER), empty);
}
