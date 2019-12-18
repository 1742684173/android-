package com.aloogn.demo.jni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aloogn.demo.R;

public class JNIActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);

        textView = (TextView)findViewById(R.id.tvJNIResult);
        findViewById(R.id.btnJNIText).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String str = JNIUtil.sayHekkFromJDI();
                textView.setText(str);
            }
        });
    }
}
