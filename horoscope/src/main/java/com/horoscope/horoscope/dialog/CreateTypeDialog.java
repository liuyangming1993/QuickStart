package com.horoscope.horoscope.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.horoscope.horoscope.R;
import com.horoscope.horoscope.entity.event.AddTypeEvent;
import com.quickstart.baselib.base.BaseDialogFragment;

import org.greenrobot.eventbus.EventBus;

import static com.horoscope.horoscope.constant.Constant.TYPE_DIARY;
import static com.horoscope.horoscope.constant.Constant.TYPE_TODO_LIST;

public class CreateTypeDialog extends BaseDialogFragment {
    public static final String TYPE = "type";
    private int mType;
    private EditText mEt;


    public static CreateTypeDialog getCreateTypeDialog() {
        CreateTypeDialog dialog = new CreateTypeDialog();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.horoscope_dialog_create_type, container, false);
        mEt = view.findViewById(R.id.et_name);
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
                EventBus.getDefault().post(new AddTypeEvent(mEt.getText().toString(), mType));
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshArguments();
        setEtHint();
    }

    private void refreshArguments(){
        if (getArguments() != null) {
            mType = getArguments().getInt(TYPE);
        }
    }

    private void setEtHint() {
        mEt.setText("");
        if (mType == TYPE_DIARY) {
            mEt.setHint("diary名");
        }
        if (mType == TYPE_TODO_LIST) {
            mEt.setHint("todoList名");
        }
    }
}
