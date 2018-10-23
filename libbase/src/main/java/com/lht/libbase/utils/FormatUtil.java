package com.lht.libbase.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class FormatUtil {

    public enum TimeFormatEnum{
        ALL("yyyy-MM-dd HH:mm:ss"), WithoutSecond("yyyy-MM-dd HH:mm"), Simple("MM-dd HH:mm");

        private String format;

        // 构造方法
        private TimeFormatEnum(String format) {
            this.format = format;
        }

        //覆盖方法
        @Override
        public String toString() {
            return this.format;
        }

    }

    /**
     * 保留小数
     */
    public static String moneyFormat(String money,int keep){

        BigDecimal bigDecimal = new BigDecimal(money).setScale(keep, ROUND_HALF_UP);

        return bigDecimal.toString();

    }

    /**
     * 时间格式
     */
    public static String timeFormat(String millisecond,TimeFormatEnum format){

        SimpleDateFormat sdf = new SimpleDateFormat(format.toString());

        Date time = new Date(Long.valueOf(millisecond)*1000);

        return sdf.format(time);

    }
}
