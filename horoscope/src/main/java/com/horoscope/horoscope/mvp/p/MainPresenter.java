package com.horoscope.horoscope.mvp.p;

import android.content.Context;

import com.horoscope.horoscope.mvp.contract.MainContract;
import com.quickstart.baselib.mvp.BasePresenter;
import com.quickstart.baselib.net.helper.RxLifecycleHelper;
import com.quickstart.baselib.update.UpdateHelper;


public class MainPresenter extends BasePresenter<MainContract.MainView, MainContract.MainModel> {
    public MainPresenter(MainContract.MainView view, MainContract.MainModel model) {
        super(view, model);
    }

    public void checkVersion(Context context) {
        UpdateHelper.getInstance(context).check();
    }
}
