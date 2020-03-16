package com.lym.testmodule;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.quickstart.baselib.util.ImageHelper;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImageView iv = findViewById(R.id.iv);
        ImageHelper.show(this, "https://raw.githubusercontent.com/liuyangming1993/BlogPic/master/1.png", iv);
    }
}
