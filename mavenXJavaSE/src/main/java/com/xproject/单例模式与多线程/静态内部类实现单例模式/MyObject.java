package com.xproject.单例模式与多线程.静态内部类实现单例模式;

public class MyObject {

    private MyObject() {
    }

    //内部类方式
    private static class MyObjctHandler {
        private static MyObject myObject = new MyObject();
    }

    public static MyObject getInstance() {
        return MyObjctHandler.myObject;
    }
}
