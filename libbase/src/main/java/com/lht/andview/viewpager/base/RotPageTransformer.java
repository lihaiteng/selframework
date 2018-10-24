package com.lht.andview.viewpager.base;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.lht.libbase.utils.LogUtil;

/**
 * @date 2018/10/23 0023
 */

public class RotPageTransformer implements ViewPager.PageTransformer {
    private static final float ROT_MAX = 90.0f;
    private float mRot;

    public void transformPage(View view, float position)
    {

//        LogUtil.d("TAG", view + " , " + position + "");

        if (position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.animate().rotation(0).start();

        } else if (position <= 1) // a页滑动至b页 ； a页从 0.0 ~ -1 ；b页从1 ~ 0.0
        { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            if (position < 0)
            {

                mRot = (ROT_MAX * position);
                view.setPivotX(view.getMeasuredWidth() * 0.5f);
                view.setPivotY(view.getMeasuredHeight()*2);
                view.animate().rotation(mRot).start();
            } else
            {

                mRot = (ROT_MAX * position);
                view.setPivotX(view.getMeasuredWidth() * 0.5f);
                view.setPivotY(view.getMeasuredHeight()*2);
                view.animate().rotation(mRot).start();
            }

            // Scale the page down (between MIN_SCALE and 1)

            // Fade the page relative to its size.

        } else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.animate().rotation(0).start();
        }
    }
}
