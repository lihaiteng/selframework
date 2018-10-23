package com.lht.libbase.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.lang.reflect.Field;
import java.util.List;

public class AppUtil {

    /**
     * @return
     * @Description:获取当前应用的名称
     */
    public static String getApplicationName(Context c) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = c.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    /**
     * @return
     * @Description:获取当前应用包名
     */
    public static String getPackageName(Context c) {
        try{
            if(Build.VERSION.SDK_INT <= 21){
                ActivityManager.RunningTaskInfo runningTaskInfo = getRunningTaskInfo(c);
                return runningTaskInfo.baseActivity.getPackageName();
            }else{
                ActivityManager.RunningAppProcessInfo  runningAppProcessInfo =
                        getRunningAppProcessInfo(c);
                return runningAppProcessInfo.pkgList[0];
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 小于22版本中，获取RunningTaskInfo,从而获取一些包的信息
     * @param c
     * @return
     */
    public static ActivityManager.RunningTaskInfo getRunningTaskInfo(Context c){
        if (Build.VERSION.SDK_INT <= 21) { // 如果版本低于22
            // 获取到activity的管理的类
            ActivityManager m = (ActivityManager)c.getSystemService(Context.ACTIVITY_SERVICE);
            // 获取最近的一个运行的任务的信息
            List<ActivityManager.RunningTaskInfo> tasks = m.getRunningTasks(1);
            if (tasks != null && tasks.size() > 0) { // 如果集合不是空的
                // 返回任务栈中最上面的一个
                ActivityManager.RunningTaskInfo info = m.getRunningTasks(1).get(0);
                return info;
                // 获取到应用的包名
                //return info.baseActivity.getPackageName();
            }
        }
        return null;
    }

    /**
     * 大于22版本中，采用获取RunningAppProcessInfo，从而获取一些包的信息
     * @param c
     * @return
     */
    public static ActivityManager.RunningAppProcessInfo getRunningAppProcessInfo(Context c){
        if (Build.VERSION.SDK_INT > 21) { // 如果版本高于22
            final int PROCESS_STATE_TOP = 2;
            try {
                // 获取正在运行的进程应用的信息实体中的一个字段,通过反射获取出来
                Field processStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
                // 获取所有的正在运行的进程应用信息实体对象
                List<ActivityManager.RunningAppProcessInfo> processes = ((ActivityManager)c
                        .getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses();
                // 循环所有的进程,检测某一个进程的状态是最上面,也是就最近运行的一个应用的状态的时候,就返回这个应用的包名
                for (ActivityManager.RunningAppProcessInfo process : processes) {
                    if (process.importance <= ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                            && process.importanceReasonCode == 0) {
                        int state = processStateField.getInt(process);
                        if (state == PROCESS_STATE_TOP) { // 如果这个实体对象的状态为最近的运行应用
                            return process;
                            // 返回应用的包名
                            // String[] packname = process.pkgList;
                            //return packname[0];
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取apk版本号
     */
    public static String getVersionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        String version = "";
        try {
            version = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            version = "";
        }
        LogUtil.d("版本号|"+version);
        return version;
    }

    /**
     * 判断某个进程是否存活
     */
    public static boolean isProessRunning(Context context, String proessName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> lists = am.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info : lists){
            if(info.processName.equals(proessName)){
                isRunning = true;
            }
        }
        return isRunning;
    }

    /**
     * 判断某个服务是否存活
     */
    public static boolean isServiceRunning(Context context, String serviceName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> lists = am.getRunningServices(30);
        for (ActivityManager.RunningServiceInfo info : lists) {//判断服务
            if(info.service.getClassName().equals(serviceName)){
                isRunning = true;
            }
        }
        return isRunning;
    }
}
