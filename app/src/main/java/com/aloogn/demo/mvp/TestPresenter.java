package com.aloogn.demo.mvp;

import com.aloogn.demo.mvp.base.model.DataModel;
import com.aloogn.demo.mvp.base.model.Token;
import com.aloogn.demo.mvp.base.presenter.BasePresenter;
import com.aloogn.demo.mvp.base.CallBack;

public class TestPresenter extends BasePresenter<TestView>{

    /**
     * 获取网络数据
     * @param params
     */
    public void getData(String params){
        if(!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }

        getView().showLoading();

        DataModel
            .request(Token.API_TEST_DATA)
            .params("id")
            .execute(new CallBack() {
                @Override
                public void onSuccess(Object data) {
                    getView().showData((String) data);
                }

                @Override
                public void onFailure(String msg) {
                    getView().showData((String) msg);
                }

                @Override
                public void onError() {
                    getView().showError();
                }

                @Override
                public void onComplete() {
                    getView().hideLoading();
                }
            });
//
    }
}
