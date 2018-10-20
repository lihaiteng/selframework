package com.lht.libbase.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class BaseActivity extends AppCompatActivity {

    protected ActivityHelper activityHelper;//自定义的activity帮助类，功能拓展
    protected Context context;
    protected Activity activity;

    private BackListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    protected void initView() {
        context = this;
        activity = this;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityHelper = new ActivityHelper(this);
    }

    //设置返回键的类型  : 双击退出，单击finish，webview回退
    public void setBackType(ActivityHelper.BackType backType){
        activityHelper.setBackType(backType);
    }

    public void setBackListener(BackListener listener){
        clickListener = listener;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(clickListener==null)
                return activityHelper.onBackDwon();
            else
                clickListener.doBack();
        }
        return super.onKeyDown(keyCode,event);
    }

    public interface BackListener{
        void doBack();
    }
}