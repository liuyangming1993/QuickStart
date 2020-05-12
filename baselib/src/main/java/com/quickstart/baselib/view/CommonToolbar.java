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
    private Context mContext;
    private ImageView mIvLeft;
    private TextView mTvTitle;
    private ImageView mIvRight1;
    private ImageView mIvRight2;
    private RelativeLayout mRl;

    private OnClickListener mDefaultBackIvListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getContext() instanceof BaseActivity) {
                ((BaseActivity) v.getContext()).onBackPressed();
            }
        }
    };

    public CommonToolbar(Context context) {
        this(context, null, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initListener();
    }

    private void initListener() {
        //默认做返回操作
        mIvLeft.setOnClickListener(mDefaultBackIvListener);
    }

    private void initView() {
        mRl = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.view_common_toolbar, this, true);
        mIvLeft = mRl.findViewById(R.id.iv_left);
        mTvTitle = mRl.findViewById(R.id.tv_title);
        mIvRight1 = mRl.findViewById(R.id.iv_right1);
        mIvRight2 = mRl.findViewById(R.id.iv_right2);
    }

    public ImageView getIvLeft() {
        return mIvLeft;
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    public ImageView getIvRight1() {
        return mIvRight1;
    }

    public ImageView getIvRight2() {
        return mIvRight2;
    }

    public RelativeLayout getRl() {
        return mRl;
    }
}
