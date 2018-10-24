package com.lht.libbase.viewpage;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @date 2018/10/24 0024
 */

public class FineFragmentPagerAdapter<T extends Fragment> extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;
    private String[] pageTitles;

    public FineFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public FineFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList, String[] pageTitles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.pageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles==null?pageTitles[position]:super.getPageTitle(position);
    }
}
