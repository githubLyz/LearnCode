package yujoo.lau.learncode.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author lew.liu
 * @date 2018/7/14
 * @description 事件分发View
 */

public class TView extends View {

    public TView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TView", "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TView", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TView", "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TView", "ACTION_MOVE");
                break;
        }


        return super.onTouchEvent(event);
    }
}
