package com.lr.lrsp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lr.lrsp.fragment.HomeVideListFragment;

/**
 * Created by Administrator on 2019/6/22.
 */

public class HomeTabAdapter extends FragmentPagerAdapter {
    private String[] titles = {"推荐", "音乐","搞笑","奇闻"};
    private String[] titlesId = {"", "0", "1", "4", "10", "8"};


    public HomeTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        HomeVideListFragment mFragment = new HomeVideListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("status", titlesId[position]);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
