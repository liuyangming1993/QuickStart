package com.quickstart.baselib.update;

import android.content.Context;

import com.quickstart.baselib.update.entity.UpdateResponse;
import com.quickstart.baselib.util.AppUtil;

public class UpdateHelper implements UpdateContract.UpdateView {

    private Context mContext;
    private UpdatePresenter mPresenter;

    private UpdateHelper(Context context) {
        mContext = context;
        mPresenter = new UpdatePresenter(this, new UpdateModel());
    }

    public static UpdateHelper getInstance(Context context) {
        return new UpdateHelper(context);
    }

    public void check() {
        mPresenter.checkVersion(mContext);
    }

    @Override
    public void checkVersionSuccess(UpdateResponse response) {
        int currentCode = AppUtil.getVersionCode(mContext);
        if (currentCode < response.getLatestCode()) {
            UpdateDialog.getUpdateDialog(response, "").show(mContext);
        }
    }
}
