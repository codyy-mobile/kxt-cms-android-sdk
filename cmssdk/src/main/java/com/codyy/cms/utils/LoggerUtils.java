package com.codyy.cms.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class LoggerUtils {
    /**
     * true:打印日志;false:关闭日志
     */
    private static boolean isLoggable = true;
    /**
     * 日志打印级别
     */
    private static int logLevel = Logger.DEBUG;

    /**
     * @param tag global tag for every log.
     */
    public static void initLogger(String tag) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(tag)   // (Optional) Global TAG for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return isIsLoggable();
            }

            @Override
            public void log(int priority, @Nullable String tag, @NonNull String message) {
                super.log(getLogLevel(), tag, message);
            }
        });
    }

    private static boolean isIsLoggable() {
        return isLoggable;
    }

    public static void setIsLoggable(boolean isLoggable) {
        LoggerUtils.isLoggable = isLoggable;
    }

    private static int getLogLevel() {
        return logLevel;
    }

    public static void setLogLevel(int logLevel) {
        LoggerUtils.logLevel = logLevel;
    }
}
