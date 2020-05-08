package com.horoscope.horoscope.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.horoscope.horoscope.entity.DaoMaster;

import org.greenrobot.greendao.database.Database;

import java.io.File;

public class DatabaseHelper extends DaoMaster.OpenHelper {

    public DatabaseHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {

    }

    // 增加下面逻辑是为了避免SQLiteCantOpenDatabaseException: unable to open database file (code 14)
    private static boolean mainTmpDirSet = false;

    @Override
    public SQLiteDatabase getReadableDatabase() {
        if (!mainTmpDirSet) {
            boolean rs = new File("/data/data/com.horoscope.horoscopeapp/databases/main").mkdir();
            super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = '/data/data/com.horoscope.horoscopeapp/databases/main'");
            mainTmpDirSet = true;
            return super.getReadableDatabase();
        }
        return super.getReadableDatabase();
    }
    // end
}
