//
// Created by zxl on 2019/12/16.
//

#include "com_aloogn_demo_jni_JNIUtil.h"

JNIEXPORT jstring JNICALL Java_com_aloogn_demo_jni_JNIUtil_sayHekkFromJDI
  (JNIEnv *env, jclass jclass){
    return env->NewStringUTF("Hello World From JNI!!!!!");
}