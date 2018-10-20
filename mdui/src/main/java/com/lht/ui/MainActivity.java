package com.lht.ui;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lht.libbase.activity.ActivityHelper;
import com.lht.libbase.activity.BaseActivity;

@Route(path="/ui/main")
public class MainActivity extends BaseActivity {
    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.activity_main);
        activityHelper.setBackType(ActivityHelper.BackType.MAIN);
    }

    public void click(View view) {
        ARouter.getInstance().build("/ui/main").navigation();
    }
}
