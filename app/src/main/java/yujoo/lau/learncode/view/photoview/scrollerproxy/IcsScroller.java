package yujoo.lau.learncode.view.photoview.scrollerproxy;

import android.content.Context;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}

