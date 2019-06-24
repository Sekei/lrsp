package com.lr.lrsp.adapter;

import android.support.annotation.Nullable;

import com.alivc.player.MediaPlayer;
import com.aliyun.vodplayer.media.AliyunVodPlayer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lr.lrsp.R;
import com.lr.lrsp.bean.HomeVideoBean;

import java.util.List;

/**
 * Created by Administrator on 2019/6/22.
 */

public class VideoListAdapter extends BaseQuickAdapter<HomeVideoBean, BaseViewHolder> {

    public VideoListAdapter(@Nullable List<HomeVideoBean> data) {
        super(R.layout.item_video_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeVideoBean item) {
        helper.setGone(R.id.layout_view, helper.getLayoutPosition() == 0 ? true : false);
    }

}
