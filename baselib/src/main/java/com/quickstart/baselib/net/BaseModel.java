package com.quickstart.baselib.net;

import retrofit2.Retrofit;

public class BaseModel implements IModel {
    private Retrofit mRetrofit;

    public BaseModel() {
        mRetrofit = RetrofitProvider.getRetrofit();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    @Override
    public void onDestroy() {

    }
}
