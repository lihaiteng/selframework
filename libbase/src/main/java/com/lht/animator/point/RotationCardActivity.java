package com.lht.animator.point;

import android.animation.ObjectAnimator;
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
    int[] widthHeifht;
    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.animator_rotationcard);
        cardView = findViewById(R.id.cardView);
        widthHeifht = ViewUtil.getWidthHeight(cardView);
    }

    public void open(View view) {
        Toast.makeText(context,widthHeifht[0]+"",Toast.LENGTH_SHORT).show();
        cardView.setPivotX(widthHeifht[0]);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(cardView,View.ROTATION_Y,0,90f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void close(View view) {
    }
}
