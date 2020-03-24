package com.lingyun.yanxuan;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

import android.os.Bundle;
import android.widget.TextView;

import com.lingyun.yanxuan.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text_tielte)
    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected void setupView() {
        textView.setText("我抢票囖二纺机grew开起来");
    }
}
