package com.horoscope.horoscope;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.horoscope.horoscope.entity.event.AddTypeEvent;
import com.horoscope.horoscope.entity.event.ChooseTypeEvent;
import com.quickstart.baselib.base.BaseDialogFragment;

import org.greenrobot.eventbus.EventBus;

public class CreateTypeDialog extends BaseDialogFragment {
    public static final String TYPE = "type";

    public static CreateTypeDialog getCreateTypeDialog() {
        CreateTypeDialog dialog = new CreateTypeDialog();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.horoscope_dialog_create_type, container, false);
        EditText et = view.findViewById(R.id.et_name);
        if (getArguments().getInt(TYPE) == ChooseTypeEvent.TYPE_DIARY) {
            et.setHint("diary名");
        }
        if (getArguments().getInt(TYPE) == ChooseTypeEvent.TYPE_TODO_LIST) {
            et.setHint("todoList名");
        }
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvCommit = view.findViewById(R.id.tv_commit);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new AddTypeEvent(et.getText().toString()));
                dismiss();
            }
        });
        return view;
    }
}
