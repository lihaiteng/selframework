package com.lht.libbasetest.activity;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseMainActivity;
import com.lht.libbasetest.fragment.FragmentY;
import com.lht.libbasetest.fragment.FragmentX;

/**
 * Created by bockey on 2017/2/4.
 */
public class TestMainActivity extends BaseMainActivity {

    @Override
    protected void initTabBar() {
        super.initTabBar();
        setFragments(new Class[]{FragmentY.class, FragmentX.class});
        setTexts(new String[]{"A", "B"});
        setImgs(new int[]{R.drawable.activity_fragments_spec_img, R.drawable.activity_fragments_spec_img});
        setBadgeParam(R.color.white, R.color.red, 10f);
        setSpecViewID(R.layout.activity_main_view_tabspec, R.id.img, R.id.text, R.id.badgeRel);
    }

    @Override
    protected void initView(){
        super.initView();
        setLayoutID(R.layout.activity_main, R.id.fragmentsLayout, R.id.tabHost);

    }

    @Override
    protected void control() {
        super.control();
        setBadge(0, 0);
        setBadge(1, 1);

    }

    @Override
    protected void doTabChanged(String tabId) {
        super.doTabChanged(tabId);
    }
}
