package com.quickstart.baselib.net;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class NetworkInterceptor implements Interceptor {
    private static final String TAG = "NetworkInterceptor";
    private Charset UTF8 = Charset.forName("UTF-8");
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = NetworkBusinessHelper.updateRequest(request);
        RequestBody requestBody = newRequest.body();
        String requestBodyStr = null;
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = UTF8;
            MediaType mediaType = requestBody.contentType();
            if (mediaType != null) {
                charset = mediaType.charset(UTF8);
            }
            requestBodyStr = buffer.readString(charset);
        }
        String requestMsg = "发送请求: "
                + "\nmethod：" + newRequest.method()
                + "\nurl：" + newRequest.url()
                + "\n请求头：\n" + newRequest.headers()
                + "Request：" + requestBodyStr;
        printLog(requestMsg);
        Response response = chain.proceed(newRequest);
        ResponseBody responseBody = response.body();
        String responseBodyStr;
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.getBuffer();
        Charset charset = UTF8;
        MediaType mediaType = responseBody.contentType();
        if (mediaType != null) {
            mediaType.charset(UTF8);
        }
        responseBodyStr = buffer.clone().readString(charset);
        String responseMsg = "收到响应: "
                + "\ncode:" + response.code()
                + "\n请求url：" + response.request().url()
                + "\n请求参数：" + requestBodyStr
                + "\nResponse：" + responseBodyStr;
        printLog(responseMsg);
        return response;
    }

    private void printLog(String content) {
        Log.d(TAG, content);
//        LogFileHelper.writeTxtToFile(content);
    }
}
