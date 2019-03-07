package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BrushType {
    String SELECTOR = "seletor";
    String PEN = "pen";
    String TEXT = "text";
    String SHAPE = "shape";
    String ERASER = "eraser";
    String POINTER = "pointer";
}
