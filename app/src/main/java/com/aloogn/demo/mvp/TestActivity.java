package com.aloogn.demo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aloogn.demo.R;
import com.aloogn.demo.mvp.base.view.BaseActivity;


public class TestActivity extends BaseActivity implements TestView {

    private TextView textView;
    private TestPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        textView = findViewById(R.id.tbText);

        mvpPresenter = new TestPresenter();
        mvpPresenter.attachView(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mvpPresenter.detachView();
    }


    public void getData(View view){
        mvpPresenter.getData("normal");
    }

    public void getDataFailure(View view){
        mvpPresenter.getData("failure");
    }

    public void getDataError(View view){
        mvpPresenter.getData("error");
    }

    @Override
    public void showData(String data) {
        textView.setText(data);
    }

}
