package com.aloogn.demo.mvp.base.presenter;

import com.aloogn.demo.mvp.base.IBaseView;

public class BasePresenter<V extends IBaseView> {
    /**
     * 绑订的View
     */
    private V baseView;


    /**
     * 绑订view，一般在初始化中调用该方法
     * @param baseView
     */
    public void attachView(V baseView){
        this.baseView = baseView;
    }

    //断开View，一般在onDetroy中调用
    public void detachView(){
        this.baseView = null;
    }

    /**
     * 是否与view建立连接，每次调用业务请求的时候都要先调用方法检查是否与View建立连接
     * @return
     */
    public boolean isViewAttached(){
        return baseView != null;
    }

    public V getView(){
        return baseView;
    }

}
