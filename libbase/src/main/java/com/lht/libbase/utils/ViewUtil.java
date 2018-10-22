package com.lht.libbase.utils;

import android.view.View;

/**
 * @date 2018/10/22 0022
 */

public class ViewUtil {
    /**
     * 计算两个view的距离
     * @param v1
     * @param v2
     * @return 返回new int[2], [0]横坐标距离，[1]纵坐标的距离
     */
    public static int[] calculateWidgetsDistance(View v1, View v2){
        int[] location1 = new int[2];
        int[] location2 = new int[2];
        int[] ret = new int[2];

        v1.getLocationOnScreen(location1);
        v2.getLocationOnScreen(location2);

        ret[0] = Math.abs(location1[0] - location2[0]);
        ret[1] = Math.abs(location1[1] - location2[1]);
        return ret;
    }

    public static int[] getWidthHeight(View view){
        //手动调用测量方法。
        //制定测量规则 参数表示size + mode
        int  width =View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int  height =View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(width,height);
        //调用measure方法之后就可以获取宽高。
        height=view.getMeasuredHeight();
        width=view.getMeasuredWidth();
        return new int[]{width,height};
    }
}
