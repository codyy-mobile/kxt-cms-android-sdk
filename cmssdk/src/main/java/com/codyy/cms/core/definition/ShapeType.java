package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ShapeType {
    String LINE = "line";
    String CIRCLE = "circle";
    String RECTANGLE = "rectangle";
    String ELLIPSE = "ellipse";
    String TRIANGLE = "triangle";
    String POLYGON = "polgon";
}
