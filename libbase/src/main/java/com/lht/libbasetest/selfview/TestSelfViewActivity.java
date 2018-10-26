package com.lht.libbasetest.selfview;

import android.view.View;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbase.selfview.ShowTextView;

/**
 * @date 2018/10/25 0025
 */

public class TestSelfViewActivity extends BaseActivity {

    ShowTextView text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.selfview_activity);
        text = findViewById(R.id.showtext);
    }

    public void btn(View view) {
        text.setColor("#00ff00");
    }
}
