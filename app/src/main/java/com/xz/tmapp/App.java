package com.xz.tmapp;

import android.app.Application;
import android.content.Context;


/**
 * Created by xaozu on 15/8/4.
 * 全局控制
 */
public class App extends Application{
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        // 全局上下文
        sContext = getApplicationContext();


    }

    public static Context getContext() {
        return sContext;
    }
}
