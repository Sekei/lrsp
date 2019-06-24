package com.lr.lrsp.fragment;

import android.view.View;
import android.widget.RelativeLayout;

import com.lr.lrsp.R;
import com.lr.lrsp.activity.FeedbackAct;
import com.lr.lrsp.activity.HistoryAct;
import com.lr.lrsp.activity.MyFabulousAct;
import com.lr.lrsp.activity.SetUpAct;
import com.lr.lrsp.activity.UserInfoAct;
import com.lr.lrsp.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/6/22.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.user_info)
    RelativeLayout userInfo;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }


    @Override
    protected void initView() {
        super.initView();
    }


    @OnClick({R.id.viewing_history, R.id.fabulous, R.id.feedback, R.id.setup, R.id.user_info})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.viewing_history:
                //观看历史
                startActivity(HistoryAct.class);
                break;
            case R.id.fabulous:
                //我的点赞
                startActivity(MyFabulousAct.class);
                break;
            case R.id.feedback:
                //意见反馈
                startActivity(FeedbackAct.class);
                break;
            case R.id.setup:
                startActivity(SetUpAct.class);
                break;
            case R.id.user_info:
                //用户信息
                startActivity(UserInfoAct.class);
                break;
        }
    }
}
