package com.lr.lrsp.widget;

import android.view.Gravity;
import android.widget.Toast;

import com.lr.lrsp.MyApp;

/**
 * Created by Administrator on 2019/6/22.
 */

public class ToastUtils {
    /**
     * 之前显示的内容
     */
    private static String oldMsg;
    /**
     * Toast对象
     */
    private static Toast toast = null;
    /**
     * 第一次时间
     */
    private static long oneTime = 0;
    /**
     * 第二次时间
     */
    private static long twoTime = 0;

    public static void show(String message) {
        if (message == null || message.equals("") || message.length() == 0) {
            message = "未知错误";
        }
        if (toast == null) {
            toast = Toast.makeText(MyApp.getInstance(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (message.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            } else {
                oldMsg = message;
                toast.setText(message);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
        oneTime = twoTime;
    }
}
