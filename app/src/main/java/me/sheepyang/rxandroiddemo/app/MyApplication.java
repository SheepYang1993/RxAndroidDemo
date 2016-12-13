package me.sheepyang.rxandroiddemo.app;

import android.app.Application;

import me.sheepyang.rxandroiddemo.util.LogUtils;

/**
 * Created by Administrator on 2016-12-13.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.getBuilder(this).setTag("SheepYang").setLog2FileSwitch(true).create();
    }
}
