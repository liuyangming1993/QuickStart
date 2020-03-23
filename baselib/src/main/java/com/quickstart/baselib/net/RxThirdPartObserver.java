package com.quickstart.baselib.net;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;

import com.quickstart.baselib.net.loading.NetworkLoadingDialog;
import com.quickstart.baselib.util.LogUtil;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class RxThirdPartObserver<D> implements Observer<D> {
    private static final String TAG = "RxThirdPartObserver";
    private Context mContext;
    /**
     * 是否需要loading
     */
    private boolean mHasLoading;
    private NetworkLoadingDialog mNetworkLoadingDialog;

    public RxThirdPartObserver(Context context, boolean hasLoading) {
        mContext = context;
        mHasLoading = hasLoading;
        if (hasLoading) {
            mNetworkLoadingDialog = NetworkLoadingDialog.getNetworkLoadingDialog();
        }
    }

    public RxThirdPartObserver(Context context) {
        this(context, true);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        isShowLoadingNecessary();
    }

    @Override
    public void onNext(@NonNull D response) {
        if (isSuccess(response)) {
            onSuccess(response);
        } else {
            onFailure(response);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        isDismissLoadingNecessary();
        if (e instanceof ConnectException ||
                e instanceof NetworkErrorException ||
                e instanceof UnknownHostException) {
            LogUtil.e(TAG, "onError: network error.");
        } else if (e instanceof TimeoutException) {
            LogUtil.e(TAG, "onError: network time out.");
        } else {
            LogUtil.e(TAG, "onError: other error.");
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        isDismissLoadingNecessary();
    }

    /**
     * 是否有必要关闭loading
     */
    private void isDismissLoadingNecessary() {
        if (mHasLoading) {
            mNetworkLoadingDialog.dismissAllowingStateLoss();
        }
    }

    /**
     * 是否有必要显示loading
     */
    private void isShowLoadingNecessary() {
        if (mHasLoading) {
            mNetworkLoadingDialog.show(mContext);
        }
    }

    /**
     * 请求成功，但是返回数据失败
     *
     * @param response
     */
    public void onFailure(D response) {
    }

    /**
     * 请求成功，数据正确
     *
     * @param response
     */
    public abstract void onSuccess(D response);

    /**
     * 返回是否成功
     *
     * @param response
     * @return
     */
    public abstract boolean isSuccess(D response);
}
