package yujoo.lau.learncode.viewDispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;

import yujoo.lau.learncode.utils.TLog;

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
        TLog.e( "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                TLog.e("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                TLog.e( "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                TLog.e( "ACTION_MOVE");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
