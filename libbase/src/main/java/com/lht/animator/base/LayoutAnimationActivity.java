package com.lht.animator.base;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/22 0022
 */

public class LayoutAnimationActivity extends BaseActivity {

    private LayoutTransition layoutTransition;
    private TranslateAnimation translateAnimation;
    private LinearLayout linearLayout;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_layouttransition);
        linearLayout = findViewById(R.id.linear);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(2000);
        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5F);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        linearLayout.setLayoutAnimation(lac);

        layoutTransition = new LayoutTransition();
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "x", 0F, 2000F);
        animator2.setDuration(2000);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,animator2);
        linearLayout.setLayoutTransition(layoutTransition);
    }


    public void topbtnclick(View view){

    }

    public void btnclick(View view) {
        linearLayout.removeView(view);
    }
}
