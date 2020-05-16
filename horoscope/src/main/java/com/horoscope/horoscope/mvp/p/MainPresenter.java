package com.horoscope.horoscope.mvp.p;

import android.annotation.SuppressLint;
import android.content.Context;

import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.TodoListBean;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.quickstart.baselib.mvp.BasePresenter;
import com.quickstart.baselib.net.helper.RxLifecycleHelper;
import com.quickstart.baselib.util.RxDatabaseObserver;
import com.quickstart.baselib.util.SharedPreferencesHelper;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
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

    public void createDiary(Context context, String diaryName) {
        mModel.createDiary(context, diaryName)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDatabaseObserver<Long>() {
                    @Override
                    public void onSuccess(Long aLong) {
                        mView.createDiarySuccess(diaryName);
                    }
                });
    }

    public void createTodoList(Context context, String title) {
        mModel.createTodoList(context, title)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDatabaseObserver<Long>() {
                    @Override
                    public void onSuccess(Long aLong) {
                        mView.createTodoListSuccess(title);
                    }
                });
    }

    public void getDiaries(Context context) {
        mModel.getDiaries(context)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDatabaseObserver<List<DiaryBean>>() {
                    @Override
                    public void onSuccess(List<DiaryBean> list) {
                        mView.showDiaries(list);
                    }
                });
    }

    public void getTodoLists(Context context) {
        mModel.getTodoLists(context)
                .compose(RxLifecycleHelper.bindLifecycle(context))
                .subscribe(new RxDatabaseObserver<List<TodoListBean>>() {
                    @Override
                    public void onSuccess(List<TodoListBean> todoListBeans) {
                        mView.showTodoLists(todoListBeans);
                    }
                });
    }
}
