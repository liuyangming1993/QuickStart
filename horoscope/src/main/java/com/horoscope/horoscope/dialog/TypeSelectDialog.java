package com.horoscope.horoscope.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.horoscope.horoscope.R;
import com.horoscope.horoscope.entity.event.ChooseTypeEvent;
import com.quickstart.baselib.base.BaseDialogFragment;

import org.greenrobot.eventbus.EventBus;

import static com.horoscope.horoscope.constant.Constant.TYPE_DIARY;
import static com.horoscope.horoscope.constant.Constant.TYPE_TODO_LIST;

public class TypeSelectDialog extends BaseDialogFragment {
    public static TypeSelectDialog getTypeSelectDialog() {
        TypeSelectDialog dialog = new TypeSelectDialog();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.horoscope_dialog_type_select, container, false);
        RelativeLayout rlDiary = view.findViewById(R.id.rl_diary);
        RelativeLayout rlTodoList = view.findViewById(R.id.rl_todo_list);
        rlDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ChooseTypeEvent(TYPE_DIARY));
                dismiss();
            }
        });
        rlTodoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ChooseTypeEvent(TYPE_TODO_LIST));
                dismiss();
            }
        });
        return view;
    }
}
