package yujoo.lau.learncode.gesture;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.view.TRecyclerViewLoadMoreView;

/**
 * @author lew.liu
 * @date 2018/10/8
 * @description
 */
public class TRecyclerView extends RecyclerView implements RecyclerView.OnItemTouchListener {
    private LinearLayoutManager mLinearLayoutManager;
    private TImmersionAdapter mTImmersionAdapter;
    private TRecyclerViewLoadMoreView mRecyclerViewLoadMoreView;
    private float mDownX;
    private int mLoadViewWidth;

    public TRecyclerView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        addOnItemTouchListener(this);
        mLoadViewWidth = dpToPx(context, 80);
    }

    public void setTImmersionAdapter(TImmersionAdapter adapter) {
        this.setAdapter(adapter);
        this.mTImmersionAdapter = adapter;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        setLayoutManager(linearLayoutManager);
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void setLoadMoreView(TRecyclerViewLoadMoreView tRecyclerViewLoadMoreView) {
//        View view = mLinearLayoutManager.findViewByPosition(mTImmersionAdapter.getItemCount()-1);
//        TImmersionAdapter.LoadMoreHolder viewHolder = (TImmersionAdapter.LoadMoreHolder) findViewHolderForAdapterPosition(mTImmersionAdapter.getItemCount() - 1);
//        if (viewHolder != null) {
//            mRecyclerViewLoadMoreView = viewHolder.tRecyclerViewLoadMoreView;
//
//        }
        mRecyclerViewLoadMoreView = tRecyclerViewLoadMoreView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        return super.dispatchTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (mLinearLayoutManager.findFirstVisibleItemPosition() == mTImmersionAdapter.getItemCount() - 2) {
            onTouchEvent(rv, e);
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = e.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float currentX = e.getX();
                if (mDownX > currentX) {
                    float distance = mDownX - currentX;
                    if (distance > mLoadViewWidth) {
                        distance = mLoadViewWidth;
                    }
                    if (mRecyclerViewLoadMoreView != null) {
                        mRecyclerViewLoadMoreView.reDraw(distance);
                    }
                }

                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:

                break;

        }
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public static int dpToPx(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
