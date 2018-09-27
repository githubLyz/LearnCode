package yujoo.lau.learncode.view.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public abstract class ScrollerProxy {
    public ScrollerProxy() {
    }

    public static ScrollerProxy getScroller(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return new PreGingerScroller(context);
        } else {
            return (ScrollerProxy)(Build.VERSION.SDK_INT < 14 ? new GingerScroller(context) : new IcsScroller(context));
        }
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public abstract void forceFinished(boolean var1);

    public abstract boolean isFinished();

    public abstract int getCurrX();

    public abstract int getCurrY();
}
