package com.lr.lrsp;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.alivc.player.AliVcMediaPlayer;

/**
 * Created by Administrator on 2019/6/22.
 */

public class MyApp extends Application {
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //让Glide能用HTTPS
        //Glide.get(this).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(getOkHttpClient()));
        // 置入一个不设防的VmPolicy（不设置的话 7.0以上一调用拍照功能就崩溃了）
        // 还有一种方式：manifest中加入provider然后修改intent代码
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        //初始化播放器（只需调用一次即可，建议在application中初始化）
        AliVcMediaPlayer.init(getApplicationContext());
    }

    //获得实例
    public static MyApp getInstance() {
        return instance;
    }

}
