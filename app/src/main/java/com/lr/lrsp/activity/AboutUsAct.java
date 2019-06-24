package com.lr.lrsp.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 关于我们
 *
 * @author admin
 * @date 2018/1/29
 */

public class AboutUsAct extends ActionBarActivity {
    @BindView(R.id.aboutus_version)
    TextView mVersion;
    @BindView(R.id.title)
    TextView titleView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }


    @Override
    protected void initView() {
        titleView.setText("关于我们");
        PackageManager packageManager = this.getPackageManager();
        try {
            PackageInfo packInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            mVersion.setText("V" + packInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
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
