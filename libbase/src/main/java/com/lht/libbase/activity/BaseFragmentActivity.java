package com.lht.libbase.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @date 2018/10/24 0024
 */

public abstract class BaseFragmentActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int fragmentContainer;

    @Override
    protected void initView() {
        super.initView();
        //获取FragmentManager
        fragmentManager = getSupportFragmentManager();
        fragmentContainer = fragmentContainer();

    }
    @Override
    protected void initSpecil() {
        super.initSpecil();
    }

    //设置fragment的容器id
    public abstract int fragmentContainer();

    protected void addFragment(Fragment fragment){
        addFragment(fragment,null);
    }

    protected void addFragment(Fragment fragment,String tag){
        //获取FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment替换到Activity的布局中(Framelayout)
        fragmentTransaction.add(fragmentContainer, fragment,tag);
        fragmentTransaction.commit();
    }

    protected void replaceFragment(Fragment fragment){
        replaceFragment(fragment,null);
    }

    protected void replaceFragment(Fragment fragment,String tag){
        //获取FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment替换到Activity的布局中(Framelayout)
        fragmentTransaction.replace(fragmentContainer, fragment,tag);
        fragmentTransaction.commit();
    }

    protected void removeFragment(Fragment fragment,String tag){
        //获取FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment替换到Activity的布局中(Framelayout)
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    protected void showFragment(Fragment fragment){
        //获取FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment替换到Activity的布局中(Framelayout)
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    protected void hideFragment(Fragment fragment){
        //获取FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment替换到Activity的布局中(Framelayout)
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

}
