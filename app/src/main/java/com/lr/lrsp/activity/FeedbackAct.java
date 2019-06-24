package com.lr.lrsp.activity;

import android.view.View;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈
 *
 * @author admin
 * @date 2018/1/29
 */

public class FeedbackAct extends ActionBarActivity {

    @BindView(R.id.title)
    TextView titleView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }


    @Override
    protected void initView() {
        titleView.setText("意见反馈");
        super.initView();
    }


    @OnClick({R.id.relative_back})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.relative_back:
                finish();
                break;

        }
    }
}
