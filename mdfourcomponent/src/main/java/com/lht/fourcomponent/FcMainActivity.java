package com.lht.fourcomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path="/fourcomponent/main")
public class FcMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fc_main_activity);
    }

    public void click(View view) {
        ARouter.getInstance().build("/fourcomponent/main").navigation();
    }
}
