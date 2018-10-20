package com.lht;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lht.demo.ObjectAnimatorActivity;
import com.lht.demo.ViewAnimatorActivity;
import com.lht.demo.XmlAnimatorActivity;

/**
 * @date 2018/10/20 0020
 */

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, XmlAnimatorActivity.class));
    }
}
