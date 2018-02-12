package com.summer.mvpandroidframe;

import com.summer.library.mvpbase.BaseModel;
import com.summer.library.mvpbase.IModel;
import com.summer.mvpandroidframe.network.XCallBack;
import com.summer.mvpandroidframe.network.XHeaders;
import com.summer.mvpandroidframe.network.XModel;
import com.summer.mvpandroidframe.network.entity.response.TestResponse;

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
        XModel.getInstance().queryCongfiguration(92, new XCallBack<TestResponse>() {
            @Override
            public void onCompleted(TestResponse response, XHeaders headers, int httpCode, String httpMsg) {
                result = "this is result form request, novelTabSwitch=" + response.getB().isNovelTabSwitch();
                getPresenter().onTestResult(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                getPresenter().onTestResult(result);
            }
        });
    }
}
