package com.lht.libbase.viewpage;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @date 2018/10/24 0024
 */

public class FinePagerAdapter<T extends View> extends PagerAdapter {

    private List<T> list;

    public FinePagerAdapter(List<T> list){
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
         container.addView(list.get(position));
         return list.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView(list.get(position));
    }
}
