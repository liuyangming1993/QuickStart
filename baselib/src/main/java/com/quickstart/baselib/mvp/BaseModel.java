package com.quickstart.baselib.mvp;

import com.quickstart.baselib.net.provider.RetrofitProvider;

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
