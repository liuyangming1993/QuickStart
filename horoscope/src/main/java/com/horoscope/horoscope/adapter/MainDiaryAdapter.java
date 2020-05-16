package com.horoscope.horoscope.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.horoscope.horoscope.R;
import com.horoscope.horoscope.entity.DiaryBean;

import java.util.List;

public class MainDiaryAdapter extends BaseQuickAdapter<DiaryBean, BaseViewHolder> {

    public MainDiaryAdapter(int layoutResId, @Nullable List<DiaryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DiaryBean item) {
        helper.setText(R.id.tv_title, item.getDiaryName());
    }
}
