package com.beauty.beautychecker.mvp.contract;

import android.content.Context;

import com.beauty.beautychecker.entity.BeautyResponse;
import com.beauty.beautychecker.entity.DataUpdateResponse;
import com.quickstart.baselib.mvp.IModel;
import com.quickstart.baselib.mvp.IView;
import com.quickstart.baselib.net.BaseResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    interface MainView extends IView {
        void showData(List<BeautyResponse> responses);
    }

    interface MainModel extends IModel {
        Observable<BaseResponse<List<BeautyResponse>>> getData();

        Observable<BaseResponse<DataUpdateResponse>> dataUpdate();

        void writeData(Context context, List<BeautyResponse> data);

        List<BeautyResponse> readData(Context context);
    }
}
