package com.quickstart.baselib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.quickstart.baselib.R;
import com.quickstart.baselib.base.BaseActivity;

public class CommonToolbar extends RelativeLayout {
    private ImageView mIvLeft;
    private TextView mTvTitle;
    private RelativeLayout mRl;

    public CommonToolbar(Context context) {
        this(context, null, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initListener();
    }

    private void initListener() {
        mIvLeft.setOnClickListener(v -> {
            if (v.getContext() instanceof BaseActivity) {
                ((BaseActivity) v.getContext()).finish();
            }
        });
    }

    private void initView(Context context) {
        mRl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.view_common_toolbar, this, true);
        mIvLeft = mRl.findViewById(R.id.iv_left);
        mTvTitle = mRl.findViewById(R.id.tv_title);
    }
}
