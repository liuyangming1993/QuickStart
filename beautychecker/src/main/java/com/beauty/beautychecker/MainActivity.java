package com.beauty.beautychecker;

import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.update.UpdateContract;
import com.quickstart.baselib.update.UpdateDialog;
import com.quickstart.baselib.update.UpdateModel;
import com.quickstart.baselib.update.UpdatePresenter;
import com.quickstart.baselib.update.entity.UpdateResponse;
import com.quickstart.baselib.util.AppUtil;

public class MainActivity extends BaseActivity<UpdatePresenter> implements UpdateContract.UpdateView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariable() {
        mPresenter = new UpdatePresenter(this, new UpdateModel());
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

    @Override
    public void checkVersionSuccess(UpdateResponse response) {
        int versionCode = AppUtil.getVersionCode(this);
        if (versionCode < response.getLatestCode()) {
            UpdateDialog.getUpdateDialog(response, "").show(this);
        }
    }
}
