package com.beauty.beautychecker;

import androidx.recyclerview.widget.RecyclerView;

import com.beauty.beautychecker.mvp.contract.MainContract;
import com.beauty.beautychecker.mvp.m.MainModel;
import com.beauty.beautychecker.mvp.p.MainPresenter;
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
        return R.layout.beautychecker_activity_main;
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
