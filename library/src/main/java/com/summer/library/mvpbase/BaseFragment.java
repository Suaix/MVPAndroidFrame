package com.summer.library.mvpbase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.summer.library.utils.ToastUtils;

/**
 * @autho xia
 * @date 2018/1/7 下午7:39
 * @desciption fragment的基类
 */
public class BaseFragment extends Fragment implements IUI{

    private boolean isPaused;
    private boolean isStoped;
    private boolean isDestoryed;
    private boolean isDetached;
    private boolean isHidden;
    private boolean isVisibleToUser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        isDetached = false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isDestoryed = false;
    }

    @Override
    public void onStart() {
        super.onStart();
        isStoped = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        isPaused = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        isStoped = true;
    }

    @Override
    public void onDestroy() {
        isDestoryed = true;
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        isDetached = true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isHidden = hidden;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }

    /**
     * 页面是否调用过onPause
     *
     * @return 是否已经pause
     */
    @Override
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * 页面是否调用过onStop
     *
     * @return 是否已经stop
     */
    @Override
    public boolean isStoped() {
        return isStoped;
    }

    /**
     * 页面是否调用过onDestory
     *
     * @return 页面是否已经销毁
     */
    @Override
    public boolean isDestoryed() {
        return isDestoryed;
    }

    /**
     * Fragment 是否处于隐藏状态 对于Activity返回值同isDestoryed
     *
     * @return fragment是否处于隐藏状态
     */
    @Override
    public boolean isFragmentHidden() {
        return isHidden;
    }

    /**
     * 判断是否对用户可见，对Activity来讲和isPasused()方法返回值相反
     * 对Fragment来讲和setUserVisibleHint()参数值一直
     *
     * @return 是否对用户可见
     */
    @Override
    public boolean isVisibleToUser() {
        return isVisibleToUser;
    }

    /**
     * 获取页面名称，用户统计数据时使用
     *
     * @return 页面名称
     */
    @Override
    public String getPageName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 展示Toast信息
     *
     * @param stringId 信息资源id
     */
    @Override
    public void showToast(int stringId) {
        showToast(getString(stringId));
    }

    /**
     * 展示Toast信息
     *
     * @param msg 消息内容
     */
    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(msg);
    }
}
