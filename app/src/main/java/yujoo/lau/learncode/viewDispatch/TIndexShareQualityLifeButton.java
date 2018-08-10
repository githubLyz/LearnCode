package yujoo.lau.learncode.viewDispatch;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import yujoo.lau.learncode.R;


/**
 * @author lew.liu
 * @date 2018/7/26
 * @description 首页分享品质生活按钮
 */

public class TIndexShareQualityLifeButton extends RelativeLayout {
    private ImageView mBottomBg;
    private ImageView mAroundBg;
    private ImageView mAdd;
    private ImageView mBubble;
    private ImageView mCamera;
    private ImageView mPic;
    private TextView mTitle;
    private TIndexShareQualityAnimEndListener mAnimEndListener;

    public void setAnimEndListener(TIndexShareQualityAnimEndListener l) {
        mAnimEndListener = l;
    }

    public interface TIndexShareQualityAnimEndListener {
        void indexShareQualityAnimEnd();
    }

    public TIndexShareQualityLifeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.index_btn_share_qulity_life, this);
        initView();
    }

    public TIndexShareQualityLifeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.index_btn_share_qulity_life, this);
        initView();
    }



    private void initView() {
        mBottomBg = findViewById(R.id.iv_index_share_quality_life_bottom_bg);
        mAroundBg = findViewById(R.id.iv_index_share_quality_life_around);
        mAdd = findViewById(R.id.iv_index_share_quality_life_add);
        mBubble = findViewById(R.id.iv_index_share_quality_life_bubble);
        mCamera = findViewById(R.id.iv_index_share_quality_life_camera);
        mPic = findViewById(R.id.iv_index_share_quality_life_pic);
        mTitle = findViewById(R.id.tv_index_share_quality_life_title);
    }

    public void readyForAnim() {
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        //0~20帧的动画  同时执行，同时结束
        ObjectAnimator ivAddRotateAnim = ObjectAnimator.ofFloat(mAdd, "rotation", 0, 180).setDuration(1000);
        ivAddRotateAnim.setInterpolator(overshootInterpolator);
        ObjectAnimator ivBottomBgAlphaAnim = ObjectAnimator.ofFloat(mBottomBg, "alpha", 0.2f, 0).setDuration(500);
        ObjectAnimator ivBottomBgScaleX = ObjectAnimator.ofFloat(mBottomBg, "scaleX", 0, 1f).setDuration(1000);
        ivBottomBgScaleX.setInterpolator(overshootInterpolator);
        ObjectAnimator ivBottomBgScaleY = ObjectAnimator.ofFloat(mBottomBg, "scaleY", 0, 1f).setDuration(1000);
        ivBottomBgScaleY.setInterpolator(overshootInterpolator);
        ObjectAnimator ivAroundAlphaAnim = ObjectAnimator.ofFloat(mAroundBg, "alpha", 0, 1.0f).setDuration(1000);
        ObjectAnimator ivAroundScaleX = ObjectAnimator.ofFloat(mAroundBg, "scaleX", 0, 1f).setDuration(1000);
        ivAroundScaleX.setInterpolator(overshootInterpolator);
        ObjectAnimator ivAroundScaleY = ObjectAnimator.ofFloat(mAroundBg, "scaleY", 0, 1f).setDuration(1000);
        ivAroundScaleY.setInterpolator(overshootInterpolator);
        ObjectAnimator ivBubbleScaleX = ObjectAnimator.ofFloat(mBubble, "scaleX", 0, 1f).setDuration(1000);
        ivBubbleScaleX.setInterpolator(overshootInterpolator);
        ObjectAnimator ivBubbleScaleY = ObjectAnimator.ofFloat(mBubble, "scaleY", 0, 1f).setDuration(1000);
        ivBubbleScaleY.setInterpolator(overshootInterpolator);
        ObjectAnimator ivBubbleMove = ObjectAnimator.ofFloat(mBubble, "translationY", 0, -100f).setDuration(1000);
        ivBubbleMove.setInterpolator(overshootInterpolator);
        ObjectAnimator ivPicMove = ObjectAnimator.ofFloat(mPic, "translationY", 0, -100f).setDuration(1000);
        ObjectAnimator ivCameraMove = ObjectAnimator.ofFloat(mCamera, "translationY", 0, -100f).setDuration(1000);
        ObjectAnimator tvTitleMove = ObjectAnimator.ofFloat(mTitle, "translationY", 0, -100f).setDuration(1000);
        ObjectAnimator ivBubbleAppear = ObjectAnimator.ofFloat(mBubble, "alpha", 0, 1f).setDuration(0);
        animatorSet.play(ivAddRotateAnim).with(ivBottomBgAlphaAnim).with(ivBottomBgScaleX).with(ivBottomBgScaleY).with(ivAroundScaleX).with(ivAroundScaleX)
                .with(ivAroundAlphaAnim).with(ivAroundScaleY).with(ivBubbleScaleX).with(ivBubbleScaleY).with(ivBubbleMove).with(ivBubbleAppear)
                .with(ivPicMove).with(ivCameraMove).with(tvTitleMove);

        ObjectAnimator ivAroundAlphaDisappear = ObjectAnimator.ofFloat(mAroundBg, "alpha", 1.0f, 0).setDuration(666);
        animatorSet.play(ivAroundAlphaDisappear).after(ivAddRotateAnim);
        ObjectAnimator ivPicAppear = ObjectAnimator.ofFloat(mPic, "alpha", 0, 1f).setDuration(666);
        ObjectAnimator ivPicRotate = ObjectAnimator.ofFloat(mPic, "rotation", 0, 15).setDuration(666);
        animatorSet.play(ivPicAppear).with(ivPicRotate).after(ivAroundAlphaDisappear);
        //100~120帧
        ObjectAnimator ivPicRotateBack = ObjectAnimator.ofFloat(mPic, "rotation", 15, 0).setDuration(666);
        ObjectAnimator ivPicFinish = ObjectAnimator.ofFloat(mPic, "alpha", 1f, 0.5f).setDuration(666);
        animatorSet.play(ivPicRotateBack).with(ivPicFinish).after(ivPicAppear);
        //120~130抖动效果

        //130~150
        ObjectAnimator ivCameraRotate = ObjectAnimator.ofFloat(mCamera, "rotation", 0, 15).setDuration(666);
        ObjectAnimator ivCameraAppear = ObjectAnimator.ofFloat(mCamera, "alpha", 0, 1f).setDuration(666);
        animatorSet.play(ivCameraRotate).with(ivCameraAppear).after(ivPicRotateBack);

        //150~170
        ObjectAnimator ivCameraRotateBack = ObjectAnimator.ofFloat(mCamera, "rotation", 15, 0).setDuration(666);
        ObjectAnimator ivCameraFinish = ObjectAnimator.ofFloat(mCamera, "alpha", 1f, 0.5f).setDuration(666);
        animatorSet.play(ivCameraRotateBack).with(ivCameraFinish).after(ivCameraRotate);

        //170~180  抖动效果


        //180~190
        ObjectAnimator ivPicMoveToCenter = ObjectAnimator.ofFloat(mPic, "translationX", 0, 82f).setDuration(166);
        ObjectAnimator ivCameraToCenter = ObjectAnimator.ofFloat(mCamera, "translationX", 0, -82f).setDuration(166);
        ObjectAnimator ivCameraDisAppear = ObjectAnimator.ofFloat(mCamera, "alpha", 0.5f, 0).setDuration(166);
        ObjectAnimator ivPicDisAppear = ObjectAnimator.ofFloat(mPic, "alpha", 0.5f, 0).setDuration(166);
        animatorSet.play(ivPicMoveToCenter).with(ivCameraToCenter).with(ivCameraDisAppear).with(ivPicDisAppear).after(ivCameraRotateBack);

        //190~200
        ObjectAnimator ivTitleAppearAlpha = ObjectAnimator.ofFloat(mTitle, "alpha", 0, 1f).setDuration(0);
        ObjectAnimator ivTitleAppearWidth = ObjectAnimator.ofFloat(mTitle, "scaleX", 1f, 0).setDuration(0);
        ObjectAnimator ivTitleAppearHeight = ObjectAnimator.ofFloat(mTitle, "scaleY", 1f, 0).setDuration(0);
        ObjectAnimator ivTitleScaleX = ObjectAnimator.ofFloat(mTitle, "scaleX", 0, 1f).setDuration(666);
        ivTitleScaleX.setInterpolator(overshootInterpolator);
        ObjectAnimator ivTitleScaleY = ObjectAnimator.ofFloat(mTitle, "scaleY", 0, 1f).setDuration(666);
        ivTitleScaleY.setInterpolator(overshootInterpolator);

        animatorSet.play(ivTitleAppearAlpha).with(ivTitleScaleX).with(ivTitleScaleY).with(ivTitleAppearWidth).with(ivTitleAppearHeight).after(ivPicMoveToCenter);
        ObjectAnimator ivBubbleGone = ObjectAnimator.ofFloat(mBubble, "alpha", 1f, 0).setDuration(0);
        ObjectAnimator tvTitleGone = ObjectAnimator.ofFloat(mTitle, "alpha", 1f, 0).setDuration(0);
        animatorSet.play(ivBubbleGone).with(tvTitleGone).after(8000);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimEndListener.indexShareQualityAnimEnd();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
