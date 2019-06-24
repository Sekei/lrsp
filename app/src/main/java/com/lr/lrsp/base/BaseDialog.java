package com.lr.lrsp.base;

import android.app.Dialog;
import android.content.Context;

import com.lr.lrsp.R;

import butterknife.ButterKnife;

/**
 * Created by admin on 2018/2/6.
 */

public abstract class BaseDialog extends Dialog{

    public Context mContext;

    public BaseDialog(Context context) {
        super(context, R.style.dialog_default);
        this.mContext = context;
        setContentView(getLayoutId());
        //初始化BUtterKnife框架，可写在项目基类里面。
        ButterKnife.bind(this);
        initView();
    }


    protected abstract int getLayoutId();

    protected void initView() {

    }

    public Object getTAG() {
        return this;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void cancel() {
        super.cancel();
    }

}