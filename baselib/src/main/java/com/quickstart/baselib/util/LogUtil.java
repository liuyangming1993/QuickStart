package com.quickstart.baselib.util;

import android.util.Log;

public class LogUtil {
    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable e) {
        Log.e(tag, msg, e);
    }
}
