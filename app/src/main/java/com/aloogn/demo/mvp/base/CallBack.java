package com.aloogn.demo.mvp.base;

public interface CallBack<T> {
    /**
     * 请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);

    /**
     * 请求成功，获取数据失败
     * @param msg 失败的原因
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，例如无法联网，缺少权限，内存泄露等导致无法连接到请求数据源
     */
    void onError();

    /**
     * 当请求数据结束时，无论请求结果是成功与否都会执行的方法
     */
    void onComplete();
}
