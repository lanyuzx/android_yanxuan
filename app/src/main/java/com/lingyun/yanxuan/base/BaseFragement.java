package com.lingyun.yanxuan.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Optional;
import butterknife.Unbinder;

public abstract class BaseFragement extends Fragment {

    public static Context mContext;
    private Unbinder mUnbinder;
    public  Integer mPageIndex = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(getLayoutId(),container,false);
        mContext = getContext();
        mUnbinder = ButterKnife.bind(this,view);
        setupView();
        setupData();
        return  view;
    }

    /**
     * 布局id
     *
     * @return id
     */
    protected abstract int getLayoutId();

    @Optional
    protected abstract void  setupData();

    protected abstract void setupView();

    protected void toActivity(Class clazz){
        Intent intent = new Intent(mContext, clazz);
        startActivity(intent);
    }
}
