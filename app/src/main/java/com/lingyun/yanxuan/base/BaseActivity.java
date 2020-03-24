package com.lingyun.yanxuan.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;
import butterknife.Optional;
import butterknife.Unbinder;

public abstract class BaseActivity extends  FragmentActivity{

    public static Context mContext;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        QMUIStatusBarHelper.translucent(this);
        mContext = this;
        mUnbinder = ButterKnife.bind(this);
        setupView();
        setupData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
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
