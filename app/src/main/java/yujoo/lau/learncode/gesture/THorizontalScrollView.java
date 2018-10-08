package yujoo.lau.learncode.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import yujoo.lau.learncode.R;

/**
 * @author lew.liu
 * @date 2018/10/8
 * @description
 */
public class THorizontalScrollView extends HorizontalScrollView {
    private static final float RATIO = 0.5f;
    private static final float RATIO_OFFSET = 2.0f;

    private float mDeltaX;
    private float mLastX;
    private int mOffset;



    private Paint mPaint;
    private Path mPath;
    private Rect mRect;
    private Point mControlPoint;
    private Scroller mScroller;



    public THorizontalScrollView(Context context) {
        super(context);
    }

    public THorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public THorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        mScroller = new Scroller(context);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#eeeeee"));
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mPath = new Path();
        mRect = new Rect();
        mControlPoint = new Point();

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            mLastX = ev.getRawX();
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                mDeltaX = (ev.getRawX() - mLastX);
                mLastX = ev.getRawX();
                mDeltaX = mDeltaX * RATIO;
                if (mDeltaX > 0) {
                    getDrawingRect(mRect);
                    mControlPoint.x=mRect.left;
                    mControlPoint.y=mRect.bottom/2;
                    invalidate();
                }


                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        //起点
        mPath.moveTo(1000, mRect.top);
        //mPath
        mPath.quadTo(900, mControlPoint.y, 1000, mRect.bottom);
        //画path
        canvas.drawPath(mPath, mPaint);
    }


}
