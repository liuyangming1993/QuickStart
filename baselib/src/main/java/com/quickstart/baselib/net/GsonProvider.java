package com.quickstart.baselib.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {
    private GsonProvider() {
    }

    public static Gson getGson() {
        return GsonHolder.sGson;
    }

    private static class GsonHolder {
        private static final Gson sGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
    }
}
