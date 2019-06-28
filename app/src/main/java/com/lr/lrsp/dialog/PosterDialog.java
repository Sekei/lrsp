package com.lr.lrsp.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lr.lrsp.R;
import com.lr.lrsp.base.BaseDialog;
import com.lr.lrsp.controller.OnViewClick;

import butterknife.OnClick;

/**
 * Created by admin on 2019/6/24.
 */

public class PosterDialog extends BaseDialog {

    private OnViewClick mOnViewClick;


    public void setOnViewClick(OnViewClick mOnViewClick) {
        this.mOnViewClick = mOnViewClick;
    }

    public PosterDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_share_poster;
    }

    @Override
    protected void initView() {
        Window window = getWindow();
        //window.setWindowAnimations(R.style.dialog_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.getDecorView().setPadding(0, 0, 0, 0);
        wl.gravity = Gravity.BOTTOM;
        window.setAttributes(wl);
    }


    @OnClick({R.id.share_tu_wx, R.id.share_tu_wx_pyq, R.id.share_tu_qq,R.id.share_tu_poster, R.id.clase})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.clase:
                dismiss();
                break;
            default:
                dismiss();
                if (null != mOnViewClick) {
                    mOnViewClick.onClick(v);
                }
                break;
        }
    }
}
