package com.aloogn.helloworld;

import android.util.Log;

import com.aloogn.demo.jni.JNIUtil;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void testGet() {
        String str = JNIUtil.sayHekkFromJDI();
        System.out.println(str);
    }
}