package com.mofanstore.util;

import android.app.Activity;
import android.content.Context;

import java.util.Iterator;
import java.util.Stack;

public class AppManager {

    private static Stack<Activity> activityStack;
    private static Stack<Activity> activityStacklogin;
    private static AppManager instance;

    private AppManager() {}

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }




    /**
     * 添加Activity到堆栈
     */
    public void loginActivity(Activity activity) {
        if (activityStacklogin == null) {
            activityStacklogin = new Stack<Activity>();
        }
        activityStacklogin.add(activity);
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                activityStack.remove(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack!=null) {
            Iterator<Activity> iterator = activityStack.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                iterator.remove();
                activity.finish();
//            finishActivity(activity);
            }
            activityStack.clear();
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllloginActivity() {
        if (activityStacklogin!=null) {
            Iterator<Activity> iterator = activityStacklogin.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                iterator.remove();
                activity.finish();
//            finishActivity(activity);
            }
            activityStacklogin.clear();
        }
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
