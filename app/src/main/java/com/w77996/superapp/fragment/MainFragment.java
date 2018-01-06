package com.w77996.superapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.w77996.superapp.R;

import org.w3c.dom.Text;

/**
 * time:2018/1/4
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class MainFragment extends Fragment {

    public static  MainFragment mInstance;
    ImageView mAddDevImage;
    LinearLayout mHomeADDLinearLayout;
    LinearLayout mDevListLinearLayout;
    TextView mBack;
    boolean isDevList = false;
    private Context mContext;
    public static MainFragment getInstance() {
        if (mInstance == null) {
            synchronized (MainFragment.class) {
                if (mInstance == null) {
                    mInstance = new MainFragment();
                }
            }
        }
        return mInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_main,container,false);

       initView(view);

        /*initOnClick();*/

        return view;
    }

    private void initView(View view) {

        mAddDevImage = (ImageView)view.findViewById(R.id.tv_text);
        mHomeADDLinearLayout = (LinearLayout)view.findViewById(R.id.linear_home_add);
        mDevListLinearLayout = (LinearLayout)view.findViewById(R.id.linear_home_devlist);
        mBack = (TextView) view.findViewById(R.id.home_back);
        mAddDevImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hideFragment();
               // showDevList();
                mHomeADDLinearLayout.setVisibility(View.GONE);
                mDevListLinearLayout.setVisibility(View.VISIBLE);
                isDevList = true;
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDevList){
                    mHomeADDLinearLayout.setVisibility(View.VISIBLE);
                    mDevListLinearLayout.setVisibility(View.GONE);
                }else{
                    getActivity().finish();
                }
            }
        });
    }



}
