package com.lht.framework.main;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lht.framework.Contacts;
import com.lht.framework.R;
import com.lht.libbase.activity.ActivityHelper;
import com.lht.libbase.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Route(path="/app/main/main")
public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<MainBean> data;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.main_activity);
        activityHelper.setBackType(ActivityHelper.BackType.MAIN);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        data = new ArrayList<>();
        for (Map.Entry<String, String> entry : Contacts.targetActivitys.entrySet()) {
            data.add(new MainBean(entry.getKey(),entry.getValue()));
        }
        adapter = new MainAdapter(getApplicationContext(),data);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator( new DefaultItemAnimator());
    }
}
