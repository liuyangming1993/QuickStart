package com.beauty.beautychecker.api;

import com.beauty.beautychecker.entity.BeautyResponse;
import com.beauty.beautychecker.entity.DataUpdateResponse;
import com.quickstart.baselib.net.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("raw/master/beauty/data.json")
    Observable<BaseResponse<List<BeautyResponse>>> getData();

    @GET("raw/master/beauty/dataUpdate.json")
    Observable<BaseResponse<DataUpdateResponse>> dataUpdate();
}
