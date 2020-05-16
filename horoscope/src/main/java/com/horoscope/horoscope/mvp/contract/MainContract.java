package com.horoscope.horoscope.mvp.contract;

import android.content.Context;

import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.TodoListBean;
import com.quickstart.baselib.mvp.IModel;
import com.quickstart.baselib.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    interface MainView extends IView {
        void createDiarySuccess(String diaryName);

        void createTodoListSuccess(String title);

        void showDiaries(List<DiaryBean> list);

        void showTodoLists(List<TodoListBean> list);
    }

    interface MainModel extends IModel {
        Observable<Long> createDefaultUser(Context context);

        Observable<Long> createDiary(Context context, String diaryName);

        Observable<Long> createTodoList(Context context, String title);

        Observable<List<DiaryBean>> getDiaries(Context context);

        Observable<List<TodoListBean>> getTodoLists(Context context);
    }
}
