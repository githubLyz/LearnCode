package yujoo.lau.learncode.view.photoview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import yujoo.lau.learncode.view.photoview.PhotoViewAttacher.OnMatrixChangedListener;
import yujoo.lau.learncode.view.photoview.PhotoViewAttacher.OnPhotoTapListener;
import yujoo.lau.learncode.view.photoview.PhotoViewAttacher.OnScaleChangeListener;
import yujoo.lau.learncode.view.photoview.PhotoViewAttacher.OnSingleFlingListener;
import yujoo.lau.learncode.view.photoview.PhotoViewAttacher.OnViewTapListener;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public interface IPhotoView {
    float DEFAULT_MAX_SCALE = 3.0F;
    float DEFAULT_MID_SCALE = 1.75F;
    float DEFAULT_MIN_SCALE = 1.0F;
    int DEFAULT_ZOOM_DURATION = 200;

    boolean canZoom();

    RectF getDisplayRect();

    boolean setDisplayMatrix(Matrix var1);

    Matrix getDisplayMatrix();

    void getDisplayMatrix(Matrix var1);

    /** @deprecated */
    @Deprecated
    float getMinScale();

    float getMinimumScale();

    /** @deprecated */
    @Deprecated
    float getMidScale();

    float getMediumScale();

    /** @deprecated */
    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getScale();

    ImageView.ScaleType getScaleType();

    void setAllowParentInterceptOnEdge(boolean var1);

    /** @deprecated */
    @Deprecated
    void setMinScale(float var1);

    void setMinimumScale(float var1);

    /** @deprecated */
    @Deprecated
    void setMidScale(float var1);

    void setMediumScale(float var1);

    /** @deprecated */
    @Deprecated
    void setMaxScale(float var1);

    void setMaximumScale(float var1);

    void setScaleLevels(float var1, float var2, float var3);

    void setOnLongClickListener(View.OnLongClickListener var1);

    void setOnMatrixChangeListener(OnMatrixChangedListener var1);

    void setOnPhotoTapListener(OnPhotoTapListener var1);

   OnPhotoTapListener getOnPhotoTapListener();

    void setOnViewTapListener(OnViewTapListener var1);

    void setRotationTo(float var1);

    void setRotationBy(float var1);

    OnViewTapListener getOnViewTapListener();

    void setScale(float var1);

    void setScale(float var1, boolean var2);

    void setScale(float var1, float var2, float var3, boolean var4);

    void setScaleType(ImageView.ScaleType var1);

    void setZoomable(boolean var1);

    /** @deprecated */
    void setPhotoViewRotation(float var1);

    Bitmap getVisibleRectangleBitmap();

    void setZoomTransitionDuration(int var1);

    IPhotoView getIPhotoViewImplementation();

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener var1);

    void setOnScaleChangeListener(OnScaleChangeListener var1);

    void setOnSingleFlingListener(OnSingleFlingListener var1);
}
