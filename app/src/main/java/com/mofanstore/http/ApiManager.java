package com.mofanstore.http;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 */
public class ApiManager {


    private static ApiManager mInstance;
    private static ApiManager mInstance2;

    private ApiService mApiService;

    public ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

                .client(OkHttpUtils.getInstance())

                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public ApiManager(String url) {
        Gson gson = new GsonBuilder().setLenient().create();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //特别注意下载大文件时千万不要打开下面注释代码 否则会导致OOM
        //.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(OkHttpUtils.getInstance())
                .callbackExecutor(executorService) //默认CallBack回调在主线程进行,当设置下载大文件时需设置注解@Stream 不加这句话会报android.os.NetworkOnMainThreadException
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    //单例模式
    public static ApiService getService() {
        if (mInstance == null) {
            mInstance = new ApiManager();
        }
        return mInstance.mApiService;
    }

    //单例模式
    public static ApiService getService(String url) {
        if (mInstance2 == null) {
            mInstance2 = new ApiManager(url);
        }
        return mInstance2.mApiService;
    }

}
