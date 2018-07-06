package com.summer.library.mvpbase;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.summer.library.utils.ToastUtils;

import eventbus.EventBus;

/**
 * @autho xia
 * @date 2018/1/7 下午4:23
 * @desciption MateralDesign风格的Activity的基类
 */

public class BaseAppcompatActivity extends AppCompatActivity implements IUI {

    private boolean isPaused;
    private boolean isStoped;
    private boolean isAcitivityDestoryed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isAcitivityDestoryed = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isStoped = false;
        if (isBindEventBusHere()){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        isStoped = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPaused = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isStoped = true;
        if (isBindEventBusHere() && EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isAcitivityDestoryed = true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
        return isAcitivityDestoryed;
    }

    /**
     * 用来判断Fragment的，Fragment是否已经移除不再展示
     *
     * @return Fragment是否已经从Activity中移除
     */
    @Override
    public boolean isDetached() {
        return isAcitivityDestoryed;
    }

    /**
     * Fragment 是否处于隐藏状态 对于Activity返回值同isDestoryed
     *
     * @return fragment是否处于隐藏状态
     */
    @Override
    public boolean isFragmentHidden() {
        return isAcitivityDestoryed;
    }

    /**
     * 判断是否对用户可见，对Activity来讲和isPasused()方法返回值相反
     * 对Fragment来讲和setUserVisibleHint()参数值一直
     *
     * @return 是否对用户可见
     */
    @Override
    public boolean isVisibleToUser() {
        return isPaused;
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    protected boolean isBindEventBusHere(){
        return false;
    }

}
