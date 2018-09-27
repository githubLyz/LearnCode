package yujoo.lau.learncode.gesture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import yujoo.lau.learncode.R;
import yujoo.lau.learncode.view.photoview.PhotoView;

/**
 * @author lew.liu
 * @date 2018/9/5
 * @description 沉浸式美图图片载体fragment
 */
public class TImmersionFragment extends Fragment {


    protected static Fragment newInstance(int drawable ) {
        TImmersionFragment fragment = new TImmersionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("drawable", drawable);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_immersion_pic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PhotoView tGestureImageView = view.findViewById(R.id.iv_immersion);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int drawable = bundle.getInt("drawable");
            tGestureImageView.setImageDrawable(getResources().getDrawable(drawable));
        }
    }
}
