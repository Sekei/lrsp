package com.lr.lrsp.fragment;

import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.lr.lrsp.R;
import com.lr.lrsp.adapter.HomeTabAdapter;
import com.lr.lrsp.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2019/6/22.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    XTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        viewPager.setAdapter(new HomeTabAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);//绑定
        super.initView();
    }
}
