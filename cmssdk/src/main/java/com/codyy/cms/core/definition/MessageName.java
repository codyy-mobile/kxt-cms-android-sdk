package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 消息名称定义。
 */
@Retention(RetentionPolicy.SOURCE)
public @interface MessageName {
    String USER_ONLINE = "user_notify_online";
    String USER_OFFLIE = "user_notify_offline";
    String USER_INFO = "user_notify_basic_info";

    String CLASS_START_WARMINGUP = "class_start_warmingup";
    String CLASS_STOP_WARMINGUP = "class_stop_warmingup";
    String CLASS_START = "class_start";
    String CLASS_END = "class_end";
    String CLASS_START_SIGNIN = "class_start_signin";
    String CLASS_END_SIGNIN = "class_end_signin";
    String CLASS_SIGNIN = "class_signin";
    String CLASS_HAND_UP = "class_hand_up";
    String CLASS_CANCEL_HAND_UP = "class_cancel_hand_up";
    String CLASS_CLEAR_ALL_HAND_UP = "class_clear_all_hand_up";
    String CLASS_SELECT_SPEAKER = "class_select_speaker";
    String CLASS_END_SPEAKING = "class_end_speaking";
    String CLASS_SWITCH_SPEAKER = "class_switch_speaker";
    String CLASS_BEGIN_TESTING = "class_begin_testing";
    String CLASS_END_TESTING = "class_end_testing";
    String CLASS_EXPLAIN_TESTING = "class_explain_testing";
    String CLASS_EXIT_EXPLAINING_TEST = "class_exit_explaining_test";
    String CLASS_BEGIN_TESTCARD = "class_begin_testcard";
    String CLASS_END_TESTCARD = "class_end_testcard";
    String CLASS_SUBMIT_TESTCARD = "class_submit_testcard";
    String CLASS_TESTCARD_RESULT = "class_testcard_result";
    String CLASS_START_SHARING_DESKTOP = "class_start_sharing_desktop";
    String CLASS_STOP_SHARING_DESKTOP = "class_stop_sharing_desktop";
    String CLASS_ADJUST_VIDEO = "class_adjust_video";

    String TEXTCHAT_SEND_MSG = "textchat_send_msg";
    String TEXTCHAT_DELETE_MSG = "textchat_delete_msg";
    String TEXTCHAT_DISABLE_CHAT = "textchat_disable_chat";
    String TEXTCHAT_ENABLE_CHAT = "textchat_enable_chat";
    String TEXTCHAT_ASK_QUESTION = "textchat_ask_question";
    String TEXTCHAT_SHOW_QUESTION = "textchat_shwo_question";
    String TEXTCHAT_HIDE_QUESTION = "textchat_hide_question";
    String TEXTCHAT_ANSWER_QUESTION = "textchat_answer_question";

    String WHITEBOARD_CREATE_BOARD = "whiteboard_create_board";
    String WHITEBOARD_DELETE_BOARD = "whiteboard_delete_board";
    String WHITEBOARD_SELECT_BOARD = "whiteboard_select_board";
    String WHITEBOARD_SCROLL_BOARD = "whiteboard_scrool_board";
    String WHITEBOARD_SWITCH_PAGE = "whiteboard_swtich_page";
    String WHITEBOARD_FREE_OPERATION = "whiteboard_free_operation";
    String WHITEBOARD_SELECT_BRUSH = "whiteboard_select_brush";
    String WHITEBOARD_POINTER_MOVE = "whiteboard_pointer_move";
    String WHITEBOARD_FREE_DRAWING = "whiteboard_free_drawing";
    String WHITEBOARD_DRAW_TEXT = "whiteboard_draw_text";
    String WHITEBOARD_DRAW_SHAPE = "whiteboard_draw_shape";
    String WHITEBOARD_ERASE_OBJECT = "whiteboard_erase_object";
    String WHITEBOARD_UNDO_REDO = "whiteboard_undo_redo";
    String WHITEBOARD_CLEAR_ALL = "whiteboard_clear_all";

    String SYS_CAPTURE_SCREEN = "sys_capture_screen";
    String SYS_CAPTURE_SCREEN_URL = "sys_capture_screen_url";
    String SYS_SWITCH_APP = "sys_switch_app";
    String SYS_LOCK_KEYBOARD = "sys_lock_keyboard";
}
