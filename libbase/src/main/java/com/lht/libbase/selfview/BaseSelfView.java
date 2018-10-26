package com.lht.libbase.selfview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @date 2018/10/26 0026
 */

public class BaseSelfView extends View {

    protected Paint paint;

    protected TypedArray typedArray;

    protected AttributeSet attrs;

    protected Context context;

    public BaseSelfView(Context context) {
        super(context,null);
    }

    public BaseSelfView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
        initAttrs();
        if(typedArray!=null)
            typedArray.recycle();
    }

    protected void init(Context context, AttributeSet attrs) {
        this.context = context;
        this.attrs = attrs;
        paint = new Paint();
    }

    public void setTypeArray(int[] styleAttr){
        typedArray = context.obtainStyledAttributes(attrs,styleAttr);
    }

    protected void initAttrs() {
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
