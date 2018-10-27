package com.lht.libbase.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.lht.libbase.utils.LogUtil;

public class BaseActivity extends AppCompatActivity {

    protected ActivityHelper activityHelper;//自定义的activity帮助类，功能拓展
    protected Context context;
    protected Activity activity;

    private BackListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if(savedInstanceState!=null)
//            LogUtil.d("onCreate==>",savedInstanceState.getInt("i"));
        beforeCreate();
        super.onCreate(savedInstanceState);
        initView();
        initSpecil();
        control();
    }

    protected void beforeCreate() {
    }

    protected void initView() {
        context = getApplicationContext();
        activity = this;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityHelper = new ActivityHelper(this);
    }

    //特殊部分的初始化
    protected void initSpecil(){
    }

    protected void control() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        outState.putInt("i",7);
        super.onSaveInstanceState(outState);
//        LogUtil.d("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        LogUtil.d("onRestoreInstanceState",savedInstanceState.getInt("i"));
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

    protected void toast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}