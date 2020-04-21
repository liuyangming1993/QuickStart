package com.horoscope.horoscope;

import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.mvp.m.MainModel;
import com.horoscope.horoscope.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.image.GlideApp;
import com.quickstart.baselib.util.BlurTransformation;

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
        ImageView iv = findViewById(R.id.iv);
        GlideApp.with(this)
                .load("https://www.baidu.com/img/bd_logo1.png")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(this, 30, 3)))
                .into(iv);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void loadData() {
        mPresenter.checkVersion(this);
    }
}
