package com.quickstart.baselib.net;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static com.quickstart.baselib.net.Constant.C_SUCCESS;

public abstract class RxDefaultObserver<D> implements Observer<BaseResponse<D>> {
    private static final String TAG = "RxDefaultObserver";
    private Context mContext;
    /**
     * 是否需要loading
     */
    private boolean mHasLoading;
    private NetworkLoadingDialog mNetworkLoadingDialog;

    public RxDefaultObserver(Context context, boolean hasLoading) {
        mContext = context;
        mHasLoading = hasLoading;
        if (hasLoading) {
            mNetworkLoadingDialog = NetworkLoadingDialog.getNetworkLoadingDialog();
        }
    }

    public RxDefaultObserver(Context context) {
        this(context, true);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        isShowLoadingNecessary();
    }

    @Override
    public void onNext(@NonNull BaseResponse<D> dBaseResponse) {
        if (dBaseResponse.getC() == C_SUCCESS) {
            // TODO: 2020/2/20 这里没有直接传入泛型中的D，是因为怕不只是在c==C_SUCCESS时才代表成功，以防万一吧。
            onSuccess(dBaseResponse);
        } else {
            onFailure(dBaseResponse);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        isDismissLoadingNecessary();
        if (e instanceof ConnectException ||
                e instanceof NetworkErrorException ||
                e instanceof UnknownHostException) {
            Log.e(TAG, "onError: network error.");
        } else if (e instanceof TimeoutException) {
            Log.e(TAG, "onError: network time out.");
        } else {
            Log.e(TAG, "onError: other error.");
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
            mNetworkLoadingDialog.dismiss();
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
     * @param dBaseResponse
     */
    public void onFailure(BaseResponse<D> dBaseResponse) {
        Log.d(TAG, "onFailure: " + dBaseResponse.getC());
    }

    /**
     * 请求成功，数据正确
     *
     * @param dBaseResponse
     */
    public abstract void onSuccess(BaseResponse<D> dBaseResponse);
}
