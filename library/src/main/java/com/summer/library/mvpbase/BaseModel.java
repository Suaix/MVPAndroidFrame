package com.summer.library.mvpbase;

/**
 * @autho xia
 * @date 2018/1/7 下午4:20
 * @desciption Model的基类，持有Presenter的实例
 */

public abstract class BaseModel<P extends IPresenter> implements IModel {

    protected P presenter;

    /**
     * 做一些初始化的任务
     *
     * @param presenter
     */
    @Override
    public <T extends IPresenter> void init(T presenter) {
        this.presenter = (P) presenter;
        initModel();
    }

    public P getPresenter(){
        return presenter;
    }

    /**
     * 初始化Model
     */
    protected abstract void initModel();
}
