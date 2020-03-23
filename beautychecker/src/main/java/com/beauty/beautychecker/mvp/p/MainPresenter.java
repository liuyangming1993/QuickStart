package com.beauty.beautychecker.mvp.p;

import com.beauty.beautychecker.mvp.contract.MainContract;
import com.quickstart.baselib.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.MainView, MainContract.MainModel> {
    public MainPresenter(MainContract.MainView view, MainContract.MainModel model) {
        super(view, model);
    }
}
