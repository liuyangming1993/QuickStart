package com.beauty.beautychecker.mvp.p;

import android.content.Context;
import android.util.Log;

import com.beauty.beautychecker.entity.BeautyResponse;
import com.beauty.beautychecker.entity.DataUpdateResponse;
import com.beauty.beautychecker.mvp.contract.MainContract;
import com.quickstart.baselib.mvp.BasePresenter;
import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.net.RxDefaultObserver;
import com.quickstart.baselib.net.helper.RxLifecycleHelper;
import com.quickstart.baselib.update.UpdateHelper;

import java.util.List;

public class MainPresenter extends BasePresenter<MainContract.MainView, MainContract.MainModel> {
    public MainPresenter(MainContract.MainView view, MainContract.MainModel model) {
        super(view, model);
    }

    public void checkVersion(Context context) {
        UpdateHelper.getInstance(context).check();
    }

    private void getData(Context context) {
        mModel.getData()
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDefaultObserver<List<BeautyResponse>>(context) {
                    @Override
                    public void onSuccess(BaseResponse<List<BeautyResponse>> listBaseResponse) {
                        mModel.writeData(context, listBaseResponse.getContent());
                        mView.showData(listBaseResponse.getContent());
                    }
                });
    }

    public void dataUpdate(Context context) {
        mModel.dataUpdate()
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDefaultObserver<DataUpdateResponse>(context) {
                    @Override
                    public void onSuccess(BaseResponse<DataUpdateResponse> dataUpdateResponseBaseResponse) {
                        if (dataUpdateResponseBaseResponse.getContent().isNecessary()) {
                            getData(context);
                        } else {
                            List<BeautyResponse> localData = mModel.readData(context);
                            if (localData.isEmpty()) {
                                getData(context);
                            } else {
                                mView.showData(localData);
                            }
                        }
                    }
                });
    }
}
