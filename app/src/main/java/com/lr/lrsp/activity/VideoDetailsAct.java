package com.lr.lrsp.activity;

import android.support.v7.widget.RecyclerView;

import com.lr.lrsp.R;
import com.lr.lrsp.adapter.VideoListAdapter;
import com.lr.lrsp.base.ActionBarActivity;
import com.lr.lrsp.bean.HomeVideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 视频详情
 *
 * @author admin
 * @date 2018/1/29
 */

public class VideoDetailsAct extends ActionBarActivity {
    @BindView(R.id.video_list_view)
    RecyclerView videoListView;

    private VideoListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_details;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;
    }

    @Override
    protected void initView() {
        List<HomeVideoBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            arrayList.add(new HomeVideoBean());
        }
        adapter = new VideoListAdapter(arrayList);
        videoListView.setAdapter(adapter);
        super.initView();
    }
}
