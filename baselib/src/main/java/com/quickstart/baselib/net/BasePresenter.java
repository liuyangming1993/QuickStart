package com.quickstart.baselib.net;

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {
    protected M mModel;
    protected V mView;

    public BasePresenter(V view, M model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onDestroy() {
        if (mView != null) {
            mView = null;
        }
        if (mModel != null) {
            mModel.onDestroy();
            mModel = null;
        }
    }
}
