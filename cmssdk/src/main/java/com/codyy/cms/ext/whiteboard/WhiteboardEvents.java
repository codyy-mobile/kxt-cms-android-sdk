package com.codyy.cms.ext.whiteboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface WhiteboardEvents {
    String ON_CREATE_BOARD = "on_create_board";
    String ON_DELETE_BOARD = "on_delete_board";
    String ON_SELECT_BOARD = "on_select_board";
    String ON_SCROLL_BOARD = "on_scroll_board";
    String ON_SWITCH_PAGE = "on_switch_page";
    String ON_SELECT_BRUSH = "on_select_brush";
    String ON_POINTER_MOVE = "on_pointer_move";
    String ON_FREE_DRAWING = "on_free_drawing";
    String ON_DRAW_TEXT = "on_draw_text";
    String ON_DRAW_SHAPE = "on_draw_shape";
    String ON_ERASE_OBJECT = "on_erase_object";
    String ON_UNDO_REDO = "on_undo_redo";
    String ON_CLEAR_ALL = "on_clear_all";
}
