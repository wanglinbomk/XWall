package com.boggle.wall.moudle.main.fragment.adapter;

import android.content.Context;
import android.graphics.Outline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.boggle.wall.R;
import com.boggle.wall.utils.ScreenUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

public class BannerAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {

    private LayoutHelper mLayoutHelper;
    private int mCount = -1;
    private int mLayoutId = -1;
    private Context mContext;
    private int mViewTypeItem = -1;
    private List<String> list;

    public BannerAdapter(LayoutHelper mLayoutHelper, int mCount, int mLayoutId, Context mContext, int mViewTypeItem, List<String> list) {
        this.mLayoutHelper = mLayoutHelper;
        this.mCount = mCount;
        this.mLayoutId = mLayoutId;
        this.mContext = mContext;
        this.mViewTypeItem = mViewTypeItem;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == mViewTypeItem) {
            return new BaseViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Banner adBanner = ((Banner) holder.itemView.findViewById(R.id.ad_banner));
        adBanner.setClipToOutline(true);
        adBanner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20);
            }
        });
        adBanner.setLayoutParams(ScreenUtils.getBannerParams(adBanner, adBanner.getContext()));
        adBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        adBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        adBanner.setImageLoader(new GlideImageLoader());
        adBanner.setImages(list);
        adBanner.isAutoPlay(true);
        adBanner.setDelayTime(4000);
        adBanner.start();
        adBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    @Override
    public int getItemViewType(int position) {
        return mViewTypeItem;
    }
}
