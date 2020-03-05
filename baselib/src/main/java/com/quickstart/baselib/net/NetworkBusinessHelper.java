package com.quickstart.baselib.net;

import okhttp3.Request;

public class NetworkBusinessHelper {
    private static final String OS_ANDROID = "Android";

    public static Request updateRequest(Request oldRequest) {
        Request newRequest = oldRequest.newBuilder()
                .addHeader("os", OS_ANDROID)
                .build();
        return newRequest;
    }
}
