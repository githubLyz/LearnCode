package yujoo.lau.learncode.gesture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;
import yujoo.lau.learncode.view.TRecyclerViewLoadMoreView;

/**
 * @author lew.liu
 * @date 2018/9/10
 * @description
 */
public class TGestureImageViewActivity extends TBaseActivity {
    private int[] drawables = new int[]{R.mipmap.page_three, R.mipmap.page_four};
    private RelativeLayout mRelativeLayout;
    private THorizontalScrollView tHorizontalScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_image, false, false);
    }


    @Override
    protected void initView() {
//        tHorizontalScrollView=findViewById(R.id.scrollView);
        TRecyclerView recyclerView = findViewById(R.id.rv_immersion);
//        mRelativeLayout = findViewById(R.id.rl_immersion_content);
        TRecyclerViewLoadMoreView recyclerViewLoadMoreView = findViewById(R.id.view_load_more);
        recyclerView.setLoadMoreView(recyclerViewLoadMoreView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLinearLayoutManager(linearLayoutManager);
        recyclerView.setTImmersionAdapter(new TImmersionAdapter(this, drawables));
        PagerSnapHelper page = new PagerSnapHelper();
        page.attachToRecyclerView(recyclerView);
    }
}
