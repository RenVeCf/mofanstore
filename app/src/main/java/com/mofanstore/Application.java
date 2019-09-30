package com.mofanstore;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;

public class Application extends MultiDexApplication {
    public static final boolean debug = false;


    //创建单列
    private static Application instance;
    public static Context mContext;
    //屏幕像素
    private DisplayMetrics displayMetrics = null;
    public static Application getInstance() {
        return instance;
    }
    private SharedPreferences sp;
    public static Context getAppContext() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        sp = getSharedPreferences("guoerInfo", MODE_PRIVATE);
        mContext=getApplicationContext();

    }

    public float getScreenDensity() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.density;
    }

    public int getScreenHeight() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.heightPixels;
    }

    public int getScreenWidth() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.widthPixels;
    }

    public void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        this.displayMetrics = DisplayMetrics;
    }

}
