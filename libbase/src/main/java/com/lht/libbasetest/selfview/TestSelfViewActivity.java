package com.lht.libbasetest.selfview;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;

/**
 * @date 2018/10/25 0025
 */

public class TestSelfViewActivity extends BaseActivity {

    TestShowTextView text;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.selfview_activity);
        text = findViewById(R.id.showtext);
        text.setColor("");
    }
}
