package com.lym.testmodule;

import android.util.Log;

import com.quickstart.baselib.mvp.BaseModel;
import com.quickstart.baselib.net.helper.RxSchedulersHelper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestModel extends BaseModel {
    public void getJson() {
        getRetrofit().create(Api.class).getJson().compose(RxSchedulersHelper.ioToMain()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i("liuym", "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
