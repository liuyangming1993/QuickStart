package com.beauty.beautycheckerapp;

import com.quickstart.baselib.base.BaseApplication;
import com.umeng.commonsdk.UMConfigure;

public class BeautyCheckerApp extends BaseApplication {
    private static final String TAG = "BeautyCheckerApp";

    @Override
    public void onCreate() {
        super.onCreate();
        initUmeng();
    }

    private void initUmeng() {
        UMConfigure.init(this, "5e79c2e6dbc2ec076bd61c35", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
    }
}
