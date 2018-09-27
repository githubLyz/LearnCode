package yujoo.lau.learncode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author lew.liu
 * @date 2018/6/28
 * @description  圆角遮罩，解决viewPager里面的图片在互动过程中出现的圆角变成直角的问题
 */

public class TBannerCornersShadow extends View {
    private Paint mWhitePaint;
    private Paint mChangePaint;

    private int cornerSize = 20;

    public TBannerCornersShadow(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TBannerCornersShadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TBannerCornersShadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }


    private void init(Context context, @Nullable AttributeSet attributeSet, int defStyleAttr) {
        mWhitePaint = new Paint();
        mWhitePaint.setColor(Color.RED);
        mWhitePaint.setAntiAlias(true);//消除锯齿
        mChangePaint = new Paint();
        mChangePaint.setColor(Color.RED);
        mChangePaint.setAntiAlias(true);//消除锯齿

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLeftTop(canvas);
        drawRightTop(canvas);
        drawLeftBottom(canvas);
        drawRightBottom(canvas);
    }


    private void drawLeftTop(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0, cornerSize);
        path.lineTo(0, 0);
        path.lineTo(cornerSize, 0);
        path.arcTo(new RectF(0, 0, cornerSize * 2, cornerSize * 2), -90, -90);
        path.close();
        canvas.drawPath(path, mChangePaint);
    }

    private void drawLeftBottom(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0, getHeight() - cornerSize);
        path.lineTo(0, getHeight());
        path.lineTo(cornerSize, getHeight());
        path.arcTo(new RectF(0, // x
                getHeight() - cornerSize * 2,// y
                cornerSize * 2,// x
                getHeight()// getWidth()// y
        ), 90, 90);
        path.close();
        canvas.drawPath(path, mWhitePaint);
    }

    private void drawRightBottom(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth() - cornerSize, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - cornerSize);
        RectF oval = new RectF(getWidth() - cornerSize * 2, getHeight()
                - cornerSize * 2, getWidth(), getHeight());
        path.arcTo(oval, 0, 90);
        path.close();
        canvas.drawPath(path, mWhitePaint);
    }

    private void drawRightTop(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth(), cornerSize);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth() - cornerSize, 0);
        path.arcTo(new RectF(getWidth() - cornerSize * 2, 0, getWidth(),
                cornerSize * 2), -90, 90);
        path.close();
        canvas.drawPath(path, mChangePaint);
    }

    public void draw(int color) {
        mChangePaint.setColor(color);
        invalidate();
    }
}
