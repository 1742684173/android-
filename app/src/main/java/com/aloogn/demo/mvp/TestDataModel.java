package com.aloogn.demo.mvp;


import android.os.Handler;

import com.aloogn.demo.mvp.base.model.BaseModel;
import com.aloogn.demo.mvp.base.CallBack;

public class TestDataModel extends BaseModel<String>{


    public void execute(final CallBack callback){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("请求成功");
                        break;

                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;

                    case "error":
                        callback.onError();
                        break;
                }

                callback.onComplete();
            }
        },2000);

    }
}
