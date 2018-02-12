package com.summer.mvpandroidframe.network;

import com.summer.mvpandroidframe.network.entity.response.TestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @autho xia
 * @date 2018/2/12 下午5:44
 * @desciption 服务端请求接口声明接口
 */

public interface XService {

    @GET("bootstrap/configuration/query")
    Call<TestResponse> queryConfiguration(@Query("clientVersion") int clientVersion);

}
