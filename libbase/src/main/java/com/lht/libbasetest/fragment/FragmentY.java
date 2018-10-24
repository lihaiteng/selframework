package com.lht.libbasetest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.fragment.BaseFragment;
import com.lht.libbase.utils.LogUtil;

/**
 * Created by bockey on 2017/2/4.
 */
public class FragmentY extends BaseFragment {

    private TextView text;
    private String tag;

    private static int N = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        N+=1;
        LogUtil.d(N);
        toast(String.valueOf(text == null)+"=="+N);
    }

    @Override
    public int layout() {
        return R.layout.test_fragment_y;
    }

    @Override
    protected void initView() {
        super.initView();
        text = view.findViewById(R.id.text);
        text.setText(tag);
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
