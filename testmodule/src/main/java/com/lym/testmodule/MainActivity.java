package com.lym.testmodule;

import android.os.Bundle;

import com.quickstart.baselib.update.UpdateContract;
import com.quickstart.baselib.update.entity.UpdateResponse;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

public class MainActivity extends RxAppCompatActivity implements UpdateContract.UpdateView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void checkVersionSuccess(UpdateResponse response) {

    }
}
