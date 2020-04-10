package com.lingyun.yanxuan.classes.home.adpater;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingyun.yanxuan.R;
import com.lingyun.yanxuan.classes.home.bean.HomeBean;
import com.lingyun.yanxuan.utils.LogUtil;

import java.util.List;

import androidx.annotation.Nullable;

public class HomeGridAdapter extends BaseQuickAdapter<HomeBean.HomeKingKongAreaV4Bean, BaseViewHolder> {

    public HomeGridAdapter(@Nullable List<HomeBean.HomeKingKongAreaV4Bean> data) {
        super(R.layout.layout_home_grid, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.HomeKingKongAreaV4Bean item) {

        ImageView imageView = helper.getView(R.id.home_grid_image_view);
        Glide.with(mContext).load(item.getPicUrls().get(0)).into(imageView);
        TextView textView = helper.getView(R.id.home_grid_image_text_view);
        textView.setText(item.getTitle());
    }
}
