package com.summer.library.mvpbase;

/**
 * mvp的model层协议,负责数据
 *
 * @author xiahailiang
 */

public interface IModel {
    /**
     * 做一些初始化的任务
     */
    <P extends IPresenter>void init(P presenter);
}
