package com.beauty.beautychecker;

import com.beauty.beautychecker.mvp.contract.MainContract;
import com.beauty.beautychecker.mvp.m.MainModel;
import com.beauty.beautychecker.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.update.UpdateHelper;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariable() {
        mPresenter = new MainPresenter(this, new MainModel());
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {
        mPresenter.checkVersion(this);
    }
}
