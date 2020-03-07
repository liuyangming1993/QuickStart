package com.quickstart.baselib.net.download;

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
import com.quickstart.baselib.net.BaseDialogFragment;

import java.util.Objects;

/**
 * 下载专用的loading，样式暂时和网络请求的一致，新建这个类是为了避免以后的更改
 */
public class DownloadLoadingDialog extends BaseDialogFragment {
    public static DownloadLoadingDialog getDownloadLoadingDialog() {
        // TODO: 2020/2/24 此次没有使用单例 ，是为了避免一个页面同时调用多个接口时展示多个此dialog造成异常的问题。
        DownloadLoadingDialog dialog = new DownloadLoadingDialog();
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

    public void show(Context context) {
        if (context instanceof AppCompatActivity) {
            show(((AppCompatActivity) context).getSupportFragmentManager(), "");
        }
    }
}
