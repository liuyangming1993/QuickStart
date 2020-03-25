package com.quickstart.baselib.update;

import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.update.entity.UpdateResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UpdateApi {
    @GET("raw/master/beauty/checkVerson.json")
    Observable<BaseResponse<UpdateResponse>> checkVersion();
}
