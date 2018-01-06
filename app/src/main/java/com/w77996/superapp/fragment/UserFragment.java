package com.w77996.superapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.w77996.superapp.FeedBackActivity;
import com.w77996.superapp.R;
import com.w77996.superapp.UserActivity;

/**
 * time:2018/1/4
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class UserFragment extends Fragment {
    public static  UserFragment mInstance;
    ImageView mUser;
    LinearLayout mFeedBackLinear;
    private Context mContext;
    public static UserFragment getInstance() {
        if (mInstance == null) {
            synchronized (UserFragment.class) {
                if (mInstance == null) {
                    mInstance = new UserFragment();
                }
            }
        }
        return mInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_user,container,false);

        initView(view);
       /* initOnClick();*/

        return view;
    }

    private void initView(View view) {
        mUser = (ImageView)view.findViewById(R.id.user_head);
        mFeedBackLinear = (LinearLayout)view.findViewById(R.id.linear_feedback);
        mFeedBackLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedBackActivity.class);
                startActivity(intent);
            }
        });
        mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
