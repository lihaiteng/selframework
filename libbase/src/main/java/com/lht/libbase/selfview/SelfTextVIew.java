package com.lht.libbase.selfview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.lht.libbase.R;
import com.lht.libbase.utils.DensityUtil;
import com.lht.libbase.utils.LogUtil;

/**
 * @date 2018/10/26 0026
 */

public class SelfTextVIew extends BaseSelfView {

    private String textStr;
    private int textColor,bgcolor;
    private float textsize;
    private float vprecent,hprecent;
    private float wdprecent,hgprecent;

    public SelfTextVIew(Context context) {
        super(context);
    }

    public SelfTextVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initAttrs() {
        super.initAttrs();
        setTypeArray(R.styleable.SelfText);
        textStr = typedArray.getString(R.styleable.SelfText_selftext_text);
        textsize = typedArray.getDimension(R.styleable.SelfText_selftext_textsize,12);
        textColor = typedArray.getColor(R.styleable.SelfText_selftext_textcolor,Color.BLACK);
        bgcolor = typedArray.getColor(R.styleable.SelfText_selftext_bgcolor,Color.BLACK);

        vprecent = typedArray.getFloat(R.styleable.SelfText_selftext_vprecent,0.45f);
        hprecent = typedArray.getFloat(R.styleable.SelfText_selftext_hprecent,0.65f);
        wdprecent = typedArray.getFloat(R.styleable.SelfText_selftext_wdprecent,0.7f);
        hgprecent = typedArray.getFloat(R.styleable.SelfText_selftext_hgprecent,0.65f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        LogUtil.d("w",DensityUtil.dip2px(context,100));
//        setMeasuredDimension(DensityUtil.dip2px(context,100),DensityUtil.dip2px(context,50));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int r = getMeasuredWidth() / 2;//也可以是getMeasuredHeight()/2,本例中我们已经将宽高设置相等了
//        //圆心的横坐标为当前的View的左边起始位置+半径
//        int centerX = getLeft() + r;
//        //圆心的纵坐标为当前的View的顶部起始位置+半径
//        int centerY = getTop() + r;
//
//        paint.setColor(Color.GREEN);
//        //开始绘制
//        canvas.drawCircle(centerX, centerY, r, paint);

        paint.setColor(bgcolor);
        paint.setStrokeWidth(DensityUtil.dip2px(context,2));
        float w = getMeasuredWidth();
        float h = getMeasuredHeight();

        LogUtil.d(w);LogUtil.d(h);

        float[] lefttoppoint = {0,h*vprecent};
        float[] righttoppoint = {w*(1-wdprecent),h*vprecent};
        float[] leftbottompoint = {0,h};
        float[] rightbottompoint = {w*hprecent,h};
        float[] rightcenterpoint = {w*hprecent,h*hgprecent};

        canvas.drawRect(w*(1-wdprecent),0,w,h*hgprecent,paint);
        canvas.drawLine(lefttoppoint[0],lefttoppoint[1],righttoppoint[0],righttoppoint[1],paint);
        canvas.drawLine(leftbottompoint[0],leftbottompoint[1],rightbottompoint[0],rightbottompoint[1],paint);
        canvas.drawLine(lefttoppoint[0],lefttoppoint[1],leftbottompoint[0],leftbottompoint[1],paint);
        canvas.drawLine(rightcenterpoint[0],rightcenterpoint[1],rightbottompoint[0],rightbottompoint[1],paint);

        paint.setColor(textColor);
        paint.setTextSize(textsize);
        paint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom

        canvas.drawText(textStr,w*(1-wdprecent/2),h*hgprecent/2- top/2 - bottom/2,paint);
    }
}
