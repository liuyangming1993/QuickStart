package com.lym.testmodule;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("raw/master/data.json")
    Observable<String> getJson();
}
