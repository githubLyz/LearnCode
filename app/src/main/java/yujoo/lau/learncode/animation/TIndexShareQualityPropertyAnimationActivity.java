package yujoo.lau.learncode.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import liu.lew.to8to.com.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;
import yujoo.lau.learncode.view.TIndexShareQualityLifeButton;

/**
 * @author lew.liu
 * @date 2018/6/29
 * @description 属性动画
 */

public class TIndexShareQualityPropertyAnimationActivity extends TBaseActivity implements TIndexShareQualityLifeButton.TIndexShareQualityAnimEndListener {
    private View mViewGreen;
    private View mViewBlue;
    private TIndexShareQualityLifeButton mIndexShareQualityLifeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation,false,false);
    }

    @Override
    protected void initView() {
//        mViewGreen = findViewById(R.id.rl_property_anim_green);
//        mViewBlue = findViewById(R.id.rl_property_anim_blue);
        mIndexShareQualityLifeButton = findViewById(R.id.btn_index_share_quality_life);
        mIndexShareQualityLifeButton.setAnimEndListener(this);
        mIndexShareQualityLifeButton.readyForAnim();
//        findViewById(R.id.btn_property_object_anim).setOnClickListener(this);
//        findViewById(R.id.btn_property_value_anim).setOnClickListener(this);
//        findViewById(R.id.btn_shake_anim).setOnClickListener(this);
    }

    /**
     * 属性动画  ObjectAnimator
     */
    private void objectAnimator() {
        ObjectAnimator.ofFloat(mViewBlue, "translationX", 0.0f, 350.0f, 0f).setDuration(2500).start();
    }

    /**
     * 属性动画 ValueAnimator
     */
    private void valueAnimator() {

        ValueAnimator animator = ValueAnimator.ofInt(500);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mViewGreen.setX(value);
            }
        });
        animator.start();

    }

    @Override
    public void indexShareQualityAnimEnd() {
        finish();
    }
}
