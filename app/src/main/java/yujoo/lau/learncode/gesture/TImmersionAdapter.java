package yujoo.lau.learncode.gesture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import yujoo.lau.learncode.R;
import yujoo.lau.learncode.view.photoview.PhotoView;

/**
 * @author lew.liu
 * @date 2018/9/27
 * @description
 */
public class TImmersionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private int[] mDrawables;

    public TImmersionAdapter(Context mContext, int[] drawables) {
        this.mContext = mContext;
        this.mDrawables = drawables;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_immersion_pic, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageHolder imageHolder = (ImageHolder) holder;
        imageHolder.mImageView.setImageDrawable(mContext.getResources().getDrawable(mDrawables[position]));
    }

    @Override
    public int getItemCount() {
        return mDrawables.length;
    }

    private class ImageHolder extends RecyclerView.ViewHolder {
        private PhotoView mImageView;

        ImageHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_immersion);
        }
    }
}
