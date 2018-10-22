package com.lht.animator.base;

import android.view.View;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/22 0022
 */

public class ViewAnimateActivity extends BaseActivity {

    View view;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_viewanimate);
    }

    public void click(View view){
        this.view = view;
        view.animate().alpha(0).y(100).setDuration(1000)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                    }
                }).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
            }
        }).start();
    }

    public void reset(View view){
        this.view.animate().alpha(1).y(0).setDuration(1000)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                    }
                }).withEndAction(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }).start();
    }
}
