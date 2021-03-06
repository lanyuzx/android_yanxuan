package com.lingyun.yanxuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

import android.os.Bundle;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lingyun.yanxuan.base.BaseActivity;
import com.lingyun.yanxuan.classes.category.CategoryFragement;
import com.lingyun.yanxuan.classes.home.HomeFragement;
import com.lingyun.yanxuan.classes.mine.MineFragement;
import com.lingyun.yanxuan.classes.shopping.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;

    private static List<Fragment> mFragmentList = new ArrayList<>();

    private static  List<BottomNavigationItem> mNavigationItemList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected void setupView() {
        setupBottomNavBar();
    }

    private void setupBottomNavBar() {
        mFragmentList.add(new HomeFragement());
        mFragmentList.add(new CategoryFragement());
        mFragmentList.add(new ShoppingFragment());
        mFragmentList.add(new MineFragement());

        mNavigationItemList.add(new BottomNavigationItem(R.mipmap.ic_tabbar_home,"首页").setInactiveIconResource(R.mipmap.ic_tabbar_home_normal));
        mNavigationItemList.add(new BottomNavigationItem(R.mipmap.ic_tabbar_category,"分类").setInactiveIconResource(R.mipmap.ic_tabbar_category_normal));
        mNavigationItemList.add(new BottomNavigationItem(R.mipmap.ic_tabbar_shopping,"发现").setInactiveIconResource(R.mipmap.ic_tabbar_shopping_normal));
        mNavigationItemList.add(new BottomNavigationItem(R.mipmap.ic_tabbar_mine,"我的").setInactiveIconResource(R.mipmap.ic_tabbar_mine_normal));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mFragmentList.get(0), "home")
                .add(R.id.main_container, mFragmentList.get(1), "message")
                .add(R.id.main_container, mFragmentList.get(2), "discover")
                .add(R.id.main_container, mFragmentList.get(3), "mine")
                .hide(mFragmentList.get(1))
                .hide(mFragmentList.get(2))
                .hide(mFragmentList.get(3))
                .show(mFragmentList.get(0))
                .commit();

        mBottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED) // 设置mode
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)  // 背景样式
                .setBarBackgroundColor(R.color.AppColor) // 背景颜色
                .setInActiveColor("#999999") // 未选中状态颜色
                .setActiveColor("#ffffff") // 选中状态颜色
                .addItem(mNavigationItemList.get(0)) // 添加Item
                .addItem(mNavigationItemList.get(1))
                .addItem(mNavigationItemList.get(2))
                .addItem(mNavigationItemList.get(3))
                .setFirstSelectedPosition(0) //设置默认选中位置
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        for (int i = 0 ;i< mFragmentList.size();i++) {
                            Fragment fragment =  mFragmentList.get(i);
                            if (position == i) {
                                getSupportFragmentManager().beginTransaction().show(fragment).commit();
                            }else  {
                                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
                            }
                        }
                    }

                    @Override
                    public void onTabUnselected(int position) {

                    }

                    @Override
                    public void onTabReselected(int position) {

                    }
                })
                .initialise();  // 提交初始化（完成配置）
    }


}
