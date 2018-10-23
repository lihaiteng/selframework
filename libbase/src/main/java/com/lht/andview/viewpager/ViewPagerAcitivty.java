package com.lht.andview.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.lht.libbase.R;
import com.lht.libbase.activity.BaseActivity;
import com.lht.libbasetest.fragment.FragmentA;
import com.lht.libbasetest.fragment.FragmentB;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2018/10/23 0023
 */

public class ViewPagerAcitivty extends BaseActivity {

    private ViewPager viewPager,viewPager2;

    private LayoutInflater inflater;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.andview_viewpager);

        viewPager = findViewById(R.id.viewpager);
        viewPager2 = findViewById(R.id.viewpager2);

        inflater = LayoutInflater.from(context);

        initViewPager();
        initViewPager2();
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        FragmentA fa = new FragmentA();
        FragmentB fb = new FragmentB();
        fragments.add(fa);
        fragments.add(fb);
        FragmentPagerAdapterS adapterS = new FragmentPagerAdapterS(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterS);

        viewPager.setPageTransformer(true,new RotPageTransformer());
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

}
