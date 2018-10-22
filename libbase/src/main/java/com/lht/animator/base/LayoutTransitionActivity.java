package com.lht.animator.base;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/20 0020
 */

public class LayoutTransitionActivity extends BaseActivity {

    private LayoutTransition layoutTransition;
    private LinearLayout linearLayout;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_layouttransition);
        linearLayout = findViewById(R.id.linear);

        layoutTransition = new LayoutTransition();
        linearLayout.setLayoutTransition(layoutTransition);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "x", -1000F, 0F);
        animator1.setDuration(2000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "x", 0F, 2000F);
        animator2.setDuration(2000);
        layoutTransition.setAnimator(LayoutTransition.APPEARING, animator1);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,animator2);
    }


    public void btnclick(View view) {
        final Button btn = new Button(this);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        btn.setLayoutParams(p);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeView(btn);
            }
        });
        linearLayout.addView(btn);
    }
}
