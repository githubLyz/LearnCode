package yujoo.lau.learncode.view.photoview.gestures;

/**
 * @author lew.liu
 * @date 2018/9/14
 * @description
 */
public interface OnGestureListener {
    void onDrag(float var1, float var2);

    void onFling(float var1, float var2, float var3, float var4);

    void onScale(float var1, float var2, float var3);
}
