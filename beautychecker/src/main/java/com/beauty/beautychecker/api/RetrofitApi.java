package com.beauty.beautychecker.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("raw/master/data.json")
    Observable<String> getJson();
}
