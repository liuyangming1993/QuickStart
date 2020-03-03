package com.quickstart.baselib.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {
    private RetrofitProvider() {
    }

    public static Retrofit getRetrofit() {
        return RetrofitHolder.sRetrofit;
    }

    private static class RetrofitHolder {
        private static final Retrofit sRetrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(GsonProvider.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
