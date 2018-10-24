package com.lht.libbasetest.activity;

import android.view.View;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseFragmentActivity;
import com.lht.libbasetest.fragment.FragmentX;

/**
 * @date 2018/10/24 0024
 */

public class TestFragmentActivity extends BaseFragmentActivity {

    private FragmentX fa,fb,fc,fd,fnow;
    @Override
    public int fragmentContainer() {
        return R.id.container;
    }

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.activity_fragment);
        fa = new FragmentX();
        fa.setTag("A");
        addFragment(fa);
        fnow = fa;

        fb = new FragmentX();
        fb.setTag("B");
        fc = new FragmentX();
        fc.setTag("C");
        fd = new FragmentX();
        fd.setTag("D");
    }

    public void a(View view) {
        if(fnow != fa){
            showFragment(fa);
            hideFragment(fnow);
        }
    }

    public void b(View view) {
        hideFragment(fa);
        if(fb.isAdded())
            showFragment(fb);
        else
            addFragment(fb);
    }

    public void c(View view) {
        replaceFragment(fc);
    }

    public void d(View view) {
        replaceFragment(fd);
    }
}
