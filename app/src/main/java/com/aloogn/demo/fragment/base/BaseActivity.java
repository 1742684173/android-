package com.aloogn.demo.fragment.base;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aloogn.demo.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    protected ViewGroup baseContentView;

    //标题栏
    protected LinearLayout baseTitleLinearLayout;
    //返回
    protected ImageView baseLeftImageView;
    //标题
    protected TextView baseCenterTextView;

    //内容
    protected LinearLayout baseContentLinearLayout;

    //加载框
    protected LinearLayout baseLoadLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        baseContentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_base,null) ;

        baseLeftImageView = (ImageView)baseContentView.findViewById(R.id.baseLeftImageView);
        baseLeftImageView.setOnClickListener(this);

        baseCenterTextView = (TextView)baseContentView.findViewById(R.id.baseCenterTextView);

        baseContentLinearLayout = (LinearLayout)baseContentView.findViewById(R.id.baseContentLinearLayout);
        //baseLoadLinearLayout = (LinearLayout)baseContentView.findViewById(R.id.baseLoadLinearLayout);
        baseTitleLinearLayout = (LinearLayout)baseContentView.findViewById(R.id.baseTitleLinearLayout);

        setContentView(baseContentView);
    }

    //设置标题
    public void setTitle(String title){
        baseCenterTextView.setText(title);
    }

    //显示加载框
    public void showProgressBar(){
        if(baseLoadLinearLayout.getVisibility() != View.VISIBLE){
            baseLoadLinearLayout.setVisibility(View.VISIBLE);
        }
    }

    //设置没有标题栏
    public void setNoTitle(){
        baseTitleLinearLayout.setVisibility(View.GONE);
    }

    //隐藏加载框
    public void hideProgressBar(){
        if(baseLoadLinearLayout.getVisibility() != View.GONE){
            baseLoadLinearLayout.setVisibility(View.GONE);
        }
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.baseLeftImageView:
                this.finish();
                break;

                default:
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            View v = getCurrentFocus();
            if(isShoulldHideInput(v,event)){
                IBinder token = v.getWindowToken();
                if(null != token){
                    InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(token,InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean isShoulldHideInput(View v,MotionEvent event){
        if(null != v && (v instanceof EditText)){
            int[] leftTop = {0,0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top+v.getHeight();
            int right = left+v.getWidth();

            float X = event.getX();
            float Y = event.getY();

            if(X>left && X<right && Y>top && Y<bottom){
                return false;
            }else{
                return true;
            }
        }

        return false;
    }
}
