package com.quickstart.baselib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.quickstart.baselib.mvp.IPresenter;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {
    protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
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
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected void useEventBus(boolean use) {
        if (use) {
            EventBus.getDefault().register(this);
        }
    }
}
