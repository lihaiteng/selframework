package com.lht.demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/19 0019
 */

public class MainActivity extends BaseActivity {

    private TextView textShow,text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.main_activity);
        textShow = findViewById(R.id.textShow);
        text = findViewById(R.id.text);
    }

    public void clickA(View v){
        ObjectAnimator objectAnimator = ObjectAnimator
//                .ofFloat(textShow, "X", 0, 100)
//                .ofFloat(textShow, "X", 0, 100,50,150,100,200)
//                .ofFloat(textShow, "Y", 0, 100)
//                .ofFloat(textShow, "scaleX", 1, 2)
//                .ofFloat(textShow, "scaleY", 1, 2)
//                .ofFloat(textShow, "rotationX", 0.0F, 90.0F)
//                .ofFloat(textShow, "rotationY", 0.0F, 90.0F)
//                .ofFloat(textShow, "translationX", 0.0f, 350.0f)
//                .ofFloat(textShow, "translationY", 0.0f, 350.0f)
                .ofFloat(textShow, "alpha", 1, 0.2f,0.5f);

        //动画绘制过程的监听
        objectAnimator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float cVal = (Float) animation.getAnimatedValue();//监听动画过程，获取过程中的属性值
                textShow.setScaleX(cVal);//根据这个值，改变其它属性
                textShow.setScaleY(cVal);
            }
        });

        //动画绘制状态的监听
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                text.setText("动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text.setText("动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                text.setText("动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                text.setText("动画重复");
            }
        });

        objectAnimator.setDuration(3000);//设置动画执行时间
        objectAnimator.setRepeatCount(2);//设置动画重复次数
//        objectAnimator.setRepeatMode()//设置动画重复模式
        objectAnimator.setStartDelay(1000);//设置动画延时操作
//        objectAnimator.setTarget();//设置动画的对象
//        objectAnimator.setEvaluator();//设置动画过度的评估者
        objectAnimator.getInterpolator();//设置动画插值
        objectAnimator.start();
    }

    public void clickB(View v){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(textShow, "x", 0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textShow, "alpha", 1,0.5f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textShow, "rotationX", 0,360f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textShow, "rotationY", 0,360f);

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(textShow,"translationX",0,200);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(textShow,"scaleX",1,2);
        ObjectAnimator animator6 = ObjectAnimator.ofFloat(textShow,"scaleY",1,2);

        final ObjectAnimator animator7 = ObjectAnimator.ofFloat(textShow,"translationX",0,50,10,40,20,30,36,33);


        final AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animator4,animator5,animator6);
        animatorSet2.setDuration(5000);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animator7.start();
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).with(animator2).with(animator3).after(animator0);
        animatorSet.setDuration(2000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                textShow.setX(0);//TODO lht
                animatorSet2.start();
            }
        });
        animatorSet.start();
    }
}
