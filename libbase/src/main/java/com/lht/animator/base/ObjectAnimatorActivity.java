package com.lht.animator.base;

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

public class ObjectAnimatorActivity extends BaseActivity {

    private TextView textShow,text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_object);
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
                  .ofFloat(textShow, "rotation", 0.0F, 90.0F)
//                .ofFloat(textShow, "translationX", 0.0f, 350.0f)
//                .ofFloat(textShow, "translationY", 0.0f, 350.0f)
//                .ofFloat(textShow, "alpha", 1, 0.2f,0.5f)
                ;

        //动画绘制过程的监听
        objectAnimator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                Float cVal = (Float) animation.getAnimatedValue();//监听动画过程，获取过程中的属性值
//                textShow.setScaleX(cVal);//根据这个值，改变其它属性
//                textShow.setScaleY(cVal);
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
//        objectAnimator.setRepeatCount(2);//设置动画重复次数
//        objectAnimator.setRepeatMode()//设置动画重复模式
//        objectAnimator.setStartDelay(1000);//设置动画延时操作
//        objectAnimator.setTarget();//设置动画的对象
//        objectAnimator.setEvaluator();//设置动画过度的评估者
//        objectAnimator.getInterpolator();//设置动画插值

          textShow.setPivotX(-10);
          textShow.setPivotY(-10);

        objectAnimator.start();
    }

    public void clickB(View v){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(textShow, "x", 0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textShow, "alpha", 1,0.5f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textShow, "rotationX", 0,360f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textShow, "rotationY", 0,360f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).with(animator2).with(animator3).after(animator0);
        animatorSet.setDuration(2000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                ObjectAnimator animator4 = ObjectAnimator.ofFloat(textShow,"translationX",200);
                ObjectAnimator animator5 = ObjectAnimator.ofFloat(textShow,"scaleX",2);
                ObjectAnimator animator6 = ObjectAnimator.ofFloat(textShow,"scaleY",2);

                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animator4,animator5,animator6);
                animatorSet2.setDuration(5000);
                animatorSet2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator animator7 = ObjectAnimator.ofFloat(textShow,"translationX",100,190,110,180,120,170,130,160,140,150);
                        animator7.setDuration(1000);
                        animator7.start();
                    }
                });
                textShow.setPivotX(0.5f);
                textShow.setPivotY(0.5f);
                animatorSet2.start();
            }
        });
        animatorSet.start();
    }

    public void clickC(View view) {
        ObjectAnimator animator1 = ObjectAnimator.ofInt(new WrapperView(textShow),"width",200);
        animator1.setDuration(5000);
        animator1.start();
    }

    public void clickD(View view) {
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX",1.0f,2.0f);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY",1.0f,2.0f);

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(textShow,propertyValuesHolder,propertyValuesHolder2);
        animator1.setDuration(5000);
        animator1.start();
    }
}
