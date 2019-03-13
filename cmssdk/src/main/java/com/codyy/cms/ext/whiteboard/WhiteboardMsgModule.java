package com.codyy.cms.ext.whiteboard;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.events.whiteboard.WhiteBoardEvent;
import com.codyy.cms.utils.EbusUtils;
import com.codyy.cms.utils.GsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class WhiteboardMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessagesRuleDef.WHITEBOARD_CREATE_BOARD.name,
            MessagesRuleDef.WHITEBOARD_DELETE_BOARD.name,
            MessagesRuleDef.WHITEBOARD_SELECT_BOARD.name,
            MessagesRuleDef.WHITEBOARD_SCROLL_BOARD.name,
            MessagesRuleDef.WHITEBOARD_SWITCH_PAGE.name,
            MessagesRuleDef.WHITEBOARD_FREE_OPERATION.name,
            MessagesRuleDef.WHITEBOARD_SELECT_BRUSH.name,
            MessagesRuleDef.WHITEBOARD_POINTER_MOVE.name,
            MessagesRuleDef.WHITEBOARD_FREE_DRAWING.name,
            MessagesRuleDef.WHITEBOARD_DRAW_TEXT.name,
            MessagesRuleDef.WHITEBOARD_DRAW_SHAPE.name,
            MessagesRuleDef.WHITEBOARD_ERASE_OBJECT.name,
            MessagesRuleDef.WHITEBOARD_UNDO_REDO.name,
            MessagesRuleDef.WHITEBOARD_CLEAR_ALL.name
    };

    public WhiteboardMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        super(messageEngine, messageFactory);
    }

    @Override
    public String getType() {
        return MessageType.WHITEBOARD;
    }

    @Override
    public ArrayList<String> getWatchMsgNames() {
        return new ArrayList<>(Arrays.asList(watchMsgNames));
    }

    @Override
    public void handle(String msgName, Message message) {
        try {
            EbusUtils.post(new WhiteBoardEvent(new JSONObject(GsonUtils.bean2JsonStr(message.body))));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        switch (msgName) {
//            case MessageName.WHITEBOARD_FREE_OPERATION:
//                break;
//            case MessageName.WHITEBOARD_CREATE_BOARD:
//                break;
//            case MessageName.WHITEBOARD_DELETE_BOARD:
//                break;
//            case MessageName.WHITEBOARD_SELECT_BOARD:
//                break;
//            case MessageName.WHITEBOARD_SCROLL_BOARD:
//                break;
//            case MessageName.WHITEBOARD_SWITCH_PAGE:
//                break;
//            case MessageName.WHITEBOARD_SELECT_BRUSH:
//                break;
//            case MessageName.WHITEBOARD_POINTER_MOVE:
//                break;
//            case MessageName.WHITEBOARD_FREE_DRAWING:
//                break;
//            case MessageName.WHITEBOARD_DRAW_TEXT:
//                break;
//            case MessageName.WHITEBOARD_DRAW_SHAPE:
//                break;
//            case MessageName.WHITEBOARD_ERASE_OBJECT:
//                break;
//            case MessageName.WHITEBOARD_UNDO_REDO:
//                break;
//            case MessageName.WHITEBOARD_CLEAR_ALL:
//                break;
//        }
    }
}
