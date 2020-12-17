package com.boggle.wall.moudle.main.fragment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.boggle.wall.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path)
                .placeholder(getRandom())
                .skipMemoryCache(false)
                //缓存策略,硬盘缓存-仅仅缓存最终的图像，即降低分辨率后的（或者是转换后的）
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    private @DrawableRes
    int getRandom() {
        switch ((int) (( Math.random() * 100 + 1) % 10)) {
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
