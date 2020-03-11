package com.lym.testmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quickstart.baselib.net.download.DownloadManager;

public class DownloadActivity extends AppCompatActivity implements DownloadManager.ProgressListener {

    private ProgressBar pb_progress;
    private TextView tv_progress;
    private DownloadManager downloadManager;
    private int i = 0;
    private Button btn_pasuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        pb_progress = findViewById(R.id.pb_progress);
        tv_progress = findViewById(R.id.tv_progress);
        btn_pasuse = findViewById(R.id.btn_pasuse);

        downloadManager = DownloadManager.getInstance().setOutFileInfo("/storage/emulated/0/Download/AndroidManifest.xml");
        downloadManager.setProgressListener(this);
    }

    /**
     * 点击开始下载
     */
    public void start(View view) {
        downloadManager.start("https://raw.githubusercontent.com/liuyangming1993/QuickStart/master/app/src/main/AndroidManifest.xml");
    }

    /**
     * 点击暂停下载或继续下载
     */
    public void pasuse(View view) {
        if (i % 2 == 0) {
            downloadManager.pause();
            btn_pasuse.setText("继续下载");
        } else {
            downloadManager.reStart();
            btn_pasuse.setText("暂停下载");
        }
        i++;
    }

    /**
     * 进度回调接口
     */
    @Override
    public void progressChanged(long read, long contentLength, boolean done) {
        final int progress = (int) (100 * read / contentLength);
        pb_progress.setProgress(progress);
        tv_progress.setText(progress + "%");
    }
}
