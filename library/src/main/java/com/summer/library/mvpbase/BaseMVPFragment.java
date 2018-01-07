package com.summer.library.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @autho xia
 * @date 2018/1/7 下午7:48
 * @desciption MVP框架的Fragment基类
 */
public abstract class BaseMVPFragment<P extends IPresenter> extends BaseFragment {

    public static final String KEY_DATA = "keyDataFragment";
    //Presenter
    protected P mPresenter;
    //根布局View
    protected View mRootView;
    //页面保存的数据
    protected Bundle mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            Bundle bundle = savedInstanceState.getBundle(KEY_DATA);
            if (bundle != null){
                mData = bundle;
            }
        }
        if (getArguments() != null){
            mData = getArguments();
        }
        if (mRootView == null){
            mPresenter = createPresenter();
            getPresenter().initUI(getActivity(), getUI());
            mRootView = onCreateViewExecute(inflater, container, savedInstanceState);
            getPresenter().onUICreate(savedInstanceState);
        }
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onUIStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onUIResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().onUIResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onUIStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mRootView != null && mRootView.getParent() != null){
            ((ViewGroup)mRootView.getParent()).removeView(mRootView);
        }
        getPresenter().onUIDestory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mData != null){
            outState.putBundle(KEY_DATA, mData);
        }
        if (getPresenter() != null){
            getPresenter().onSaveInstanceState(outState);
        }
    }

    public Bundle getData(){
        return mData;
    }

    protected final P getPresenter() {
        return mPresenter;
    }

    /**
     * 创建View
     * @param inflater 布局填充器
     * @param container 父布局
     * @param savedInstanceState 数据保存状态
     * @return 根布局
     */
    protected abstract View onCreateViewExecute(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 初始化布局控件
     * @param rootView 根布局
     */
    protected abstract void initView(View rootView);

    /**
     * 设置监听事件
     */
    protected abstract void addListener();

    /**
     * 创建Presenter
     * @return Presenter
     */
    protected abstract P createPresenter();

    /**
     * 获取IUI实例
     * @return IUI实例
     */
    protected abstract IUI getUI();

    /**
     * 初始化数据
     * @param mData 启动该Fragment时携带的Bundle
     */
    protected void initData(@Nullable Bundle mData){

    }
}
