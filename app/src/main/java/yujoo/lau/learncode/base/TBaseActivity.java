package yujoo.lau.learncode.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author lew.liu
 * @date 2018/7/2
 */

public abstract class TBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /**
     * 快捷模式
     *
     * @param layoutResID          布局文件id
     * @param navigationBarEnabled 是否启用默认导航栏
     * @param dark                 是否开启白底黑字模式
     */
    public void setContentView(int layoutResID, boolean navigationBarEnabled, boolean dark) {
        super.setContentView(layoutResID);
        initView();
    }

    protected abstract void initView();
}
