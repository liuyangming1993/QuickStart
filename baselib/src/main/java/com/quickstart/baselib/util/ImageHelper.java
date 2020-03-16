package com.quickstart.baselib.util;

import android.content.Context;
import android.widget.ImageView;

import com.quickstart.baselib.image.GlideApp;

public class ImageHelper {
    public static void show(Context context, String url, ImageView iv) {
        GlideApp.with(context).load(url).into(iv);
    }
}
