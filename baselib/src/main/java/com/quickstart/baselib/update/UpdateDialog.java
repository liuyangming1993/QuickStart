package com.quickstart.baselib.update;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.quickstart.baselib.R;
import com.quickstart.baselib.base.BaseDialogFragment;
import com.quickstart.baselib.update.entity.UpdateResponse;

import java.util.Objects;

public class UpdateDialog extends BaseDialogFragment {
    private TextView tvContent;
    private LinearLayout ll;
    private Button btCancel;
    private Button btSure;
    private UpdateResponse mUpdateResponse;
    private String mChannel;

    public static UpdateDialog getUpdateDialog(UpdateResponse updateResponse, String channel) {
        UpdateDialog dialog = new UpdateDialog(updateResponse, channel);
        return dialog;
    }

    private UpdateDialog(UpdateResponse updateResponse, String channel) {
        mUpdateResponse = updateResponse;
        mChannel = channel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        ll = (LinearLayout) inflater.inflate(R.layout.dialog_update, container, false);
        initView();
        initListener();
        return ll;
    }

    private void initView() {
        tvContent = ll.findViewById(R.id.tv_content);
        btCancel = ll.findViewById(R.id.bt_cancel);
        btSure = ll.findViewById(R.id.bt_sure);
        tvContent.setText(mUpdateResponse.getDescription());
        if (!mUpdateResponse.isNecessary()) {
            btCancel.setVisibility(View.VISIBLE);
        }
    }

    private void initListener() {
        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2020/3/22 跳转到应用商店（根据渠道）
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();
            }
        });
    }
}
