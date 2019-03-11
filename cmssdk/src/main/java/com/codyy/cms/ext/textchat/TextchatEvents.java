package com.codyy.cms.ext.textchat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TextchatEvents {
    String ON_MSG_RECEIVED = "on_msg_received";
    String ON_MSG_DELETED = "on_msg_deleted";
    String ON_QUESTION_RECEIVED = "on_question_received";
    String ON_QUESTION_ANSWER_RECEIVED = "on_question_answer_received";
    String ON_DISABLE_CHAT_RECEIVED = "on_disable_chat_received";
    String ON_ENABLE_CHAT_RECEVIED = "on_enable_chat_received";
}
