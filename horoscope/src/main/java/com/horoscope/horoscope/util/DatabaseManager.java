package com.horoscope.horoscope.util;

import android.content.Context;

import com.horoscope.horoscope.entity.DaoMaster;
import com.horoscope.horoscope.entity.DaoSession;

public class DatabaseManager {
    private static final String DB_NAME = "horoscope.db";//数据库名称
    private static DatabaseHelper mHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private static DaoMaster getDaoMaster(Context context) {
        if (mDaoMaster == null) {
            mHelper = new DatabaseHelper(context, DB_NAME);
            mDaoMaster = new DaoMaster(mHelper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (mDaoSession == null) {
            mDaoSession = getDaoMaster(context).newSession();
        }
        return mDaoSession;
    }
}
