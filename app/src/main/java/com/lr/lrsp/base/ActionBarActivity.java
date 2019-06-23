package com.lr.lrsp.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.githang.statusbar.StatusBarCompat;
import com.lr.lrsp.R;

import butterknife.ButterKnife;


public abstract class ActionBarActivity extends BaseActivity {

    //界面样式风格
    public static final int ACTIONBAR_DARK = 0;//状态栏透明
    public static final int ACTIONBAR_WHITE = 1;//默认风格

    //界面view
    protected abstract int getLayoutId();

    /**
     * 界面风格
     */
    protected int getActionBarType() {
        return ACTIONBAR_WHITE;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        initView();
    }

    // view初始化
    protected void initActionBar() {
        // 友盟统计相关======================友盟统计==========================
//        MobclickAgent.openActivityDurationTrack(false);
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(getLayoutId());
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.color_ffffff));
        //初始化BUtterKnife框架，可写在项目基类里面。
        ButterKnife.bind(this);
        if (getActionBarType() == ACTIONBAR_DARK) { //透明风格设计
            setStatusBarColor();//通知栏透明
        }
    }

    // 操作
    protected void initView() {

    }

    //生命周期,主要用于数据统计分析，如页面停留时间，打开次数等
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
