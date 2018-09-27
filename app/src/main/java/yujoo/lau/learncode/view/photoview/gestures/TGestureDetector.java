package yujoo.lau.learncode.view.photoview.gestures;

import android.view.MotionEvent;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public interface TGestureDetector {
    boolean onTouchEvent(MotionEvent var1);

    boolean isScaling();

    boolean isDragging();

    void setOnGestureListener(OnGestureListener var1);
}
