package com.summer.mvpandroidframe.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public final class RequestExecutor<T> {
    private Call<T> mCall;
    private XCallBack<T> mCallback;

    public RequestExecutor(Call<T> call, XCallBack<T> callback) {
        this.mCall = call;
        this.mCallback = callback;
    }

    /**
     * 执行网络请求操作
     *
     * @return
     */
    public final RequestExecutor<T> call() {
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (mCallback != null) {
                    mCallback.onCompleted(response.body(),
                            new XHeaders(response.headers()),
                            response.code(),
                            response.message());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (mCallback != null) {
                    mCallback.onFailure(t);
                }
            }
        });
        return RequestExecutor.this;
    }
}
