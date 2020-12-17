package com.boggle.wall.moudle.main.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.boggle.wall.R;
import com.boggle.wall.entity.TitleEntity;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class HeadTitleAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {

    private LayoutHelper mLayoutHelper;
    private int mCount = -1;
    private int mLayoutId = -1;
    private Context mContext;
    private int mViewTypeItem = -1;
    private List<TitleEntity> list;

    public HeadTitleAdapter(LayoutHelper mLayoutHelper, int mCount, int mLayoutId, Context mContext, int mViewTypeItem, List<TitleEntity> list) {
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
        holder.setText(R.id.tv_title, list.get(position).getTitle())
                .setText(R.id.tv_title_des, list.get(position).getTitleDes());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return mViewTypeItem;
    }
}
