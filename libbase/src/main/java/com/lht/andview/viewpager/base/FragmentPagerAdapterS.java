package com.lht.andview.viewpager.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @date 2018/10/23 0023
 */

public class FragmentPagerAdapterS extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public FragmentPagerAdapterS(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }
}
