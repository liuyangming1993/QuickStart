package com.horoscope.horoscope;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.horoscope.horoscope.entity.event.AddTypeEvent;
import com.horoscope.horoscope.entity.event.ChooseTypeEvent;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.mvp.m.MainModel;
import com.horoscope.horoscope.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.view.CommonToolbar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @BindView(R2.id.ct)
    CommonToolbar ct;
    @BindView(R2.id.rv)
    RecyclerView rv;
    @BindView(R2.id.rl_main)
    RelativeLayout rlMain;
    @BindView(R2.id.ll_drawer)
    LinearLayout llDrawer;
    @BindView(R2.id.dl)
    DrawerLayout dl;
    private TypeSelectDialog mTypeSelectDialog;
    private CreateTypeDialog mCreateTypeDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.horoscope_activity_main;
    }

    @Override
    public void initVariable() {
        useEventbus(true);
        mPresenter = new MainPresenter(this, new MainModel());
        mTypeSelectDialog = TypeSelectDialog.getTypeSelectDialog();
        mCreateTypeDialog = CreateTypeDialog.getCreateTypeDialog();
    }

    @Override
    public void initView() {
        ct.getTvTitle().setText(R.string.lucky_diary);
    }

    @Override
    public void initListener() {
        ct.getIvLeft().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDrawerState();
            }
        });
        ct.getIvRight1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTypeSelectDialog.show(MainActivity.this);
            }
        });
    }

    @Override
    public void loadData() {
        mPresenter.checkVersion(this);
    }

    private void changeDrawerState() {
        if (dl.isDrawerOpen(llDrawer)) {
            dl.closeDrawer(llDrawer);
        } else {
            dl.openDrawer(llDrawer);
        }
    }

    private void closeDrawer() {
        if (dl.isDrawerOpen(llDrawer)) {
            dl.closeDrawer(llDrawer);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getChooseType(ChooseTypeEvent event) {
        showCreateTypeDialog(event.type);
    }

    private void showCreateTypeDialog(int eventType) {
        Bundle bundle = new Bundle();
        bundle.putInt(CreateTypeDialog.TYPE, eventType);
        mCreateTypeDialog.setArguments(bundle);
        mCreateTypeDialog.show(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getAddTypeEvent(AddTypeEvent event) {
        // TODO: 2020/5/12 创建日记表或者todo列表
    }
}
