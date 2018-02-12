package com.summer.library.mvpbase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * @autho xia
 * @date 2018/1/7 下午5:00
 * @desciption MVP模式下MetalDesign样式Acitivity的基类
 */

public abstract class BaseMVPAppcompatActivity<P extends IPresenter> extends BaseAppcompatActivity {

    public static final String KEY_DATA = "keyDataOfAppcompatActivity";

    protected P mPresenter;
    protected Bundle mBundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局之前的预处理
        beforeSetContentView();

        //恢复数据
        if (savedInstanceState != null){
            if (savedInstanceState.getBundle(KEY_DATA) != null){
                mBundle = savedInstanceState.getBundle(KEY_DATA);
            }
        }

        if (getIntent() != null && getIntent().getExtras() != null){
            mBundle = getIntent().getExtras();
        }

        //初始化Presenter
        mPresenter = createPresenter();
        mPresenter.initUI(this, getUI());
        //设置布局
        onCreateExecute(savedInstanceState);
        getPresenter().onUICreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().onUIStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onUIResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onUIResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().onUIStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onUIDestory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mBundle != null) {
            outState.putBundle(KEY_DATA, mBundle);
        }
        if(getPresenter() != null){
            getPresenter().onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.getBundle(KEY_DATA) != null) {
                mBundle = savedInstanceState.getBundle(KEY_DATA);
            }
        }
        getPresenter().onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 在设置页面布局之前
     */
    protected void beforeSetContentView(){

    }


    /**
     * Activity的onCreate方法执行时，所有子类不需要再实现oncreate方法，而是需要在此方法下处理初始化操作
     * 去除getLayoutId方法而改成该方法，是为了查询代码时方便，有一个类似生命周期的方法名
     * @param savedInstanceState Bundle
     */
    protected abstract void onCreateExecute(Bundle savedInstanceState);

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
     * 获取Presenter实例
     * @return Presenter实例
     */
    protected final P getPresenter(){
        return mPresenter;
    }

    /**
     * 获取Intent里传递的bundle数据
     * @return bundle
     */
    public Bundle getData(){
        return mBundle;
    }

}
