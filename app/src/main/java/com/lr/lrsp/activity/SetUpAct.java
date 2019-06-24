package com.lr.lrsp.activity;

import android.view.View;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置界面
 *
 * @author admin
 * @date 2018/1/29
 */

public class SetUpAct extends ActionBarActivity {

    @BindView(R.id.title)
    TextView titleView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_setup;
    }


    @Override
    protected void initView() {
        titleView.setText("设置");
        super.initView();
    }


    @OnClick({R.id.relative_back, R.id.about_us})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.relative_back:
                finish();
                break;
            case R.id.about_us:
                startActivity(AboutUsAct.class);
                break;
        }
    }
}
