package yujoo.lau.learncode.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import liu.lew.to8to.com.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;

/**
 * @author lew.liu
 * @date 2018/7/14
 * @description 事件分发以及拦截
 */

public class TDispatchTouchEventActivity extends TBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_event, false, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
