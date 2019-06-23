package com.lr.lrsp.activity;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lr.lrsp.R;
import com.lr.lrsp.base.ActionBarActivity;
import com.lr.lrsp.widget.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends ActionBarActivity {
    //记录用户首次点击返回键的时间
    private long firstTime = 0;
    //首页
    @BindView(R.id.fragment)
    RelativeLayout homeFragment;
    @BindView(R.id.home_text_home)
    TextView homeTextHome;
    @BindView(R.id.image_home)
    ImageView imageHome;
    //我的
    @BindView(R.id.my_fragment)
    RelativeLayout myFragment;
    @BindView(R.id.home_text_my)
    TextView homeTextMy;
    @BindView(R.id.image_my)
    ImageView imageMy;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @OnClick({R.id.home_radio_page, R.id.home_radio_my})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.home_radio_page:
                homeTextMy.setTextColor(getResources().getColor(R.color.color_333333));
                imageMy.setBackgroundResource(R.mipmap.icon_home_page_mine_false);
                //首页
                homeFragment.setVisibility(View.VISIBLE);
                myFragment.setVisibility(View.GONE);
                homeTextHome.setText("刷新");
                imageHome.setBackgroundResource(R.mipmap.icon_page_home_true);
                homeTextHome.setTextColor(getResources().getColor(R.color.color_ff0043));
                Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
                imageHome.startAnimation(rotate);
                break;
            case R.id.home_radio_my:
                imageHome.clearAnimation();
                imageHome.setBackgroundResource(R.mipmap.icon_page_home_false);
                homeTextHome.setText("首页");
                homeTextHome.setTextColor(getResources().getColor(R.color.color_333333));
                //个人
                myFragment.setVisibility(View.VISIBLE);
                homeFragment.setVisibility(View.GONE);
                homeTextMy.setTextColor(getResources().getColor(R.color.color_ff0043));
                imageMy.setBackgroundResource(R.mipmap.icon_home_page_mine_true);
                break;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    ToastUtils.show("再按一次退出程序");
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
            default:
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

}
