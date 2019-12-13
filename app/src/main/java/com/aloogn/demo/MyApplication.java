package com.aloogn.demo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import java.net.URL;

public class MyApplication extends Application{
    //200(正常),206请求部分数据
    private int successCode;

    //500(服务器内部错误)
    private int serverErrorCode;
    //302/307(临时重定向),
    //304(未修改),
    //404(找不到),


    @Override
    public void onCreate(){
        super.onCreate();
        //内存溢出检测工具
        LeakCanary.install(this);

        setServerErrorCode(500);
        setSuccessCode(200);
    }

    public int getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(int successCode) {
        this.successCode = successCode;
    }

    public int getServerErrorCode() {
        return serverErrorCode;
    }

    public void setServerErrorCode(int serverErrorCode) {
        this.serverErrorCode = serverErrorCode;
    }
}
