package com.lht.libbasetest.activity;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseFragmentActivity;
import com.lht.libbasetest.fragment.FragmentA;
import com.lht.libbasetest.fragment.FragmentB;

/**
 * Created by bockey on 2017/2/4.
 */
public class TestFragmentMainActivity extends BaseFragmentActivity {

    @Override
    protected void initTabBar() {
        super.initTabBar();
        setFragments(new Class[]{FragmentA.class, FragmentB.class});
        setTexts(new String[]{"A", "B"});
        setImgs(new int[]{R.drawable.activity_fragments_spec_img, R.drawable.activity_fragments_spec_img});
        setBadgeParam(R.color.white, R.color.red, 10f);
        setSpecViewID(R.layout.activity_fragments_view_tabspec, R.id.img, R.id.text, R.id.badgeRel);
    }

    @Override
    protected void initView(){
        super.initView();
        setLayoutID(R.layout.activity_fragments_home, R.id.fragmentsLayout, R.id.tabHost);

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
