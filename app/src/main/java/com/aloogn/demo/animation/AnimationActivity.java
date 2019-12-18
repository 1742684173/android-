package com.aloogn.demo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.aloogn.demo.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivImgGradually,ivImgInterval;
    private AnimationDrawable animationDrawable = null;

    SurfaceAnimView surfaceAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivImgGradually = findViewById(R.id.ivImgGradually);
        ivImgInterval = findViewById(R.id.ivImgInterval);
        findViewById(R.id.btnStartGradually).setOnClickListener(this);
        findViewById(R.id.btnStartInterval).setOnClickListener(this);
        findViewById(R.id.btnStartInterval).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //逐帧动画
            case R.id.btnStartGradually:
                animationDrawable = (AnimationDrawable)ivImgGradually.getBackground();
                animationDrawable.start();

//                用java来做的
//                //创建对象
//                animationDrawable = new AnimationDrawable();
//
//                //获取地址
//                int id = getResources().getIdentifier("","drawable",getPackageName());
//                Drawable drawable = getResources().getDrawable(id);
//
//                animationDrawable.addFrame(drawable,1000);
//
//                //循环
//                animationDrawable.setOneShot(false);
//                //获取资源对象
//                ivImg.setImageDrawable(animationDrawable);
//
//                //在动画开始之前要先stop，不然在第一次动画之后会停在最后一帧，这样动画只能触发一次
//                animationDrawable.stop();
//                animationDrawable.start();
                break;

                //补间动画
            case R.id.btnStartInterval:

//                //加载动画
//                final Animation anim = AnimationUtils.loadAnimation(this,R.anim.anim_interval);
//                //设置动画结束保留结束状态
//                anim.setFillAfter(true);
//                ivImgInterval.startAnimation(anim);

                //位移
//                Animation translateAniamtion = new TranslateAnimation(0,500,0,500);
//                // 创建平移动画的对象：平移动画对应的Animation子类为TranslateAnimation
//                // 参数分别是：
//                // 1. fromXDelta ：视图在水平方向x 移动的起始值
//                // 2. toXDelta ：视图在水平方向x 移动的结束值
//                // 3. fromYDelta ：视图在竖直方向y 移动的起始值
//                // 4. toYDelta：视图在竖直方向y 移动的结束值
//                translateAniamtion.setDuration(3000);
//                ivImgInterval.startAnimation(translateAniamtion);

                //缩放
//                Animation scaleAnimation = new ScaleAnimation(0,2,0,2,
//                        Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                // 1. fromX ：动画开始前在水平方向X的起始缩放倍数
//                // 2. toX ：动画在水平方向X的结束缩放倍数
//                // 3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
//                // 4. toY：动画在竖直方向Y的结束缩放倍数
//                // 5. pivotXType:缩放轴点的x坐标的模式
//                // 6. pivotXValue:缩放轴点x坐标的相对值
//                // 7. pivotYType:缩放轴点的y坐标的模式
//                // 8. pivotYValue:缩放轴点y坐标的相对值
//                // pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
//                // pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
//                // pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
//                scaleAnimation.setDuration(3000);
//                ivImgInterval.startAnimation(scaleAnimation);

                /**旋转*/
//                Animation rotateAnimation = new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                // 1. fromDegrees ：动画开始时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
//                // 2. toDegrees ：动画结束时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
//                // 3. pivotXType：旋转轴点的x坐标的模式
//                // 4. pivotXValue：旋转轴点x坐标的相对值
//                // 5. pivotYType：旋转轴点的y坐标的模式
//                // 6. pivotYValue：旋转轴点y坐标的相对值
//                // pivotXType = Animation.ABSOLUTE:旋转轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
//                // pivotXType = Animation.RELATIVE_TO_SELF:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
//                // pivotXType = Animation.RELATIVE_TO_PARENT:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
//                rotateAnimation.setDuration(3000);
//                ivImgInterval.startAnimation(rotateAnimation);

                /**透明*/
//                Animation alphaAnimation = new AlphaAnimation(1,0);
//                // 1. fromAlpha:动画开始时视图的透明度(取值范围: -1 ~ 1)
//                // 2. toAlpha:动画结束时视图的透明度(取值范围: -1 ~ 1)
//                alphaAnimation.setDuration(3000);
//                ivImgInterval.startAnimation(alphaAnimation);


                /**动画组合*/
//                //组合动画设置
//                AnimationSet animationSet = new AnimationSet(true);
//
//                //特别说明以下情况
//                //因为下面的动画设置无限循环(RepeatCount = INFINITE)
//                //所以动画不会结束，而是无限循环
//                //所以组合动画的下面两行设置是无效的
//                animationSet.setRepeatMode(Animation.RESTART);
//                animationSet.setRepeatCount(1);//设置了循环一次，但无效
//
//                //旋转动画
//                Animation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                rotate.setDuration(1000);
//                rotate.setRepeatMode(Animation.RESTART);
//                rotate.setRepeatCount(Animation.INFINITE);
//
//                //平移动画
//                Animation translate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
//                        TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
//                        TranslateAnimation.RELATIVE_TO_SELF,0,
//                        TranslateAnimation.RELATIVE_TO_SELF,0);
//                translate.setDuration(1000);
//
//                //透明度动画
//                Animation alpha = new AlphaAnimation(1,0);
//                alpha.setDuration(3000);
//                alpha.setStartOffset(7000);
//
//                animationSet.addAnimation(alpha);
//                animationSet.addAnimation(rotate);
//                animationSet.addAnimation(translate);
//
//                ivImgInterval.startAnimation(animationSet);

                //自定义动画
                ivImgInterval.startAnimation(new CustomAnimation(1.0f,1.0f,3500));

                break;

            case R.id.btnStop:
                if(null != animationDrawable){
                    animationDrawable.stop();
                }

                animationDrawable = null;
                break;

                default:
        }
    }


}
