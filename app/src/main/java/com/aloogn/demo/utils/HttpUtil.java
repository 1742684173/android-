package com.aloogn.demo.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {
    private static HttpUtil instance = new HttpUtil();

    private URL url;
    private HttpURLConnection httpURLConnection;
    private OutputStream outputStream;


    private HttpUtil(){
        try {
            instance = new HttpUtil();
            url = new URL("http://127.0.0.1:8080/wjdc");
            httpURLConnection = (HttpURLConnection)url.openConnection();

            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoOutput(true);



        }catch (MalformedURLException e){

        }catch (IOException e){

        }

    }

    public static HttpUtil getInstance() {
        return instance;
    }

    public void postAction(Object param,String... type) throws IOException{
        httpURLConnection.setRequestMethod("POST");
        //httpURLConnection.set();

        outputStream = httpURLConnection.getOutputStream();
        outputStream.write("".getBytes());

//        if (urlConnection.getResponseCode()==200){
//            InputStream inputStream = urlConnection.getInputStream();
//            String s = streamToString(inputStream);
//            Gson gson=new Gson();
//            DateBase base = gson.fromJson(s, DateBase.class);
//            List<DateBase.ResultBean> result = base.getResult();
//
//            Message msg=Message.obtain();
//            msg.obj=result;
//            handler.sendMessage(msg);
//
//        }
    }

    public void disconnect(){
        httpURLConnection.disconnect();
    }


}
