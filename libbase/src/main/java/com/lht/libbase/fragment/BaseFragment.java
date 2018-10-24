package com.lht.libbase.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @date 2018/10/24 0024
 */

public abstract class BaseFragment<T extends FragmentActivity> extends Fragment{

    protected T activity;
    protected Bundle bundle;
    protected View view;

    //Fragment和Activity建立关联时调用(获取Activity传递的值)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (T)context;
        bundle = getArguments();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //为Fragment创建View(加载布局)时调用
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layout(),container,false);
        initView();
        return view;
    }

    /**
     * 待子类重写
     * setLayout(layoutId)
     * 初始化layout中的控件
     */
    protected void initView() {

    }

    /**
     * 需要返回fragment的布局id
     * @return
     */
    public abstract int layout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //Fragment的布局被移除时调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //Fragment和Activity解除关联的时候调用
    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected void toast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
