package com.summer.library.mvpbase;

/**
 * UI状态信息
 *
 * @author xiahailiang
 */

public interface IUIStatus {
    /**
     * 页面是否调用过onPause
     *
     * @return 是否已经pause
     */
    boolean isPaused();

    /**
     * 页面是否调用过onStop
     *
     * @return 是否已经stop
     */
    boolean isStoped();

    /**
     * 页面是否调用过onDestory
     *
     * @return 页面是否已经销毁
     */
    boolean isDestoryed();

    /**
     * 用来判断Fragment的，Fragment是否已经移除不再展示
     * 对于Activity相当于isDestoryed()
     *
     * @return Fragment是否已经从Activity中移除
     */
    boolean isDetached();

    /**
     * Fragment 是否处于隐藏状态 对于Activity返回值同isDestoryed
     *
     * @return fragment是否处于隐藏状态
     */
    boolean isFragmentHidden();

    /**
     * 判断是否对用户可见，对Activity来讲和isPasused()方法返回值相反
     * 对Fragment来讲和setUserVisibleHint()参数值一直
     *
     * @return 是否对用户可见
     */
    boolean isVisibleToUser();
}
