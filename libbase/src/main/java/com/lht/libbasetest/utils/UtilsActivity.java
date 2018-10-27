package com.lht.libbasetest.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbase.utils.LogUtil;
import com.lht.libbase.utils.SharedpreferencesUtil;
import com.lht.libbasetest.bean.TestBean;

import java.util.ArrayList;

/**
 * @date 2018/10/27 0027
 */

public class UtilsActivity extends BaseActivity {
    SharedpreferencesUtil spUtil;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_util_sp);
        spUtil = new SharedpreferencesUtil(context,"libsp");

        TestBean bean = new TestBean();
        bean.age = 18;
        bean.name = null;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Petter");
        arrayList.add("Chalise");
        arrayList.add("Aliess");
        bean.arrayList = arrayList;
        spUtil.setEntity("one",bean);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
        spUtil.setBitmap("img",bitmap, Bitmap.CompressFormat.PNG,50);
    }

    public void one(View view){
        TestBean bean = (TestBean)spUtil.getEntity("one");
        LogUtil.d("bean",bean.age+"<--->"+bean.name+"<--->"+bean.arrayList.get(0)+"<--->"+bean.arrayList.get(1)+"<--->"+bean.arrayList.get(2));

        Bitmap bean2 = (Bitmap)spUtil.getBitmap("img");
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageBitmap(bean2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy");
    }
}
