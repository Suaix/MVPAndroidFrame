package com.summer.library.mvpbase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * @autho xia
 * @date 2018/1/7 下午7:33
 * @desciption 非MetalDesign风格的MVP规则的Activity的基类
 */
public abstract class BaseMVPActivity<P extends IPresenter> extends BaseActivity{

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
        int layoutResId = getLayoutResId();
        setContentView(layoutResId);
        //初始化布局控件
        initView();
        //设置监听
        addListener();
        //初始化数据
        initData(mBundle);
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
     * 获取布局资源的id，用来填充页面
     * @return 页面布局id
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化布局控件
     */
    protected abstract void initView();

    /**
     * 给控件添加Listener
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
     * 获取Presenter实例
     * @return Presenter实例
     */
    protected final P getPresenter(){
        return mPresenter;
    }

    /**
     * 初始化数据
     * @param bundle Intent内部存储的数据
     */
    protected void initData(@Nullable Bundle bundle){

    }

    /**
     * 获取Intent里传递的bundle数据
     * @return bundle
     */
    public Bundle getData(){
        return mBundle;
    }

}
