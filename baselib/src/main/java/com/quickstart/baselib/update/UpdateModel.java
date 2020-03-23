package com.quickstart.baselib.update;

import com.quickstart.baselib.mvp.BaseModel;
import com.quickstart.baselib.net.BaseResponse;
import com.quickstart.baselib.net.helper.RxSchedulersHelper;
import com.quickstart.baselib.update.entity.UpdateResponse;

import io.reactivex.Observable;

public class UpdateModel extends BaseModel implements UpdateContract.UpdateModel {
    @Override
    public Observable<BaseResponse<UpdateResponse>> checkVersion() {
        return getRetrofit().create(UpdateApi.class)
                .checkVersion()
                .compose(RxSchedulersHelper.ioToMain());
    }
}
