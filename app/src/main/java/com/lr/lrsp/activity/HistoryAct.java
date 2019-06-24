package com.lr.lrsp.activity;

import android.view.View;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 观看历史
 *
 * @author admin
 * @date 2018/1/29
 */

public class HistoryAct extends ActionBarActivity {

    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.right_view)
    TextView rightView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }


    @Override
    protected void initView() {
        titleView.setText("观看历史");
        rightView.setText("清空记录");
        rightView.setVisibility(View.VISIBLE);
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
