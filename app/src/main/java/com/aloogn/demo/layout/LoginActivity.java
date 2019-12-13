package com.aloogn.demo.layout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aloogn.demo.R;
import com.aloogn.demo.utils.StringUtil;
import com.aloogn.demo.fragment.base.BaseActivity;

import okhttp3.FormBody;
import okhttp3.RequestBody;


public class LoginActivity extends BaseActivity {
    private Context context;
    //登录按钮
    private Button loginButton;
    //帐户和密码输入框
    private EditText accountEditText,passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        setNoTitle();
        LayoutInflater.from(this).inflate(R.layout.activity_login, baseContentLinearLayout,true);

        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        accountEditText = (EditText)findViewById(R.id.loginAccountEditView);
        passwordEditText = (EditText)findViewById(R.id.loginPasswordEditText);

    }

    @Override
    public void onClick(View v){
        super.onClick(v);

        switch (v.getId()){
            case R.id.loginButton:
                onLoginClick();
                break;

                default:
                    break;
        }
    }

    private void onLoginClick() {
        String account = accountEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(StringUtil.isNullAndEmpty(account)){
            Toast.makeText(context,"请输入帐号",Toast.LENGTH_SHORT).show();
            return;
        }

        if(StringUtil.isNullAndEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }

        this.showProgressBar();
        RequestBody requestBody = new FormBody.Builder()
                .add("account",account)
                .add("password",password)
                .build();


        //OkHttpUtil.getInstance().post("",RequestBody.create(MediaType.,""));

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        return true;
    }

}
