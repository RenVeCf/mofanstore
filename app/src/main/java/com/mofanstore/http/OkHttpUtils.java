package com.mofanstore.http;

import android.content.SharedPreferences;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by lizetong on 15/8/27.
 */
public class OkHttpUtils {
    public static SharedPreferences sp=null;
    private final static long HTTP_CONNECT_TIMEOUT = 30;
    private static OkHttpClient singleton;
    static   boolean debug=true;
    private final static long DEFAULT_TIMEOUT=30;
    public static OkHttpClient getInstance() {
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {
                    //定义logging
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();

                   //缓存
//                    sp = Application.getInstance().getSharedPreferences("legeUserInfo", Application.getInstance().MODE_PRIVATE);
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                                .retryOnConnectionFailure(true)
//                                .addInterceptor(new Interceptor() {
//                                @Override
//                                public okhttp3.Response intercept(Chain chain) throws IOException {
//                                    Request request = chain.request();
//                                    Request.Builder builder1 = request.newBuilder();
//                                    Request build = builder1
//                                            .addHeader("token", sp.getString("token", "")).build();
//                                    System.out.println("ticket------"+ sp.getString("token", ""));
//                                    return chain.proceed(build);
//                                  }
//                              })
                                .addNetworkInterceptor(interceptor);
//                                .cache(cache);

//                    }

                    singleton = builder.build();
                }
            }
        }




        return singleton;
    }

}
