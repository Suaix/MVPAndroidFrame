package com.summer.mvpandroidframe;

import com.summer.library.mvpbase.BaseModel;
import com.summer.library.mvpbase.IModel;

/**
 * Created by xiahailiang on 2018/1/7.
 */

public class MainModel extends BaseModel<MainPrensenter> {
    private String result;
    /**
     * 初始化Model
     */
    @Override
    protected void initModel() {
        result = "this is result form MainModel";
    }

    public void getTestResult() {
        getPresenter().onTestResult(result);
    }
}
