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
    private float mDistance;

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
        mPaint.setColor(Color.parseColor("#1d1d1d"));
        mRect = new Rect();
        mPath = new Path();
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        //起点
        mPath.moveTo(mDistance, mRect.top);
        //mPath
        mPath.quadTo(-mDistance, mControlPoint.y, mDistance, mRect.bottom);
        //画path
        canvas.drawPath(mPath, mPaint);
    }

    public void reDraw(float distance) {
        getDrawingRect(mRect);
        mDistance=distance;
        mControlPoint.y = mRect.bottom / 2;
        invalidate();
    }
}
