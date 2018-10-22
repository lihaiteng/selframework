package com.lht.animator.base;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
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
        ValueAnimator valueAnimator = ValueAnimator.ofInt(50,0);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(10000);
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
        //使动画元素移出父元素后不被父元素的兄弟元素遮挡（其实就是一个父元素置顶的操作）
        findViewById(R.id.constraint).bringToFront();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.setTarget(textShow);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int)animation.getAnimatedValue();
                textShow.setTranslationY(animatedValue);
            }
        });
        valueAnimator.start();
    }

    public void clickC(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.setTarget(textShow);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int)animation.getAnimatedValue();
                textShow.setTranslationX(animatedValue);
            }
        });
        valueAnimator.start();
    }
}
