package com.horoscope.horoscope.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.horoscope.horoscope.R;
import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.TodoListBean;

import java.util.List;

public class MainTodoListAdapter extends BaseQuickAdapter<TodoListBean, BaseViewHolder> {

    public MainTodoListAdapter(int layoutResId, @Nullable List<TodoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TodoListBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
    }
}
