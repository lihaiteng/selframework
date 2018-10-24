package com.lht.andview.viewpager.base;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbasetest.fragment.FragmentY;
import com.lht.libbasetest.fragment.FragmentX;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2018/10/23 0023
 */

public class ViewPagerAcitivty extends BaseActivity {

    private ViewPager viewPager,viewPager2,viewPager3;

    private LayoutInflater inflater;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.andview_viewpager);

        viewPager = findViewById(R.id.viewpager);
        viewPager2 = findViewById(R.id.viewpager2);
        viewPager3 = findViewById(R.id.viewpager3);

        inflater = LayoutInflater.from(context);

        initViewPager();
        initViewPager2();
        initViewPager3();
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        FragmentX fa = new FragmentX();
        FragmentX fb = new FragmentX();
        FragmentX fc = new FragmentX();
        FragmentX fd = new FragmentX();
        FragmentX fe = new FragmentX();
        FragmentX ff = new FragmentX();
        FragmentX fg = new FragmentX();

        fa.setTag("A");
        fb.setTag("B");
        fc.setTag("C");
        fd.setTag("D");
        fe.setTag("E");
        ff.setTag("F");
        fg.setTag("G");

        fragments.add(fa);
        fragments.add(fb);
        fragments.add(fc);
        fragments.add(fd);
        fragments.add(fe);
        fragments.add(ff);
        fragments.add(fg);

//        FragmentPagerAdapterS adapterS = new FragmentPagerAdapterS(getSupportFragmentManager(),fragments);
        FragmentStatePagerAdapterS adapterS = new FragmentStatePagerAdapterS(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterS);

        viewPager.setOffscreenPageLimit(3);

//        viewPager.setPageTransformer(true,new RotPageTransformer());
        viewPager.setPageTransformer(true,new ScalePageTransformer());
    }

    private void initViewPager2() {
        List<View> views = new ArrayList<>();
        View va = inflater.inflate(R.layout.andview_viewpager_layouta,null);
        View vb = inflater.inflate(R.layout.andview_viewpager_layoutb,null);
        va.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"a",Toast.LENGTH_SHORT).show();
            }
        });
        views.add(va);
        views.add(vb);
        PagerAdapterS adapterS = new PagerAdapterS(views);
        viewPager2.setAdapter(adapterS);
    }

    private void initViewPager3() {
        List<Fragment> fragments = new ArrayList<>();
        FragmentY fa = new FragmentY();
        FragmentX fb = new FragmentX();
        fragments.add(fa);
        fragments.add(fb);
        FragmentStatePagerAdapterS adapterS = new FragmentStatePagerAdapterS(getSupportFragmentManager(),fragments);
        viewPager3.setAdapter(adapterS);

        viewPager3.setPageTransformer(true,new RotPageTransformer());
    }

}
