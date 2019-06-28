package com.lr.lrsp.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lr.lrsp.R;
import com.lr.lrsp.activity.FeedbackAct;
import com.lr.lrsp.activity.VideoDetailsAct;
import com.lr.lrsp.adapter.HomeVideoListAdapter;
import com.lr.lrsp.base.BaseFragment;
import com.lr.lrsp.bean.HomeVideoBean;
import com.lr.lrsp.controller.OnViewClick;
import com.lr.lrsp.dialog.MoreDialog;
import com.lr.lrsp.dialog.PosterDialog;
import com.lr.lrsp.dialog.ShareDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2019/6/22.
 */

public class HomeVideListFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener, OnViewClick {

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
        adapter.setOnItemChildClickListener(this);
        super.initView();
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.share_btn:
                //分享
                ShareDialog shareDialog = new ShareDialog(getActivity());
                shareDialog.setOnViewClick(this);
                shareDialog.show();
                break;
            case R.id.more_btn:
                //3个点
                MoreDialog moreDialog = new MoreDialog(getActivity());
                moreDialog.setOnViewClick(this);
                moreDialog.show();
                break;
            case R.id.video_details:
                startActivity(VideoDetailsAct.class);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabulous:
                break;
            case R.id.wx_food_friend:
                break;
            case R.id.uninterested:
                break;
            case R.id.feedback:
                //意见反馈
                startActivity(FeedbackAct.class);
                break;
            case R.id.share_wx:
                break;
            case R.id.share_wx_pyq:
                break;
            case R.id.share_qq:
                break;
            case R.id.share_copy:
                break;
            case R.id.share_poster:
                //分享海报
                PosterDialog dialog = new PosterDialog(getActivity());
                dialog.setOnViewClick(this);
                dialog.show();
                break;
            case R.id.share_tu_wx:
                break;
            case R.id.share_tu_wx_pyq:
                break;
            case R.id.share_tu_qq:
                break;
            case R.id.share_tu_poster:
                break;
        }
    }
}
