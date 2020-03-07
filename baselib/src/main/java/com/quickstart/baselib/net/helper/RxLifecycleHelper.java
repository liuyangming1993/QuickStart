package com.quickstart.baselib.net.helper;

import android.content.Context;

import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

public class RxLifecycleHelper {
    /**
     * Observable 切换到主线程
     */
    public static <T> LifecycleTransformer<T> bindLifecycle(Context context) {
        if (context instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity) context).bindUntilEvent(ActivityEvent.DESTROY);
        }
        return ((RxAppCompatActivity)context).bindUntilEvent(ActivityEvent.DESTROY);
    }
}
