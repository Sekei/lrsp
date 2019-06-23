package com.lr.lrsp.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author admin
 * @date 2018/1/29
 */

public class StartAct extends ActionBarActivity {


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity(MainActivity.class);
            finish();
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;
    }

    @Override
    protected void initView() {
        super.initView();
        handler.sendEmptyMessageDelayed(0, 2000);
    }
}
