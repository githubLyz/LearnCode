package yujoo.lau.learncode.gesture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.widget.TextView;

import org.w3c.dom.Text;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.base.TBaseActivity;

/**
 * @author lew.liu
 * @date 2018/9/10
 * @description
 */
public class TGestureImageViewActivity extends TBaseActivity {
    private int[] drawables = new int[]{R.mipmap.page_three, R.mipmap.page_four};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_image, false, false);
    }


    @Override
    protected void initView() {
        TRecyclerView recyclerView = findViewById(R.id.rv_immersion);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLinearLayoutManager(linearLayoutManager);
        recyclerView.setTImmersionAdapter(new TImmersionAdapter(this, drawables));
        PagerSnapHelper page = new PagerSnapHelper();
        page.attachToRecyclerView(recyclerView);
    }
}
