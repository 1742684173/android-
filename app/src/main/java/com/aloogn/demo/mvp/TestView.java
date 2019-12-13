package com.aloogn.demo.mvp;

import com.aloogn.demo.mvp.base.IBaseView;

public interface TestView extends IBaseView{

    /**
     * 当数据请求成功，调用此接口显示数据
     * @param data
     */
    void showData(String data);

}
