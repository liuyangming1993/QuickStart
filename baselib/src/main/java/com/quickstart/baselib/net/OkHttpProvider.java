package com.quickstart.baselib.net;

import okhttp3.OkHttpClient;

public class OkHttpProvider {
    private OkHttpProvider() {
    }

    public static OkHttpClient getOkHttp() {
        return OkHttpHolder.sOkHttpClient;
    }

    private static class OkHttpHolder {
        private static final OkHttpClient sOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor())
                .build();
    }
}
