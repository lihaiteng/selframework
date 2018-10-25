package com.lht.libbase.selfview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by bockey on 2017/1/21.
 */
public class BaseSelfConstraintLayout extends ConstraintLayout{

    protected Context context;

    protected View view;

    protected LayoutInflater inflater;

    protected TypedArray typedArray;

    protected AttributeSet attrs;

    public BaseSelfConstraintLayout(Context context) {
        this(context,null);
    }

    public BaseSelfConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);
    }

    protected void init(Context context, AttributeSet attrs) {

        this.context = context;

        this.attrs = attrs;

        inflater = LayoutInflater.from(context);

    }

    public void setTypeArray(int[] styleAttr){

        typedArray = context.obtainStyledAttributes(attrs,styleAttr);

    }

    public void setView(int layout){

        view = inflater.inflate(layout,this,true);

    }


}
