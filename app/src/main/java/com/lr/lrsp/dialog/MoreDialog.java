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

public class MoreDialog extends BaseDialog {

    private OnViewClick mOnViewClick;


    public void setOnViewClick(OnViewClick mOnViewClick) {
        this.mOnViewClick = mOnViewClick;
    }

    public MoreDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_more;
    }

    @Override
    protected void initView() {
        Window window = getWindow();
        window.setWindowAnimations(R.style.dialog_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.getDecorView().setPadding(0, 0, 0, 0);
        wl.gravity = Gravity.BOTTOM;
        window.setAttributes(wl);
    }


    @OnClick({R.id.fabulous, R.id.wx_food_friend, R.id.uninterested, R.id.feedback, R.id.clase})
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
