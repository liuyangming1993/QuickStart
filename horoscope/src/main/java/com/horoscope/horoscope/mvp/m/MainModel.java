package com.horoscope.horoscope.mvp.m;

import android.content.Context;

import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.DiaryBeanDao;
import com.horoscope.horoscope.entity.TodoListBean;
import com.horoscope.horoscope.entity.UserBean;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.util.DatabaseManager;
import com.quickstart.baselib.mvp.BaseModel;
import com.quickstart.baselib.net.helper.RxSchedulersHelper;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import static com.horoscope.horoscope.constant.Constant.Default.BIRTHDAY;
import static com.horoscope.horoscope.constant.Constant.Default.NICKNAME;
import static com.horoscope.horoscope.constant.Constant.Default.USER_ID;

public class MainModel extends BaseModel implements MainContract.MainModel {
    @Override
    public Observable<Long> createDefaultUser(Context context) {
        UserBean userBean = new UserBean();
        userBean.setId(USER_ID);
        userBean.setNickname(NICKNAME);
        userBean.setBirthday(BIRTHDAY);
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                emitter.onNext(DatabaseManager.getDaoSession(context).insert(userBean));
            }
        }).compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public Observable<Long> createDiary(Context context, String diaryName) {
        DiaryBean diaryBean = new DiaryBean();
        diaryBean.setDiaryName(diaryName);
        diaryBean.setCreateUser(USER_ID);
        diaryBean.setCreateTime(System.currentTimeMillis());
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                emitter.onNext(DatabaseManager.getDaoSession(context).insert(diaryBean));
            }
        }).compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public Observable<Long> createTodoList(Context context, String title) {
        TodoListBean todoListBean = new TodoListBean();
        todoListBean.setTitle(title);
        todoListBean.setCreateTime(System.currentTimeMillis());
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                emitter.onNext(DatabaseManager.getDaoSession(context).insert(todoListBean));
            }
        }).compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public Observable<List<DiaryBean>> getDiaries(Context context) {
        return Observable.create(new ObservableOnSubscribe<List<DiaryBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<DiaryBean>> emitter) throws Exception {
                QueryBuilder<DiaryBean> qb = DatabaseManager.getDaoSession(context).queryBuilder(DiaryBean.class);
                QueryBuilder<DiaryBean> queryBuilder = qb.where(DiaryBeanDao.Properties.CreateUser.eq(USER_ID))
                        .orderAsc(DiaryBeanDao.Properties.CreateUser);
                List<DiaryBean> list = queryBuilder.list();
                emitter.onNext(list);
            }
        }).compose(RxSchedulersHelper.ioToMain());
    }

    @Override
    public Observable<List<TodoListBean>> getTodoLists(Context context) {
        return Observable.create(new ObservableOnSubscribe<List<TodoListBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<TodoListBean>> emitter) throws Exception {
                List<TodoListBean> list = DatabaseManager.getDaoSession(context).queryRaw(TodoListBean.class, "where createUser = ?", String.valueOf(USER_ID));
                emitter.onNext(list);
            }
        }).compose(RxSchedulersHelper.ioToMain());
    }
}
