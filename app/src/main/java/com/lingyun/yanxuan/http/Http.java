package com.lingyun.yanxuan.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lingyun.yanxuan.base.BaseBean;
import com.lingyun.yanxuan.classes.home.bean.HomeBean;
import com.lingyun.yanxuan.utils.LogUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {


    private static HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try {
                    message  = message.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
                    String text = URLDecoder.decode(message, "utf-8");
                    LogUtil.e("OKHttp-----", text);
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.e("OKHttp-----", message);
                }
            }
        });
        //这里可以builder(). 添加更多的内容 具体看需求
//        mClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        //这行必须加 不然默认不打印
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  interceptor;
    }

//    //这行必须加 不然默认不打印

    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor())
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                            .build();
                    return chain.proceed(request);
                }
            })
            .build();
   private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit mRetrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl(HttpApi.baseUrl)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create(gson))//设置 Json 转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 适配器
            .build();


     public static Observable<BaseBean<HomeBean>> homeIndex() {
         return mRetrofit.create(HttpApi.class)
                 .homeIndex()
                 .subscribeOn(Schedulers.io())
                 .compose(ResponseTransformer.handleResult())
                 .observeOn(AndroidSchedulers.mainThread());
    }


}
