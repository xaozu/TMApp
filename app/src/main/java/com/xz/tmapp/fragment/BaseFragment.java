package com.xz.tmapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by xaozu on 15/8/11.
 * 所有fragment的父类
 */
public abstract class BaseFragment extends Fragment {
    public View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(getLayoutView(),container,false);
        ButterKnife.inject(this, mView);
        return mView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
    //得到页面布局
    protected abstract int getLayoutView();
}
