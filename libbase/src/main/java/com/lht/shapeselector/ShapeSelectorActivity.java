package com.lht.shapeselector;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbase.utils.DensityUtil;
import com.lht.libbase.utils.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date 2018/10/25 0025
 */

public class ShapeSelectorActivity extends BaseActivity {

    private TextView shape;
    private Button both;

    @Override
    protected void beforeCreate() {
        super.beforeCreate();
    }

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.shapeslct_base);
        shape = findViewById(R.id.shape);
        both = findViewById(R.id.both);
    }

    public void shapea(View view) {
        GradientDrawable myGrad = (GradientDrawable)shape.getBackground();
        myGrad.setStroke(DensityUtil.dip2px(context,5.0f),Color.YELLOW
                ,DensityUtil.dip2px(context,10.0f)
                ,DensityUtil.dip2px(context,20.0f));
    }

    public void clickforoth(View view) {
        LogUtil.d("clickforoth");

    }
}
