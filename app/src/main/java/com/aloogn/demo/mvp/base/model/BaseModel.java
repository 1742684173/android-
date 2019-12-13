package com.aloogn.demo.mvp.base.model;

import com.aloogn.demo.mvp.base.CallBack;

import java.util.Map;

public abstract class BaseModel<T> {
    //请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     * @param args 参数数组
     * @return
     */
    public BaseModel params(String... args){
        mParams = args;
        return this;
    }

    /**
     * 添加CallBack并执行数据请求，由子类实现
     * @param callback
     */
    public abstract void execute(CallBack<T> callback);

    protected void requestGetAPI(String url,CallBack<T> callback){
        //写具体的请求
    }

    protected void requestPostAPI(String url,Map params,CallBack<T> callback){
        //写具体的请求
    }
}
