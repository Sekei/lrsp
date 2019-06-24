package com.lr.lrsp.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.adapter.VideoListAdapter;
import com.lr.lrsp.base.ActionBarActivity;
import com.lr.lrsp.bean.HomeVideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的点赞
 *
 * @author admin
 * @date 2018/1/29
 */

public class MyFabulousAct extends ActionBarActivity {

    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.right_view)
    TextView rightView;
    @BindView(R.id.video_list_view)
    RecyclerView videoListView;


    private VideoListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }


    @Override
    protected void initView() {
        titleView.setText("我的点赞");
        rightView.setText("清空记录");
        rightView.setVisibility(View.VISIBLE);
        List<HomeVideoBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            arrayList.add(new HomeVideoBean());
        }
        adapter = new VideoListAdapter(arrayList);
        videoListView.setAdapter(adapter);
        super.initView();
    }


    @OnClick({R.id.relative_back, R.id.right_view})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.relative_back:
                finish();
                break;
            case R.id.right_view:
                break;

        }
    }
}
