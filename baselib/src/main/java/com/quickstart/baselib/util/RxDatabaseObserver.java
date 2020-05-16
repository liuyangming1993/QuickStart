package com.quickstart.baselib.util;

import com.quickstart.baselib.net.BaseResponse;

import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RxDatabaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);
}
