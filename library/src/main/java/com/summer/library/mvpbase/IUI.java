package com.summer.library.mvpbase;

/**
 * View层父类，定义通用的功能方法
 *
 * @author xiahailiang
 */

public interface IUI extends IUIStatus {
    /**
     * 获取页面名称，用户统计数据时使用
     * @return 页面名称
     */
    String getPageName();

    /**
     * 展示Toast信息
     * @param stringId 信息资源id
     */
    void showToast(int stringId);

    /**
     * 展示Toast信息
     * @param msg 消息内容
     */
    void showToast(String msg);

}
