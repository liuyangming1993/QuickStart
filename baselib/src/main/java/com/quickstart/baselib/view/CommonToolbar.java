package com.quickstart.baselib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CommonToolbar extends RelativeLayout {
    public CommonToolbar(Context context) {
        this(context, null, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

    }
}
