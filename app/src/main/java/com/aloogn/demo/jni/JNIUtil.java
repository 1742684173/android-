package com.aloogn.demo.jni;

/**
 * 知识了解：
 * 1.什么是JNI，什么是NDK
 * JNI（Java Native Interface）即java本地接口，就是一种协议，用来沟通java和外部的本地代码(c/c++),
 * 正式有了中间JNI的存在，我们才可以在Application层通过JNI调用下层的东西
 *
 * NDK（Native Development Kit）本地开发工具包，就是帮助我们可以在Android应用中使用c/c++来完成
 * 特定功能的一套工具
 *
 *
 * NDK开发：
 * 进入/src/main/java目录
 * 1. javah -d ../jni com.aloogn.demo.jni.JNIUtil
 * javah生成java类对应的头文件， -d生成一个目录
 *
 * 2.在../jni创建c/c++文件
 *
 * 3.在app里的build.gradle中defaultConfig加入
 *  ndk{
 *      moduleName "JNIHello"
 *  }
 *
 *  4.加载动态生成的库
 *  static {
 *      System.loadLibrary("JNIHello");
 *  }
 *  我们把加载动态库的代码放到静态代码块中，就是表示在JNIUtils这个类在加载的时候就去加载我们的动态库。
 *
 *  5.运行会报错
 *  as3.0之前在gradle.properties中android.useDeprecatedNdk=true
 *  之后就根据提示来，我加的是android.deprecatedNdkCompileLease=1576494742524
 */
public class JNIUtil {
    static {
        System.loadLibrary("JNIHello");
    }

    public static native String sayHekkFromJDI();
}
