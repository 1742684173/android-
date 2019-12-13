package com.aloogn.demo.utils;

public class StringUtil {

    public static boolean isNull(String str){
        return null == str;
    }

    public static boolean isNullAndEmpty(String str){
        return isNull(str) && str.length() == 0;
    }
}
