package com.horoscope.horoscope;

import androidx.recyclerview.widget.RecyclerView;

import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.mvp.m.MainModel;
import com.horoscope.horoscope.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.view.CommonToolbar;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @BindView(R2.id.ct)
    CommonToolbar ct;
    @BindView(R2.id.rv)
    RecyclerView rv;

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
