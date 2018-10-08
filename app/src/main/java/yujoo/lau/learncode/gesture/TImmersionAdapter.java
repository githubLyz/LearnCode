package yujoo.lau.learncode.gesture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.rong.photoview.PhotoView;
import yujoo.lau.learncode.R;
import yujoo.lau.learncode.view.TRecyclerViewLoadMoreView;

/**
 * @author lew.liu
 * @date 2018/9/27
 * @description
 */
public class TImmersionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private int[] mDrawables;
    private final int NORMAL_TYPE = 1;
    private final int LOAD_MORE_TYPE = -1;

    public TImmersionAdapter(Context mContext, int[] drawables) {
        this.mContext = mContext;
        this.mDrawables = drawables;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (NORMAL_TYPE == viewType) {
            return new ImageHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_immersion_pic, parent, false));
        } else {
            return new LoadMoreHolder(LayoutInflater.from(mContext).inflate(R.layout.immersion_load_more, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (NORMAL_TYPE == getItemViewType(position)) {
            ImageHolder imageHolder = (ImageHolder) holder;
            Glide.with(mContext).asBitmap().load(mDrawables[position]).into(imageHolder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mDrawables.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mDrawables.length) {
            return LOAD_MORE_TYPE;
        } else {
            return NORMAL_TYPE;
        }
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        PhotoView mImageView;
        ImageHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_immersion);
        }
    }

    class LoadMoreHolder extends RecyclerView.ViewHolder {
        public TRecyclerViewLoadMoreView tRecyclerViewLoadMoreView;
        LoadMoreHolder(View itemView) {
            super(itemView);
            tRecyclerViewLoadMoreView=itemView.findViewById(R.id.view_load_more);
        }
    }
}
