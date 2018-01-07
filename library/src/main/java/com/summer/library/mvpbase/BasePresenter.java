package com.summer.library.mvpbase;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/**
 * @autho xia
 * @date 2018/1/7 下午4:04
 * @desciption Prensenter的基类
 */
public abstract class BasePresenter<U extends IUI, M extends IModel> implements IPresenter{
    /**
     * presenter持有的UI实例
     */
    private U mUI;
    /**
     * presenter持有的model实例
     */
    private M mModel;
    /**
     * Context
     */
    private Context mContext;

    public BasePresenter(){

    }

    @Override
    public <T extends IUI> void initUI(Context context, T ui) {
        this.mContext = context;
        this.mUI = (U) ui;
        mModel = createModel();
        mModel.init(this);
    }

    @Override
    public void onUICreate(Bundle savedInstanceState) {

    }

    @Override
    public void onUIStart() {

    }

    @Override
    public void onUIResume() {

    }

    @Override
    public void onUIPause() {

    }

    @Override
    public void onUIStop() {

    }

    @Override
    public void onUIDestory() {
        //释放持有的实例
        mContext = null;
        mUI = null;
        mModel = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    /**
     * 获取UI实例
     *
     * @return UI实例
     */
    protected final U getUI(){
        return mUI;
    }

    /**
     * 获取Model实例
     *
     * @return model实例
     */
    protected final M getModel(){
        return mModel;
    }

    /**
     * 获取Context实例
     *
     * @return context实例
     */
    protected final Context getContext(){
        return mContext;
    }

    /**
     * 获取字符串资源
     * @param strId 资源id
     * @return 自定义的字符串
     */
    protected String getString(int strId){
        return mContext.getString(strId);
    }

    /**
     * 获取自定义的颜色
     * @param colorId 颜色资源
     * @return 颜色
     */
    protected int getColor(int colorId){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return mContext.getColor(colorId);
        }
        return mContext.getResources().getColor(colorId);
    }

    protected abstract M createModel();
}
