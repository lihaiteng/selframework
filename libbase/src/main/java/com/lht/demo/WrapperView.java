package com.lht.demo;

import android.view.View;

/**
 * @date 2018/10/20 0020
 */

public class WrapperView {
    private View targetView;
    public WrapperView(View targetView){
        this.targetView = targetView;
    }
    public void setWidth(int width){
        targetView.getLayoutParams().width = width;
        targetView.requestLayout();
    }

    public void setHeight(int height){
        targetView.getLayoutParams().height = height;
        targetView.requestLayout();
    }

    public int getWidth(){
        return targetView.getLayoutParams().width;
    }

    public int getHight(){
        return targetView.getLayoutParams().height;
    }
}
