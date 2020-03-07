package com.quickstart.baselib.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.quickstart.baselib.net.Config.BASE_URL;

public class RetrofitProvider {

    private RetrofitProvider() {
    }

    public static Retrofit getRetrofit() {
        return RetrofitHolder.sRretrofit;
    }

    private static class RetrofitHolder {
        private static final Retrofit sRretrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpProvider.getOkHttp())
                .addConverterFactory(GsonConverterFactory.create(GsonProvider.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
