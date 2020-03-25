package com.beauty.beautychecker.mvp.m;

import android.content.Context;
import android.util.Log;

import com.beauty.beautychecker.api.RetrofitApi;
import com.beauty.beautychecker.entity.BeautyResponse;
import com.beauty.beautychecker.entity.DataUpdateResponse;
import com.beauty.beautychecker.mvp.contract.MainContract;
import com.google.gson.reflect.TypeToken;
import com.quickstart.baselib.mvp.BaseModel;
import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.net.helper.RxSchedulersHelper;
import com.quickstart.baselib.net.provider.GsonProvider;
import com.quickstart.baselib.util.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MainModel extends BaseModel implements MainContract.MainModel {
    private static final String DATA = "data";

    @Override
    public Observable<BaseResponse<List<BeautyResponse>>> getData() {
        return getRetrofit().create(RetrofitApi.class)
                .getData()
                .compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public Observable<BaseResponse<DataUpdateResponse>> dataUpdate() {
        return getRetrofit().create(RetrofitApi.class)
                .dataUpdate()
                .compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public void writeData(Context context, List<BeautyResponse> data) {
        SharedPreferencesHelper.putAndApply(context, DATA, GsonProvider.getGson().toJson(data));
    }

    @Override
    public List<BeautyResponse> readData(Context context) {
        List<BeautyResponse> beautyResponses = new ArrayList<>();
        String listData = SharedPreferencesHelper.getSp(context).getString(DATA, "");
        if (!listData.isEmpty()) {
            beautyResponses.addAll(GsonProvider.getGson().fromJson(listData, new TypeToken<List<BeautyResponse>>() {
            }.getType()));
        }
        return beautyResponses;
    }
}
