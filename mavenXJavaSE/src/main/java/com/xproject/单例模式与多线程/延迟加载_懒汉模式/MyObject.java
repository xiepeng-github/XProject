package com.xproject.单例模式与多线程.延迟加载_懒汉模式;

public class MyObject {

    private static MyObject myObject = new MyObject();

    private MyObject() {
    }

    public static MyObject getInstance() {
        return  myObject;
    }


}
