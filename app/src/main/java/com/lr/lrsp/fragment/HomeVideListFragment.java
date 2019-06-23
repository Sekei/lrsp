package com.lr.lrsp.fragment;

import android.support.v7.widget.RecyclerView;

import com.lr.lrsp.R;
import com.lr.lrsp.adapter.HomeVideoListAdapter;
import com.lr.lrsp.base.BaseFragment;
import com.lr.lrsp.bean.HomeVideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2019/6/22.
 */

public class HomeVideListFragment extends BaseFragment {

    @BindView(R.id.video_list_view)
    RecyclerView videoListView;

    private HomeVideoListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_video_list;
    }

    @Override
    protected void initView() {
        List<HomeVideoBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            arrayList.add(new HomeVideoBean());
        }
        adapter = new HomeVideoListAdapter(arrayList);
        videoListView.setAdapter(adapter);
        super.initView();
    }
}
