package com.summer.mvpandroidframe;

import com.summer.library.mvpbase.BasePresenter;

/**
 * Created by xiahailiang on 2018/1/7.
 */

public class MainPrensenter extends BasePresenter<MainActivity, MainModel> {

    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    public void test(){
        getModel().getTestResult();
    }

    public void onTestResult(String result){
        getUI().onTestResult(result);
    }
}
