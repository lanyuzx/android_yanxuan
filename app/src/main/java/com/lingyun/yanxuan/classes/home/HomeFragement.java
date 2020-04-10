package com.lingyun.yanxuan.classes.home;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lingyun.yanxuan.R;
import com.lingyun.yanxuan.base.BaseApp;
import com.lingyun.yanxuan.base.BaseBean;
import com.lingyun.yanxuan.base.BaseFragement;
import com.lingyun.yanxuan.classes.home.adpater.HomeGridAdapter;
import com.lingyun.yanxuan.classes.home.bean.HomeBean;
import com.lingyun.yanxuan.http.Http;
import com.lingyun.yanxuan.utils.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import io.reactivex.functions.Consumer;

public class HomeFragement  extends BaseFragement {
    @BindView(R.id.home_banner_view)
    Banner mBanner;
    @BindView(R.id.home_searchbg_view)
    LinearLayout  mSearchBGView;
    @BindView(R.id.home_grid_recyclerView)
    RecyclerView mGridRecyclerView;

    private HomeBean mHomeBean;

    private HomeGridAdapter mGridAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setupData() {

        Http.homeIndex().subscribe(new Consumer<BaseBean<HomeBean>>() {
            @Override
            public void accept(BaseBean<HomeBean> homeBean) throws Exception {
                LogUtil.e(homeBean.toString());
               if (homeBean.getCode() == 200) {
                   mHomeBean = homeBean.getData();
                   setupBannerData();
                   mGridAdapter.addData(mHomeBean.getKingKongAreaV4());
                   mGridAdapter.addData(mHomeBean.getKingKongAreaV4());
               }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.e(throwable.toString());
            }
        });

    }

    @Override
    protected void setupView() {
        setupBanner();
        setupGridView();
    }

    private void  setupBanner() {
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new BannerImageLoad());
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSearchBGView.setBackgroundColor(Color.parseColor(mHomeBean.getFocus().get(position).getBackgroundColor()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setupGridView() {
        mGridAdapter = new HomeGridAdapter(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2,RecyclerView.HORIZONTAL,false);
        mGridRecyclerView.setLayoutManager(gridLayoutManager);
        mGridRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mGridRecyclerView.setAdapter(mGridAdapter);

    }
    private void setupBannerData() {
        List bannerUrls = new ArrayList();
        for (HomeBean.HomeFocusBean focusBean : mHomeBean.getFocus()) {
            bannerUrls.add(focusBean.getImg());
        }
        mBanner.setImages(bannerUrls);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private class BannerImageLoad extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
