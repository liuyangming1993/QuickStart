package com.quickstart.baselib.net.download;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DownloadManager implements DownloadProgressListener {
    private static final String TAG = "DownloadManager";
    private DownloadInfo mDownloadInfo;
    private ProgressListener progressObserver;
    private File outFile;
    private Disposable disposable;
    private DownLoadService service;
    private long currentRead;

    private DownloadManager() {
//        mDownloadInfo = new DownloadInfo();
//        outFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "yaoshi.mp4");
//        mDownloadInfo.setSavePath(outFile.getAbsolutePath());
    }

    public static DownloadManager getInstance() {
        return Holder.manager;
    }

    public static class Holder {
        private static DownloadManager manager = new DownloadManager();
    }

    @Override
    public void progress(long read, final long contentLength, final boolean done) {
        Log.e("progress : ", "read = " + read + "contentLength = " + contentLength);
        // 该方法仍然是在子线程，如果想要调用进度回调，需要切换到主线程，否则的话，会在子线程更新UI，直接错误
        // 如果断电续传，重新请求的文件大小是从断点处到最后的大小，不是整个文件的大小，info中的存储的总长度是
        // 整个文件的大小，所以某一时刻总文件的大小可能会大于从某个断点处请求的文件的总大小。此时read的大小为
        // 之前读取的加上现在读取的
        if (mDownloadInfo.getContentLength() > contentLength) {
            read = read + (mDownloadInfo.getContentLength() - contentLength);
        } else {
            mDownloadInfo.setContentLength(contentLength);
        }
        mDownloadInfo.setReadLength(read);

        Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (progressObserver != null) {
                    progressObserver.progressChanged(mDownloadInfo.getReadLength(), mDownloadInfo.getContentLength(), done);
                }
            }
        });
    }

    /**
     * 开始下载
     *
     * @param url
     */
    public void start(String url) {
        mDownloadInfo.setUrl(url);
        final DownloadInterceptor interceptor = new DownloadInterceptor(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(CommonUtils.getBasUrl(url))
                .build();
//        if (service == null) {
//            service = retrofit.create(DownLoadService.class);
//            mDownloadInfo.setService(service);
//        } else {
//            service = mDownloadInfo.getService();
//        }
        service = retrofit.create(DownLoadService.class);
        mDownloadInfo.setService(service);
        downLoad();
    }

    /**
     * 开始下载
     */
    private void downLoad() {
        Log.e("下载：", mDownloadInfo.toString());
        service.download("bytes=" + mDownloadInfo.getReadLength() + "-", mDownloadInfo.getUrl())
                /*指定线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .retryWhen(new RetryWhenNetworkException())
                /* 读取下载写入文件，并把ResponseBody转成DownInfo */
                .map(new Function<ResponseBody, DownloadInfo>() {
                    @Override
                    public DownloadInfo apply(ResponseBody responseBody) {
                        try {
                            //写入文件
                            FileUtil.writeCache(responseBody, new File(mDownloadInfo.getSavePath()), mDownloadInfo);
                        } catch (IOException e) {
                            Log.e("异常:", e.toString());
                        }
                        return mDownloadInfo;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DownloadInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(DownloadInfo downloadInfo) {
                        Log.e("下载", "onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("下载", "onError" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("下载", "onCompleted");
                    }
                });

    }

    /**
     * 暂停下载
     */
    public void pause() {
        if (disposable != null)
            disposable.dispose();
    }

    /**
     * 继续下载
     */
    public void reStart() {
        downLoad();
    }

    /**
     * 进度监听
     */
    public interface ProgressListener {
        void progressChanged(long read, long contentLength, boolean done);
    }

    public void setProgressListener(ProgressListener progressObserver) {
        this.progressObserver = progressObserver;
    }

    /**
     * 设置输出文件信息
     *
     * @param path "/storage/emulated/0/Download/xxx.mp4"
     */
    public DownloadManager setOutFileInfo(String path) {
        outFile = new File(path);
        mDownloadInfo = new DownloadInfo();
        mDownloadInfo.setSavePath(outFile.getAbsolutePath());
        return this;
    }
}
