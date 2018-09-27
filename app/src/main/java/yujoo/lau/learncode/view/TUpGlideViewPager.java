package yujoo.lau.learncode.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * @author lew.liu
 * @date 2018/9/7
 * @description 沉浸式列表页ViewPager 当放大图片时，拦截左右滑动
 */
public class TUpGlideViewPager extends ViewPager {

    public TUpGlideViewPager(Context context) {
        super(context);
    }

    public TUpGlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }


    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {

        super.onPageScrolled(position, offset, offsetPixels);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        super.onLayout(changed, l, t, r, b);
    }
}

