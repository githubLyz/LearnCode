package yujoo.lau.learncode.view.photoview.scrollerproxy;

import android.content.Context;
import android.widget.OverScroller;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public class GingerScroller extends ScrollerProxy {
    protected final OverScroller mScroller;
    private boolean mFirstScroll = false;

    public GingerScroller(Context context) {
        this.mScroller = new OverScroller(context);
    }

    public boolean computeScrollOffset() {
        if (this.mFirstScroll) {
            this.mScroller.computeScrollOffset();
            this.mFirstScroll = false;
        }

        return this.mScroller.computeScrollOffset();
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        this.mScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, overX, overY);
    }

    public void forceFinished(boolean finished) {
        this.mScroller.forceFinished(finished);
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }
}
