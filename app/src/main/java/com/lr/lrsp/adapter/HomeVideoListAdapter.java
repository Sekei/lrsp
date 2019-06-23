package com.lr.lrsp.adapter;

import android.support.annotation.Nullable;
import android.view.SurfaceView;

import com.alivc.player.AliVcMediaPlayer;
import com.alivc.player.MediaPlayer;
import com.aliyun.vodplayer.media.AliyunLocalSource;
import com.aliyun.vodplayer.media.AliyunVodPlayer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lr.lrsp.R;
import com.lr.lrsp.bean.HomeVideoBean;

import java.util.List;

/**
 * Created by Administrator on 2019/6/22.
 */

public class HomeVideoListAdapter extends BaseQuickAdapter<HomeVideoBean, BaseViewHolder> implements MediaPlayer.MediaPlayerPreparedListener {
    private AliyunVodPlayer aliyunVodPlayer;

    public HomeVideoListAdapter(@Nullable List<HomeVideoBean> data) {
        super(R.layout.item_home_video_list, data);
        aliyunVodPlayer = new AliyunVodPlayer(mContext);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeVideoBean item) {
        SurfaceView surfaceView = helper.getView(R.id.surfaceview);
       // mVcMediaPlayer.setPreparedListener(this);
        String videoUrl="http://lirenshipin.oss-cn-hangzhou.aliyuncs.com/1000000494.mp4?Expires=1561267490&OSSAccessKeyId=TMP.AgGVgO7PDNiou2nwbbYGmb-LvoLY2SVx6wGU13_fKiLLfhZmUbC5wldBL63XADAtAhUA_lwxdusrIgFd2Xuft9gOFlcO7SwCFFwA6_q2-IyaPvBKqBm22OVwa8oy&Signature=aWR0Y6DVYTqFhWZdJ2KtVnfdEmw%3D";
        //mVcMediaPlayer.prepareToPlay(videoUrl);
        AliyunLocalSource.AliyunLocalSourceBuilder asb = new AliyunLocalSource.AliyunLocalSourceBuilder();
        asb.setSource(videoUrl);
        AliyunLocalSource mLocalSource = asb.build();
        aliyunVodPlayer.prepareAsync(mLocalSource);
        //开始播放
        aliyunVodPlayer.start();
    }

    @Override
    public void onPrepared() {
     // mVcMediaPlayer.prepareToPlay(videoUrl);
    }
}
