package com.xz.tmapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by xaozu on 15/8/11.
 * 所有页面的父类
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ButterKnife.inject(this);
        initView();

    }

    //初始化布局
    protected abstract void initView();
    //得到页面布局
    protected abstract int getLayoutView();
}
