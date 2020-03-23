package com.quickstart.baselib.net.loading;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quickstart.baselib.R;
import com.quickstart.baselib.base.BaseDialogFragment;

import java.util.Objects;

public class NetworkLoadingDialog extends BaseDialogFragment {
    public static NetworkLoadingDialog getNetworkLoadingDialog() {
        // TODO: 2020/2/24 此次没有使用单例 ，是为了避免一个页面同时调用多个接口时展示多个此dialog造成异常的问题。
        NetworkLoadingDialog dialog = new NetworkLoadingDialog();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        View view = inflater.inflate(R.layout.dialog_network_loading, container, false);
        return view;
    }
}
