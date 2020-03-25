package com.quickstart.baselib.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesHelper {
    public static final String SP_NAME = "share_data";

    public static SharedPreferences.Editor getSpEditor(Context context) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        return editor;
    }

    public static void putAndApply(Context context, String key, Object object) {
        SharedPreferences.Editor editor = getSpEditor(context);
        if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        }
        if (object instanceof String) {
            editor.putString(key, (String) object);
        }
        if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        }
        if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        }
        if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        }
        editor.apply();
    }

    public static void putAndCommit(Context context, String key, Object object) {
        SharedPreferences.Editor editor = getSpEditor(context);
        if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        }
        if (object instanceof String) {
            editor.putString(key, (String) object);
        }
        if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        }
        if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        }
        if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        }
        editor.commit();
    }

    public static SharedPreferences getSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp;
    }
}
