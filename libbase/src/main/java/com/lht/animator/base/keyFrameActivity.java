package com.lht.animator.base;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/22 0022
 */

public class keyFrameActivity extends BaseActivity {

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_keyframe);
    }

    public void click(View v){
        //运动时间百分比，属性值
        Keyframe kf0 = Keyframe.ofFloat(0, 0);
        Keyframe kf1 = Keyframe.ofFloat(0.25f, 800);
        Keyframe kf2 = Keyframe.ofFloat(0.5f, 400);
        Keyframe kf4 = Keyframe.ofFloat(0.75f, 600);
        Keyframe kf3 = Keyframe.ofFloat(1f, 800);

//        kf0.setInterpolator();

        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("translationY", kf0, kf1, kf2, kf4, kf3);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(v, pvhRotation);
        rotationAnim.setDuration(8000);
        rotationAnim.start();
    }
}
