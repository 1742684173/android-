package com.aloogn.demo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.aloogn.demo.R;

public class AnimationActivity extends AppCompatActivity {

    private ImageView ivImg;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivImg = findViewById(R.id.ivImg);

        animationDrawable = (AnimationDrawable)ivImg.getBackground();
    }

    public void startClick(){
        animationDrawable.start();
    }

    public void stoplick(){
        animationDrawable.stop();
    }
}
