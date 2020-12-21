package com.boggle.wall.moudle.main.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.boggle.wall.R;
import com.boggle.wall.entity.DataEntity;
import com.boggle.wall.moudle.weight.HIndicators;
import com.boggle.wall.utils.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class HorizontalViewAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {

    private LayoutHelper mLayoutHelper;
    private int mCount = -1;
    private int mLayoutId = -1;
    private Context mContext;
    private int mViewTypeItem = -1;
    private List<DataEntity> list;

    public HorizontalViewAdapter(LayoutHelper mLayoutHelper, int mCount, int mLayoutId, Context mContext, int mViewTypeItem, List<DataEntity> list) {
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
    public void onBindViewHolder(@NonNull final BaseViewHolder holder, int position) {
        FirstTopAdapter firstTopAdapter = new FirstTopAdapter(R.layout.item_home_grid, list, ScreenUtils.getScreenHeight(mContext));
        RecyclerView rvAll = holder.getView(R.id.rv_all);
        HIndicators hIndicator = holder.getView(R.id.hi_dicators);
        rvAll.setAdapter(firstTopAdapter);
        hIndicator.bindRecyclerView(rvAll);
        hIndicator.setIndicatorColor(Color.parseColor("#8DB5F8"));
        hIndicator.setBgColor(Color.parseColor("#E6E6E6"));
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    @Override
    public int getItemViewType(int position) {
        return 3;
    }
}
