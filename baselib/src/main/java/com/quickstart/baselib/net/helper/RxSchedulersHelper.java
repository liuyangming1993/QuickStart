package com.quickstart.baselib.net.helper;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulersHelper {
    /**
     * Observable 切换到主线程
     */
    public static <T> ObservableTransformer<T, T> ioToMain() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
