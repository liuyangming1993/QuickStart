package com.quickstart.baselib.update;

import android.content.Context;

import com.quickstart.baselib.mvp.BasePresenter;
import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.net.RxDefaultObserver;
import com.quickstart.baselib.net.helper.RxLifecycleHelper;
import com.quickstart.baselib.update.entity.UpdateResponse;

public class UpdatePresenter extends BasePresenter<UpdateContract.UpdateView, UpdateContract.UpdateModel> {
    public UpdatePresenter(UpdateContract.UpdateView view, UpdateContract.UpdateModel model) {
        super(view, model);
    }

    public void checkVersion(Context context) {
        mModel.checkVersion()
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDefaultObserver<UpdateResponse>(context) {
                    @Override
                    public void onSuccess(BaseResponse<UpdateResponse> updateResponseBaseResponse) {
                        mView.checkVersionSuccess(updateResponseBaseResponse.getContent());
                    }
                });
    }
}
