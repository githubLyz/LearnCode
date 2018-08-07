package yujoo.lau.learncode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * @author lew.liu
 * @date 2018/7/14
 * @description  事件分发ViewGroup
 */

public class TLayout extends FrameLayout {
    public TLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("TLayout", "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TLayout", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
}
