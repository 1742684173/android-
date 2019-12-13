package com.aloogn.demo.mvp.base;

import android.content.Context;

public interface IBaseView {
    void showLoading();

    void hideLoading();

    void showToast(String msg);

    void showError();

    Context getContext();
}
