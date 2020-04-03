package com.lingyun.yanxuan.classes.home;
import com.lingyun.yanxuan.R;
import com.lingyun.yanxuan.base.BaseBean;
import com.lingyun.yanxuan.base.BaseFragement;
import com.lingyun.yanxuan.classes.home.bean.HomeBean;
import com.lingyun.yanxuan.http.Http;
import com.lingyun.yanxuan.utils.LogUtil;

import io.reactivex.functions.Consumer;

public class HomeFragement  extends BaseFragement {
//    @BindView(R.id.home_search_view)
//    SearchView mEditText;
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

    }
}
