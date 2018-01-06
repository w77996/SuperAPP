package com.w77996.superapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.w77996.superapp.MainActivity;
import com.w77996.superapp.R;

/**
 * time:2018/1/5
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class LoginFragment extends Fragment {

    public static  LoginFragment mInstance;
    EditText mLoginNameEditText;
    EditText mLoginPwdEditText;
    ImageView mLoginBtn;
    ImageView mRegistPwd;
    private Context mContext;
    public static LoginFragment getInstance() {
        if (mInstance == null) {
            synchronized (LoginFragment.class) {
                if (mInstance == null) {
                    mInstance = new LoginFragment();
                }
            }
        }
        return mInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_login,container,false);

        initView(view);

        return view;
    }



    private void initView(View view) {
        mLoginNameEditText = (EditText)view.findViewById(R.id.ed_login_username);

        mLoginPwdEditText = (EditText)view.findViewById(R.id.ed_login_pwd);
        mLoginPwdEditText.setCompoundDrawablePadding(5);
        mLoginNameEditText.setCompoundDrawablePadding(5);
        mLoginBtn = (ImageView) view.findViewById(R.id.btn_login);
        mRegistPwd = (ImageView) view.findViewById(R.id.btn_regist);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mRegistPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
