package yujoo.lau.learncode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import yujoo.lau.learncode.animation.TIndexShareQualityPropertyAnimationActivity;
import yujoo.lau.learncode.base.Person;
import yujoo.lau.learncode.cornershadow.TCornersShadowActivity;
import yujoo.lau.learncode.event.TDispatchTouchEventActivity;
import yujoo.lau.learncode.asynchronousMessage.THandlerWithMessageActivity;
import yujoo.lau.learncode.asynchronousMessage.THandlerWithRunnableActivity;
import yujoo.lau.learncode.gesture.TGestureImageViewActivity;

public class TMainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initNet();
    }

    private void initNet() {
//        Person.Builder builder=new Person.Builder();
//        Person person=builder.name().age().height().weight()
    }

    private void initView() {
        findViewById(R.id.btn_corners_shadow).setOnClickListener(this);
        findViewById(R.id.btn_property_animation).setOnClickListener(this);
        findViewById(R.id.btn_dispatch_event).setOnClickListener(this);
        findViewById(R.id.btn_handler_runnable).setOnClickListener(this);
        findViewById(R.id.btn_handler_message).setOnClickListener(this);
        findViewById(R.id.btn_gesture_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_corners_shadow:
                intent.setClass(mContext, TCornersShadowActivity.class);
                break;
            case R.id.btn_property_animation:
                intent.setClass(mContext, TIndexShareQualityPropertyAnimationActivity.class);
                break;
            case R.id.btn_dispatch_event:
                intent.setClass(mContext, TDispatchTouchEventActivity.class);
                break;
            case R.id.btn_handler_runnable:
                intent.setClass(mContext, THandlerWithRunnableActivity.class);
                break;
            case R.id.btn_handler_message:
                intent.setClass(mContext, THandlerWithMessageActivity.class);
                break;
            case R.id.btn_gesture_image:
                intent.setClass(mContext, TGestureImageViewActivity.class);
                break;
        }
        startActivity(intent);
    }
}
