package yujoo.lau.learncode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

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

    /**
     *
     * @param ev
     * @return true:表示改事件在本层不再进行分发且已经在事件分发自身中被消费了。至此，事件已经完结（不见了，被搁浅了）。(Actvitiy\View\ViewGroup都是)
     *         false:，表明事件在本层不再继续进行分发，并交由上层控件的onTouchEvent方法进行消费。
     *         (如果是Activity的dispatchTouchEvent，那么Touch将被系统消费或处理。如果是ViewGroup的dispatchTouchEvent，
     *         那么Touch交给Activity的onTouchEvent方法处理，
     *         如果是View的dispatchTouchEvent，Touch交给ViewGroup的onTouchEvevt()方法处理。)
     *         super: 返回默认super.dispatchTouchEvent(ev) ，事件将分发给本层的事件拦截onInterceptTouchEvent 方法进行处理。
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TLayout", "dispatchTouchEvent");
        return false;
    }

    /**
     *
     * @param ev
     * @return true:表示将事件进行拦截，并将拦截到的事件交由本层控件 的 onTouchEvent 进行处理。
     *         返回false或是onInterceptTouchEvent(ev)时，则表示不对事件进行拦截，事件得以成功分发到子View，
     *         并由子View的dispatchTouchEvent进行处理。（）
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("TLayout", "onInterceptTouchEvent");
        return true;
    }

    /**
     *
     * @param event
     * @return 返回false或是onInterceptTouchEvent(ev)时事件在onTouchEvent中处理后继续向上层View冒泡，
     *              且有上层View的onTouchEvent进行处理。如果上层在不处理，在往上冒。一直到被处理为止
     *        返回true时，表示这层onTouchEvent处理完事件后消费了此次事件。此时事件终结，将不会进行后续的冒泡。
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TLayout", "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
