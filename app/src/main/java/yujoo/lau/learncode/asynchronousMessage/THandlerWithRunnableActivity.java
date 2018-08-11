package yujoo.lau.learncode.asynchronousMessage;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;
import yujoo.lau.learncode.utils.TLog;

/**
 * @author LEW.LIU
 * @date 2018/8/7
 * @description  handler使用runnable进行异步操作   handler.post(Runnable r)
 */

public class THandlerWithRunnableActivity extends TBaseActivity implements View.OnClickListener {

    private TextView mDownloadProgress;
    private Handler mUiHandler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler, false, false);
        TLog.e("当前线程id:" + Thread.currentThread().getId());

    }

    @Override
    protected void initView() {
        mDownloadProgress = findViewById(R.id.tv_handler_download_progress);
        findViewById(R.id.btn_handler_download).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_handler_download:
                DownloadThread downloadThread = new DownloadThread();
                downloadThread.start();
                TLog.e("点击下载按钮");

                break;
        }

    }


    class DownloadThread extends Thread {
        @Override
        public void run() {
            try {
                TLog.e("当前线程id:" + Thread.currentThread().getId());
                TLog.e("开始下载文件");
                Thread.sleep(5000);
                TLog.e("文件下载完成");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        TLog.e("当前线程id:" + Thread.currentThread().getId());
                        mDownloadProgress.setText("下载完成");
                    }
                };
                mUiHandler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUiHandler.removeCallbacksAndMessages(null);
    }
}
