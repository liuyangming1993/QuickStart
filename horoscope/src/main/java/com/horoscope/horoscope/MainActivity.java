package com.horoscope.horoscope;

import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.mvp.m.MainModel;
import com.horoscope.horoscope.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @Override
    protected int getLayoutId() {
        return R.layout.horoscope_activity_main;
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
