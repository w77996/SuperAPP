package com.w77996.superapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.w77996.superapp.fragment.LoginFragment;
import com.w77996.superapp.utils.Utils;

/**
 * time:2018/1/4
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class LoginActivity extends FragmentActivity {

    FrameLayout mMainFramgLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    LoginFragment mLoginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initFragment();
    }

    private void initView(){
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mMainFramgLayout = (FrameLayout) findViewById(R.id.fragment_login);
        Utils.setWindowStatusBarColor(LoginActivity.this,getResources().getColor(R.color.main_title_color));

    }
    private void initFragment(){
        mLoginFragment = mLoginFragment.getInstance();
        if(!mLoginFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_login, mLoginFragment,"MainFragment").commit();
        }

    }
}
