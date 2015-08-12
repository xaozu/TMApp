package com.xz.tmapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.xz.tabnavigate_lib.TabNavigateLayout;
import com.xz.tmapp.R;
import com.xz.tmapp.fragment.IndexFragment;
import com.xz.tmapp.fragment.ItemFragment;

import butterknife.InjectView;

public class MainActivity extends BaseActivity implements TabNavigateLayout.OnItemSelectedListener {
    @InjectView(R.id.tabNavigateLayout1)
    TabNavigateLayout tabNavigateLayout1;
    @InjectView(R.id.container)
    FrameLayout container;

    private FragmentManager fragmentManageer;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        tabNavigateLayout1.setOnItemSelectedListener(this);
        beginTransaction(new IndexFragment(),1);
    }


    @Override
    public void OnItemSelected(View v, int position) {
        beginTransaction(new ItemFragment(position),1);
    }

    /**
     * @param fragment
     *            要切换的fragment
     * @param addOrReplace
     *            当为了0 时候是添加 1为替换
     */
    private void beginTransaction(Fragment fragment, int addOrReplace) {
        if (null == fragmentManageer) {
            fragmentManageer = getSupportFragmentManager();
        }
        fragmentTransaction = fragmentManageer.beginTransaction();
        if (addOrReplace == 0) {
            fragmentTransaction.add(R.id.container, fragment);
        } else if (addOrReplace == 1) {
            fragmentTransaction
                    .replace(R.id.container, fragment);
        }
        fragmentTransaction.commit();
    }
}
