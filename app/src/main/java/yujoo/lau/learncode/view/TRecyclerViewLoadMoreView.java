package yujoo.lau.learncode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static yujoo.lau.learncode.gesture.TRecyclerView.dpToPx;

/**
 * @author lew.liu
 * @date 2018/9/30
 * @description
 */
public class TRecyclerViewLoadMoreView extends View {
    private Point mControlPoint;
    private Paint mPaint;
    private Path mPath;
    private Rect mRect;
    private float mLastX;
    private float mDeltaX;
    private float startX, startY;
    private float mLeft;
    private float mDistance;
    private float mTop;
    private float mBottom;
    private int mLoadViewWidth;

    public TRecyclerViewLoadMoreView(Context context) {
        super(context);
        init(context, null, 0);

    }

    public TRecyclerViewLoadMoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);

    }

    public TRecyclerViewLoadMoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mControlPoint = new Point();
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#eeeeee"));
        mRect = new Rect();
        mPath = new Path();
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);
        mLoadViewWidth = dpToPx(context, 80);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mLastX = event.getRawX();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mDeltaX = (event.getRawX() - mLastX);
//                mLastX = event.getRawX();
//                if (mDeltaX > 0) {//右滑
//                    invalidate();
//                } else {//左滑
//                    getDrawingRect(mRect);
//                    mControlPoint.x = (int) (event.getRawX());
//                    mControlPoint.y = mRect.bottom / 2;
//                    invalidate();
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                getDrawingRect(mRect);
//                mControlPoint.x = mRect.right;
//                mControlPoint.y = mRect.bottom / 2;
//                invalidate();
//                break;
//
//        }
//        return true;
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        //起点
        mPath.moveTo(mRect.right, mRect.top);
        //mPath
        mPath.quadTo(mControlPoint.x, mControlPoint.y, mRect.right, mRect.bottom);
        //画path
        canvas.drawPath(mPath, mPaint);
        Log.e("invalidate", "invalidate");

    }

    public void reDraw(float distance) {
        getDrawingRect(mRect);
        mControlPoint.x = (int) (mRect.right- distance);
        Log.e("x",mControlPoint.x+"");
        Log.e("distance",distance+"");
        mControlPoint.y = mRect.bottom / 2;
//
//        Log.e("left", mRect.left + "");
        Log.e("right", mRect.right + "");
//        Log.e("top", mRect.top + "");
//        Log.e("bottom", mRect.bottom + "");
//        Log.e("mDistance", mDistance + "");
        mControlPoint.y = mRect.bottom / 2;
        invalidate();
    }
}
