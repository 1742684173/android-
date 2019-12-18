package com.aloogn.demo.animation;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * android 提供了Animation作为补间动画抽象基类，而且为该抽象基类提供了AlphaAnimation,RotationAanimation,
 * ScaleAnimation,TranslateAnimation四个实现类，这四个实现类只是补间动画的基本方式，但要实现复杂的动
 * 画，就需要继承Animation,继承Animation类关健是要重写一个方法
 * applyTransformation(flat interpolatedTime,Transformation t),
 * interpolatedTime 代表了动画的时间进行比，不管动画实际的持续时间如何，当动画播放地，该参数总是从0到1
 *
 * Transformation t该参数代表了补间动画在不同时刻对图形或组件的变形程度
 *
 * 在实现自定义动画的关键就是重写applyTransformation方法时，根据interpolatedTime时间来动态地计算动
 * 画对图片或视图的变形程度
 *
 *Transformation 代表了对图片或者视图的变形，该对象封装了一个 Matrix 对象，对它所包装了 Matrix 进行位移、倾斜、旋转等变换时，Transformation 将会控制对应的图片或视图进行相应的变换。

 为了控制图片或者 View 进行三维空间的变换，还需要借助于 Android 提供的一个 Camera，这个 Camera 并非代表手机摄像头，而是空间变换工具。作用类似于 Matrix，其常用方法如下：
 getMatrix(Matrix matrix)：将 Camera 所做的变换应用到指定的 matrix 上。
 rotateX(float deg):将组件沿 X 轴旋转。
 rotateY(float deg):将组件沿 Y 轴旋转。
 rotateZ(float deg):将组件沿 Z 轴旋转。
 translate(float x,float y,float z):目标组件在三维空间里变换。
 applyToCanvas(Canvas canvas):把 Camera 所做的变换应用到 Canvas 上。
 */
public class CustomAnimation extends Animation{

    private float centerX;
    private float centerY;

    //定义动画的持续时间
    private int duration;
    private Camera camera = new Camera();

    public CustomAnimation(float centerX, float centerY, int duration) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.duration = duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        //设置持续时间
        setDuration(duration);
        //设置动画结束后保留效果
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        //super.applyTransformation(interpolatedTime, t);
        camera.save();
        //根据interplationTime时间来控制x,y,z偏移
        camera.translate(100.0f - 100.0f * interpolatedTime,
                150.0f * interpolatedTime - 150,
                80.0f - 80.f * interpolatedTime);
        //根据 interpolatedTime 设置在 X轴 和 Y轴 旋转
        camera.rotateX(360 * interpolatedTime);
        camera.rotateY(360 * interpolatedTime);

        //获取Transformation参数的 Matrix 对象
        Matrix matrix = t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        camera.restore();
    }
}
