package com.lht.animator.point;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Toast;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbase.utils.ViewUtil;

/**
 * @date 2018/10/22 0022
 */

public class RotationCardActivity extends BaseActivity {

    private CardView cardView;
    private ConstraintLayout zConstraint,fConstraint;
    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_rotationcard);
        cardView = findViewById(R.id.cardView);
        zConstraint = findViewById(R.id.zConstraint);
        fConstraint = findViewById(R.id.fConstraint);

        int distance = 10000;
        float scale = getResources().getDisplayMetrics().density * distance;
        cardView.setCameraDistance(scale);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zConstraint.getVisibility() == View.GONE){
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(cardView,View.ROTATION_Y,0,180f);
                    objectAnimator.setDuration(2000);
                    objectAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cardView.setClickable(true);
                        }

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            cardView.setClickable(false);

                        }
                    });
                    objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float value = (float)animation.getAnimatedValue();
                            if(value>=90f && zConstraint.getVisibility() == View.GONE){
                                zConstraint.setVisibility(View.VISIBLE);
                                fConstraint.setVisibility(View.GONE);
                            }
                        }
                    });
                    objectAnimator.start();
                }else{
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(cardView,View.ROTATION_Y,0,-180f);
                    objectAnimator.setDuration(2000);
                    objectAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cardView.setClickable(true);
                        }

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            cardView.setClickable(false);

                        }
                    });
                    objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float value = (float)animation.getAnimatedValue();
                            if(value<=-90f && zConstraint.getVisibility() == View.VISIBLE){
                                fConstraint.setVisibility(View.VISIBLE);
                                zConstraint.setVisibility(View.GONE);
                            }
                        }
                    });
                    objectAnimator.start();
                }
            }
        });

    }

    public void open(View view) {

    }

    public void close(View view) {

    }
}
