package com.w77996.superapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.w77996.superapp.fragment.MainFragment;
import com.w77996.superapp.fragment.UserFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    FrameLayout mMainFramgLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    MainFragment mMainFragment;
    UserFragment mUserFragment;

    LinearLayout mMainLinearLayout;
    LinearLayout mUserLinearLayout;

    TextView mHomeTv;
    TextView mUserTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initView(){
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mMainFramgLayout = (FrameLayout) findViewById(R.id.main_fragment);
        mMainLinearLayout = (LinearLayout)findViewById(R.id.nav_main);
        mUserLinearLayout = (LinearLayout)findViewById(R.id.nav_user);
        mHomeTv = (TextView)findViewById(R.id.tv_home);
        mUserTv = (TextView)findViewById(R.id.tv_user);
        mMainLinearLayout.setOnClickListener(this);
        mUserLinearLayout.setOnClickListener(this);
        Drawable drawable= getResources().getDrawable(R.drawable.home_select);
        //在左侧添加图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mHomeTv.setCompoundDrawables(null, drawable, null, null);
        mHomeTv.setTextColor(getResources().getColor(R.color.main_title_color));

    }
    private void initFragment(){
        mMainFragment = mMainFragment.getInstance();
        if(!mMainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, mMainFragment,"MainFragment").commit();
            /*mNavTranslateImage.setBackgroundResource(R.drawable.translate_btn_select);
            mNavTranslateText.setTextColor(getResources().getColor(R.color.main_title_color));*/
        }
    }
    private void showFragment(int id){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (id){
            case R.id.nav_main:
                hideFragment(transaction);
                if(mMainFragment == null){
                    mMainFragment = mMainFragment.getInstance();
                    transaction.add(R.id.main_fragment, mMainFragment);
                }
                transaction.show(mMainFragment);
                transaction.commit();
                Drawable drawable= getResources().getDrawable(R.drawable.home_select);
                //在左侧添加图片
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                mHomeTv.setCompoundDrawables(null, drawable, null, null);
                mHomeTv.setTextColor(getResources().getColor(R.color.main_title_color));
                break;
            case R.id.nav_user:
                hideFragment(transaction);
                if(mUserFragment == null){
                    mUserFragment = mUserFragment.getInstance();
                    transaction.add(R.id.main_fragment, mUserFragment);
                }
                transaction.show(mUserFragment);
                transaction.commit();
                Drawable drawable2= getResources().getDrawable(R.drawable.user_select);
                //在左侧添加图片
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                mUserTv.setCompoundDrawables(null, drawable2, null, null);
                mUserTv.setTextColor(getResources().getColor(R.color.main_title_color));
                break;
        }
    }
    private void hideFragment(FragmentTransaction transaction){
        if(mMainFragment !=null){
            transaction.hide(mMainFragment);
        }
        if(mUserFragment !=null){
            transaction.hide(mUserFragment);
        }
        Drawable drawable= getResources().getDrawable(R.drawable.home);
        //在左侧添加图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mHomeTv.setCompoundDrawables(null, drawable, null, null);
        Drawable drawable2= getResources().getDrawable(R.drawable.user);
        //在左侧添加图片
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        mUserTv.setCompoundDrawables(null, drawable2, null, null);
        mHomeTv.setTextColor(Color.parseColor("#616161"));
        mUserTv.setTextColor(Color.parseColor("#616161"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_main:
                Log.d("dfasd","main");

                showFragment(R.id.nav_main);
                break;
            case R.id.nav_user:
                Log.d("dfasd","user");
                showFragment(R.id.nav_user);
                break;
        }
    }
}
