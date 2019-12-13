package com.aloogn.demo.mvp.base.model;

public class DataModel {
    public static BaseModel request(String token){
        BaseModel model = null;
        try {
            model = (BaseModel)Class.forName(token).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return model;
    }
}
