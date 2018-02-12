package com.summer.mvpandroidframe.network;

import com.summer.mvpandroidframe.network.entity.response.TestResponse;

import retrofit2.Call;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class XModel {
    private static XModel model;

    public static XModel getInstance() {
        if (null == model) {
            model = new XModel();
        }
        return model;
    }

    public RequestExecutor<TestResponse> queryCongfiguration(int clientVersion, XCallBack<TestResponse> callBack) {
        Call<TestResponse> call = ApiServiceFactory.getXService(null).queryConfiguration(clientVersion);
        return new RequestExecutor<>(call, callBack).call();
    }

}
