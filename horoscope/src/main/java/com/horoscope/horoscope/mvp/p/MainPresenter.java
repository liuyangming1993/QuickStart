package com.horoscope.horoscope.mvp.p;

import android.annotation.SuppressLint;
import android.content.Context;

import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.TodoListBean;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.quickstart.baselib.mvp.BasePresenter;
import com.quickstart.baselib.net.helper.RxLifecycleHelper;
import com.quickstart.baselib.util.SharedPreferencesHelper;

import java.util.List;

import io.reactivex.functions.Consumer;

import static com.horoscope.horoscope.Constant.SP_FIRST_LAUNCH;


public class MainPresenter extends BasePresenter<MainContract.MainView, MainContract.MainModel> {
    public MainPresenter(MainContract.MainView view, MainContract.MainModel model) {
        super(view, model);
    }

    public void checkVersion(Context context) {
//        UpdateHelper.getInstance(context).check();
    }

    public void checkFirstLaunch(Context context) {
        boolean isFirstLaunch = SharedPreferencesHelper.getSp(context).getBoolean(SP_FIRST_LAUNCH, true);
        if (isFirstLaunch) {
            SharedPreferencesHelper.putAndApply(context, SP_FIRST_LAUNCH, false);
            mModel.createDefaultUser(context);
        }
    }

    @SuppressLint("CheckResult")
    public void createDiary(Context context, String diaryName) {
        mModel.createDiary(context, diaryName)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mView.createDiarySuccess(diaryName);
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void createTodoList(Context context, String title) {
        mModel.createTodoList(context, title)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mView.createTodoListSuccess(title);
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void getDiaries(Context context) {
        mModel.getDiaries(context)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new Consumer<List<DiaryBean>>() {
                    @Override
                    public void accept(List<DiaryBean> diaryBeans) throws Exception {
                        mView.showDiaries(diaryBeans);
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void getTodoLists(Context context) {
        mModel.getTodoLists(context)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new Consumer<List<TodoListBean>>() {
                    @Override
                    public void accept(List<TodoListBean> todoListBeans) throws Exception {
                        mView.showTodoLists(todoListBeans);
                    }
                });
    }
}
