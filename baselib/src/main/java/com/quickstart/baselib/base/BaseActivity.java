package com.quickstart.baselib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.quickstart.baselib.mvp.IPresenter;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initVariable();
        initView();
        initListener();
        loadData();
    }

    protected abstract int getLayoutId();

    public abstract void initVariable();

    public abstract void initView();

    public abstract void initListener();

    public abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
