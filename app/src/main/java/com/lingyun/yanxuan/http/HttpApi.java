package com.lingyun.yanxuan.http;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HttpApi {
    public final String baseUrl = "https://miniapp.you.163.com/xhr/";
    public final String baseUserUrl = "https://m.you.163.com/pin/min/";

    @GET("2/statuses/home_timeline.json")
    Observable<Response<Object>> homeTimeLine(@QueryMap Map<String,Object> map);

}


/*
*
* //首页
const String api_home = '/index/index.json';//首页
const String api_search_count = '/search/displayBar.json';//搜索条数量
const String api_rec = '/rcmd/index.json';//首页推荐
const String api_group = '/item/recommendV2.json';//团购

//商品详情
const String api_goods_detail = '/item/detail.json';//商品详情

//分类
const String api_bigCategory = '/list/categorySimple.json';//大类
const String api_subCategory = '/list/subCate.json';//子类

//购物车
const String api_cart = '/promotionCart/getCarts.json';//购物车

//个人中心
const String api_mine = '/user/getDetail.json';//用户信息
const String api_mine_grid = '/user/gridList.json';//选项
const String api_mine_money = '/user/myFund.json';//资产
* */