package com.lht.animator.base;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/20 0020
 */

public class XmlAnimatorActivity extends BaseActivity{
    private TextView textShow,text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_xml);
        textShow = findViewById(R.id.textShow);
        text = findViewById(R.id.text);
    }

    public void clickA(View view) {
        @SuppressLint("ResourceType") Animator animator = AnimatorInflater.loadAnimator(context,R.anim.scale);
        animator.setTarget(textShow);
        textShow.setPivotX(0.5f);
        animator.start();

    }
}
