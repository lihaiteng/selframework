package com.lht.libbasetest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.lht.libbase.R;
import com.lht.libbase.fragment.BaseFragment;
import com.lht.libbase.utils.LogUtil;

/**
 * Created by bockey on 2017/2/4.
 */
public class FragmentX extends BaseFragment {

    private EditText edit;
    private String tag;

    private static int N = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        N+=1;
        LogUtil.d(N);
        toast(String.valueOf(edit == null)+"=="+N);
    }

    @Override
    public int layout() {
        return R.layout.test_fragment_x;
    }

    @Override
    protected void initView() {
        super.initView();
        edit = view.findViewById(R.id.edit);
        edit.setText(tag);
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("destory");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d("destroyView");
    }
}
