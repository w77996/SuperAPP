package com.w77996.superapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.superapp.R;

/**
 * time:2018/1/5
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class DevListFragment extends Fragment {
    public static DevListFragment mInstance;
    public static DevListFragment getInstance() {
        if (mInstance == null) {
            synchronized (DevListFragment.class) {
                if (mInstance == null) {
                    mInstance = new DevListFragment();
                }
            }
        }
        return mInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_devlist,container,false);

        initView(view);

        return view;
    }

    private void initView(View view) {

    }

}
