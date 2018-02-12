package com.summer.mvpandroidframe.network;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public interface XCallBack<T> {
    void onCompleted(T response, XHeaders headers, int httpCode, String httpMsg);
    void onFailure(Throwable throwable);
}
