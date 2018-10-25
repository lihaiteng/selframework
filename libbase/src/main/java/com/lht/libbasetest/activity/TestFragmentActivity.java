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
            fnow = fa;
        }
    }

    public void b(View view) {
        if(fnow != fb){
            hideFragment(fnow);
            fnow = fb;
            if(fb.isAdded())
                showFragment(fb);
            else
                addFragment(fb);
        }
    }

    public void c(View view) {
        if(fnow != fc){
            hideFragment(fnow);
            fnow = fc;
            if(fc.isAdded())
                showFragment(fc);
            else
                addFragment(fc);
        }
    }

    public void d(View view) {
        if(fnow != fd){
            hideFragment(fnow);
            fnow = fd;
            if(fd.isAdded())
                showFragment(fd);
            else
                addFragment(fd);
        }
    }
}
