package com.quickstart.baselib.net.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 提供Gson实例
 */
public class GsonProvider {
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

    private GsonProvider() {
    }

    public static Gson getGson() {
        return GsonHolder.sGson;
    }

    private static class GsonHolder {
        private static final Gson sGson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();
    }
}
