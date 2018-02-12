package com.summer.mvpandroidframe.network.entity.response;

import com.summer.mvpandroidframe.network.entity.data.BaseData;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class BaseResponse<T extends BaseData> {
    protected BaseHeader h;
    protected T b;

    public BaseHeader getH() {
        return h;
    }

    public void setH(BaseHeader h) {
        this.h = h;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }
}
