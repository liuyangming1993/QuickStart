package com.horoscope.horoscope.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.horoscope.horoscope.R;
import com.horoscope.horoscope.R2;
import com.horoscope.horoscope.adapter.MainDiaryAdapter;
import com.horoscope.horoscope.adapter.MainTodoListAdapter;
import com.horoscope.horoscope.dialog.CreateTypeDialog;
import com.horoscope.horoscope.dialog.TypeSelectDialog;
import com.horoscope.horoscope.entity.DiaryBean;
import com.horoscope.horoscope.entity.TodoListBean;
import com.horoscope.horoscope.entity.event.AddTypeEvent;
import com.horoscope.horoscope.entity.event.ChooseTypeEvent;
import com.horoscope.horoscope.mvp.contract.MainContract;
import com.horoscope.horoscope.mvp.m.MainModel;
import com.horoscope.horoscope.mvp.p.MainPresenter;
import com.quickstart.baselib.base.BaseActivity;
import com.quickstart.baselib.view.CommonToolbar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.horoscope.horoscope.constant.Constant.TYPE_DIARY;
import static com.horoscope.horoscope.constant.Constant.TYPE_TODO_LIST;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView {

    @BindView(R2.id.ct)
    CommonToolbar ct;
    @BindView(R2.id.rl_main)
    RelativeLayout rlMain;
    @BindView(R2.id.ll_drawer)
    LinearLayout llDrawer;
    @BindView(R2.id.dl)
    DrawerLayout dl;
    private TypeSelectDialog mTypeSelectDialog;
    private CreateTypeDialog mCreateTypeDialog;
    private MainDiaryAdapter mDiaryAdapter;
    private List<DiaryBean> mDiaryBeanList;
    private MainTodoListAdapter mTodoListAdapter;
    private List<TodoListBean> mTodoListBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.horoscope_activity_main;
    }

    @Override
    public void initVariable() {
        useEventBus(true);
        mPresenter = new MainPresenter(this, new MainModel());
        mTypeSelectDialog = TypeSelectDialog.getTypeSelectDialog();
        mCreateTypeDialog = CreateTypeDialog.getCreateTypeDialog();
        mDiaryBeanList = new ArrayList<>();
        mDiaryAdapter = new MainDiaryAdapter(R.layout.horoscope_item_rv_main_diary, mDiaryBeanList);
        mTodoListBeanList = new ArrayList<>();
        mTodoListAdapter = new MainTodoListAdapter(R.layout.horoscope_item_rv_main_todolist, mTodoListBeanList);
    }

    @Override
    public void initView() {
        ct.getTvTitle().setText(R.string.lucky_diary);
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(mDiaryAdapter);
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
        mPresenter.checkFirstLaunch(this);
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
        if (event.type == TYPE_DIARY) {
            mPresenter.createDiary(this, event.name);
        }
        if (event.type == TYPE_TODO_LIST) {
            mPresenter.createTodoList(this, event.name);
        }
    }

    @Override
    public void createDiarySuccess(String diaryName) {
        mPresenter.getDiaries(this);
    }

    @Override
    public void createTodoListSuccess(String title) {
        mPresenter.getTodoLists(this);
    }

    @Override
    public void showDiaries(List<DiaryBean> list) {
        mDiaryBeanList.clear();
        mDiaryBeanList.addAll(list);
        mDiaryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTodoLists(List<TodoListBean> list) {
        mTodoListBeanList.clear();
        mTodoListBeanList.addAll(list);
        mTodoListAdapter.notifyDataSetChanged();
    }
}
