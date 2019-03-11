package com.codyy.cms.ext.cls;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ClassStateType {
    String IS_WARMING_UP = "is_warming_up";
    String IS_IN_CLASS = "is_in_class";
    String IS_IN_RECORDING = "is_in_recording";
    String IS_IN_SIGNING_IN = "is_in_signing_in";
    String IS_IN_HANDING_UP = "is_in_handing_up";
    String IS_IN_SPEAKING = "is_in_speaking";
    String IS_TESTING = "is_testing";
    String IS_EXPLAINING_TEST = "is_explaining_test";
    String IS_CARD_TESTING = "is_card_testing";
    String IS_SHARING_DESKTOP = "is_sharing_desktop";
    String VIDEO_ZOOM_STATE = "video_zoom_state";
    String TESTCARD_RESULT_STATE = "testcard_result_state";
}
