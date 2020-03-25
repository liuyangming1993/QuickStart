package com.beauty.beautychecker;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beauty.beautychecker.entity.BeautyResponse;
import com.beauty.beautychecker.mvp.contract.MainContract;
import com.beauty.beautychecker.mvp.m.MainModel;
import com.beauty.beautychecker.mvp.p.MainPresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.util.ImageHelper;
import com.quickstart.baselib.view.CommonToolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @BindView(R2.id.ct)
    CommonToolbar ct;
    @BindView(R2.id.rv)
    RecyclerView rv;
    private List<BeautyResponse> mData;
    private BaseQuickAdapter<BeautyResponse, BaseViewHolder> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.beautychecker_activity_main;
    }

    @Override
    public void initVariable() {
        mPresenter = new MainPresenter(this, new MainModel());
        mData = new ArrayList<>();
        mAdapter = new BaseQuickAdapter<BeautyResponse, BaseViewHolder>(R.layout.beautychecker_item_rv, mData) {
            @Override
            protected void convert(@NonNull BaseViewHolder helper, BeautyResponse item) {
                ImageView iv = helper.getView(R.id.iv);
                TextView tv = helper.getView(R.id.tv_description);
                ImageHelper.show(MainActivity.this, item.getAlbumList().get(0).getThumbnail(), iv);
                tv.setText(item.getName());
            }
        };
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    public void loadData() {
        mPresenter.checkVersion(this);
        mPresenter.dataUpdate(this);
    }

    @Override
    public void showData(List<BeautyResponse> responses) {
        mData.clear();
        mData.addAll(responses);
        for (BeautyResponse datum : mData) {
            Log.i("liuym", "showData: " + datum.getName());
        }
        mAdapter.notifyDataSetChanged();
    }
}
