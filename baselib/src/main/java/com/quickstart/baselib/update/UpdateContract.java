package com.quickstart.baselib.update;

import com.quickstart.baselib.mvp.IModel;
import com.quickstart.baselib.mvp.IView;
import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.update.entity.UpdateResponse;

import io.reactivex.Observable;

public interface UpdateContract {
    interface UpdateView extends IView {
        void checkVersionSuccess(UpdateResponse response);
    }

    interface UpdateModel extends IModel {
        Observable<BaseResponse<UpdateResponse>> checkVersion();
    }
}
