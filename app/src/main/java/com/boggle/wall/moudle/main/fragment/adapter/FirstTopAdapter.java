package com.boggle.wall.moudle.main.fragment.adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.boggle.wall.R;
import com.boggle.wall.entity.DataEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class FirstTopAdapter extends BaseQuickAdapter<DataEntity, BaseViewHolder> {

    public FirstTopAdapter(int layoutResId, @Nullable List<DataEntity> data, int width) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, DataEntity item) {
        ((ShimmerLayout) helper.getView(R.id.sl_all)).setShimmerColor(0x55FFFFFF);
        ((ShimmerLayout) helper.getView(R.id.sl_all)).setShimmerAngle(0);
        ((ShimmerLayout) helper.getView(R.id.sl_all)).startShimmerAnimation();

        Glide.with(mContext).load(item.getWebformatURL())
                .placeholder(getRandom())
                .skipMemoryCache(false)
                //缓存策略,硬盘缓存-仅仅缓存最终的图像，即降低分辨率后的（或者是转换后的）
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        ((ShimmerLayout) helper.getView(R.id.sl_all)).stopShimmerAnimation();
                        return false;
                    }
                })
                .into((ImageView) helper.getView(R.id.action_image));
    }

    private @DrawableRes
    int getRandom() {
        switch ((int) ((Math.random() * 100 + 1) % 10)) {
            case 1:
                return R.drawable.bg_one;
            case 2:
                return R.drawable.bg_two;
            case 3:
                return R.drawable.bg_three;
            case 4:
                return R.drawable.bg_four;
            case 5:
                return R.drawable.bg_fiver;
            case 6:
                return R.drawable.bg_six;
            case 7:
                return R.drawable.bg_seven;
            case 8:
                return R.drawable.bg_eight;
            case 9:
                return R.drawable.bg_nice;
            case 0:
                return R.drawable.bg_ten;
            default:
                return R.drawable.bg_six;

        }
    }
}
