package com.boggle.wall.moudle.main.fragment.adapter;

import android.os.Parcelable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;


/**
 * Created by wuqx14 on 2020/8/24.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitles;
    private List<Fragment> mFragments;

    public MyViewPagerAdapter(FragmentManager fm, List<String> mTitles, List<Fragment> salesOrderVpFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = salesOrderVpFragments;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {

    }
}
