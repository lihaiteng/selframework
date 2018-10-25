package com.lht.libbasetest.selfview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.selfview.BaseSelfConstraintLayout;

/**
 * @date 2018/10/25 0025
 */

public class TestShowTextView extends BaseSelfConstraintLayout {

    private View linetop,linebottom,lineright,lineleft;
    private TextView text;

    public TestShowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeArray(R.styleable.testshowtext);
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
    }

    public TestShowTextView setColor(String color){
        linetop.setBackgroundColor(Color.RED);
        linebottom.setBackgroundColor(Color.RED);
        lineright.setBackgroundColor(Color.RED);
        lineleft.setBackgroundColor(Color.RED);
        text.setBackgroundColor(Color.RED);
        return this;
    }
}
