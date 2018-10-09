package yujoo.lau.learncode.gesture;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;
import yujoo.lau.learncode.view.TImmersionDivider;
import yujoo.lau.learncode.view.TUpGlideViewPager;

/**
 * @author lew.liu
 * @date 2018/9/10
 * @description
 */
public class TGestureImageViewActivity extends TBaseActivity {
    private int[] drawables = new int[]{R.mipmap.page_one, R.mipmap.page_two, R.mipmap.page_three, R.mipmap.page_four};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_image, false, false);
    }


    @Override
    protected void initView() {
//        TUpGlideViewPager tUpGlideViewPager = findViewById(R.id.vp_gesture_image);
//        tUpGlideViewPager.setAdapter(new TFragmentAdapter(getSupportFragmentManager()));
        RecyclerView recyclerView = findViewById(R.id.recycle_view_immersion);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new TImmersionAdapter(this, drawables));
        new PagerSnapHelper().attachToRecyclerView(recyclerView);

    }
}
