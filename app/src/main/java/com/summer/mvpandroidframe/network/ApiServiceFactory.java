package com.summer.mvpandroidframe.network;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.gson.GsonConverterFactory;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class ApiServiceFactory {
    private static final String online_url = "https://hongrenshuo.com.cn/api/v92/";    //正式环境
    private static String sToken = null;
    private static XService sService = null;

    public static String getBaseUrl() {
        return online_url;
    }

    public static XService getXService(String token) {
        if (token == null || needCreateNewService(token)) {
            sService = create(XService.class, token);
        }
        sToken = token;
        return sService;
    }

    private static <T> T create(Class<T> clazz, final String token) {
        //添加固定header
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                String requestId = String.valueOf(System.currentTimeMillis());
                String ua = "os=8.0&c=2&vc=92&vn=3.0.4&n=hrs&cn=00&s=1080*1920";
                builder
                        .addHeader("ua", ua)
                        .addHeader("_c", "2")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Accept", "*/*");
                if (!TextUtils.isEmpty(token)) {
                    builder.addHeader("x-auth-token", token);
                }
                builder.addHeader("requestId", requestId);
                Request request = builder.build();
                return chain.proceed(request);
            }

        };

        //添加所有请求打印
        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {

            @Override
            public void log(String message) {
                try {
                    Log.i("xia", message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 可以动态配置，可以直接去掉，使用OKHttp的默认配置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().clear();
        builder.writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS);

        // 可以在此处添加通用请求参数，比如Token
        // (通过OKHttp的Interceptor的方式，
        //  参考：https://github.com/square/okhttp/wiki/Interceptors)
//        if(App.getInstance().isDebug()){
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder.addInterceptor(interceptor);
//        }

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(clazz);
    }

    private static boolean needCreateNewService(String token) {
        if (sToken == null && token == null)
            return false;
        return sToken == null || !sToken.equals(token);
    }
}
