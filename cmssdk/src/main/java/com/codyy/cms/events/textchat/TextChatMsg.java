package com.codyy.cms.events.textchat;

import com.codyy.cms.core.definition.ClassUserRole;

public class TextChatMsg {
    private String classUserRole;
    private String userName;
    private String msg;

    public TextChatMsg(@ClassUserRole String classUserRole, String userName, String msg) {
        this.classUserRole = classUserRole;
        this.userName = userName;
        this.msg = msg;
    }
}
