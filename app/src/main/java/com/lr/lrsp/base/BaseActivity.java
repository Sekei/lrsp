package com.lr.lrsp.base;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.JSON;

/**
 * 最底层基础activity，用于定义一些跳转传参之类的
 */
public class BaseActivity extends AppCompatActivity {

    //状态栏透视效果
    protected void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setFitsSystemWindows(true);
            //透明状态栏 @顶部
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 无参activity跳转
     */
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    /**
     * 带参执行activity之间跳转
     * 参数分别以逗号分隔
     * arg0,arg1,arg2
     */
    public void startActivity(Class<?> cls, Object... objects) {
        Intent intent = new Intent(this, cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivity(intent);
    }

    /**
     * activity无参数返回方法
     */
    public void startActivityForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, requestCode);
    }

    /**
     * activity带参返回方法
     */
    public void startActivityForResult(Class<?> cls, int requestCode, Object... objects) {
        Intent intent = new Intent(this, cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 获取对应上一个activity传来对象值
     *
     * @param cls 传入对应的类型，int、String
     */
    public Object[] getIntentObjects(Class<?>... cls) {
        Object[] objs = new Object[cls.length];
        Intent intent = getIntent();
        for (int i = 0; i < objs.length; i++) {
            objs[i] = JSON.parseObject(intent.getStringExtra("data_" + i), cls[i]);
        }
        return objs;
    }

    /**
     * 默认获取传入的第一个参数
     */
    public <T> T getIntentObject(Class<T> cls) {
        return getIntentObject(cls, 0);
    }

    /**
     * 获取对应上一个activity传来的值,分别出入下标0,1,2
     */
    public <T> T getIntentObject(Class<T> cls, int positon) {
        String st = getIntent().getStringExtra("data_" + positon);
        if (st == null) {
            return null;
        }
        return JSON.parseObject(st, cls);
    }
}
