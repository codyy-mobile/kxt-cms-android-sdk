package com.codyy.cms.ext.whiteboard;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.events.whiteboard.WhiteBoardEvent;
import com.codyy.cms.utils.EbusUtils;
import com.codyy.cms.utils.GsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codyy.cms.core.definition.MessageName.WHITEBOARD_TRANSFORM_OBJECT;

public class WhiteboardMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessageName.WHITEBOARD_CREATE_BOARD,
            MessageName.WHITEBOARD_DELETE_BOARD,
            MessageName.WHITEBOARD_SELECT_BOARD,
            MessageName.WHITEBOARD_SCROLL_BOARD,
            MessageName.WHITEBOARD_SWITCH_PAGE,
            MessageName.WHITEBOARD_FREE_OPERATION,
            MessageName.WHITEBOARD_SELECT_BRUSH,
            MessageName.WHITEBOARD_POINTER_MOVE,
            MessageName.WHITEBOARD_FREE_DRAWING,
            MessageName.WHITEBOARD_DRAW_TEXT,
            MessageName.WHITEBOARD_DRAW_SHAPE,
            MessageName.WHITEBOARD_ERASE_OBJECT,
            MessageName.WHITEBOARD_UNDO_REDO,
            MessageName.WHITEBOARD_CLEAR_ALL,
            MessageName.WHITEBOARD_TRANSFORM_OBJECT
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
            EbusUtils.post(new WhiteBoardEvent(new JSONObject(GsonUtils.bean2JsonStr(message))));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
