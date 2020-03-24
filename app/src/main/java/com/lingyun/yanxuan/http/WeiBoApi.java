package com.lingyun.yanxuan.http;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface WeiBoApi {
    public final String baseUrl = "https://api.weibo.com/";

    @GET("2/statuses/home_timeline.json")
    Observable<Response<Object>> homeTimeLine(@QueryMap Map<String,Object> map);

}
