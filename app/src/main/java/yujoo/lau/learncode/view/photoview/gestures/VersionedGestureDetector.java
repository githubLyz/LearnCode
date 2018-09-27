package yujoo.lau.learncode.view.photoview.gestures;

import android.content.Context;
import android.os.Build;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public final class VersionedGestureDetector {
    public VersionedGestureDetector() {
    }

    public static TGestureDetector newInstance(Context context, OnGestureListener listener) {
        int sdkVersion = Build.VERSION.SDK_INT;
        Object detector;
        if (sdkVersion < 5) {
            detector = new CupcakeGestureDetector(context);
        } else if (sdkVersion < 8) {
            detector = new EclairGestureDetector(context);
        } else {
            detector = new FroyoGestureDetector(context);
        }

        ((TGestureDetector)detector).setOnGestureListener(listener);
        return (TGestureDetector)detector;
    }
}
