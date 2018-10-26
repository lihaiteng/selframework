package com.lht.libbase.selfview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.utils.ViewUtil;

/**
 * @date 2018/10/25 0025
 */

public class ShowTextView extends BaseSelfConstraintLayout {

    private View linetop,linebottom,lineright,lineleft;
    private TextView text;

    private String textStr;
    private int textColor,bgcolor;
    private float textsize;

    public ShowTextView(Context context) {
        super(context);
    }

    public ShowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initAttrs() {
        super.initAttrs();

        setTypeArray(R.styleable.ShowText);

        textStr = typedArray.getString(R.styleable.ShowText_showtext_text);
        textsize = typedArray.getDimension(R.styleable.ShowText_showtext_textsize,12);
        textColor = typedArray.getColor(R.styleable.ShowText_showtext_textcolor,Color.BLACK);
        bgcolor = typedArray.getColor(R.styleable.ShowText_showtext_bgcolor,Color.BLACK);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setView(R.layout.selfview_showtext);

        linetop = findViewById(R.id.linetop);
        linebottom = findViewById(R.id.linebottom);
        lineright = findViewById(R.id.lineright);
        lineleft = findViewById(R.id.lineleft);
        text = findViewById(R.id.text);

        text.setText(textStr);
        text.getPaint().setTextSize(textsize);
        text.setTextColor(textColor);
        setColor(bgcolor);

    }

    public ShowTextView setColor(int color){
        linetop.setBackgroundColor(color);
        linebottom.setBackgroundColor(color);
        lineright.setBackgroundColor(color);
        lineleft.setBackgroundColor(color);
        text.setBackgroundColor(color);
        return this;
    }

    public ShowTextView setColor(String color){
        linetop.setBackgroundColor(ViewUtil.parseColor(color));
        linebottom.setBackgroundColor(ViewUtil.parseColor(color));
        lineright.setBackgroundColor(ViewUtil.parseColor(color));
        lineleft.setBackgroundColor(ViewUtil.parseColor(color));
        text.setBackgroundColor(ViewUtil.parseColor(color));
        return this;
    }

    public ShowTextView setTextColor(int color){
        text.setTextColor(color);
        return this;
    }

    public ShowTextView setTextSize(float size){
        text.setTextSize(size);
        return this;
    }
}
