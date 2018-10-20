package com.lht.demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/19 0019
 */

public class ViewAnimatorActivity extends BaseActivity {

    private TextView textShow,text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_object);
        textShow = findViewById(R.id.textShow);
        text = findViewById(R.id.text);
    }

    /**
     * AnimatorUpdateListener
     * @param v
     */
    public void clickA(View v){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(5,0);
        valueAnimator.setDuration(5000);
        valueAnimator.setTarget(textShow);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int)animation.getAnimatedValue();
                textShow.setText(animatedValue+"秒");
            }
        });
        valueAnimator.start();
    }

    public void clickB(View view) {
    }
}
