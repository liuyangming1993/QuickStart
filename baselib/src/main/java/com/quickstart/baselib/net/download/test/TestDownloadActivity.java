package com.quickstart.baselib.net.download.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quickstart.baselib.R;
import com.quickstart.baselib.net.download.DownloadManager;

public class TestDownloadActivity extends AppCompatActivity implements DownloadManager.ProgressListener {

    private ProgressBar pb_progress;
    private TextView tv_progress;
    private DownloadManager downloadManager;
    private int i = 0;
    private Button btn_pasuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_download);

        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
        tv_progress = (TextView) findViewById(R.id.tv_progress);
        btn_pasuse = (Button) findViewById(R.id.btn_pasuse);

        downloadManager = DownloadManager.getInstance().setOutFileInfo("/storage/emulated/0/Download/yaoshi.mp4");
        downloadManager.setProgressListener(this);
    }

    /**
     * 点击开始下载
     */
    public void start(View view) {
        downloadManager.start("https://bignoxtest.oss-cn-beijing.aliyuncs.com/mis-reminder/1576829883576-aa701d8a-3ee7-41ca.mp4");
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
