package com.xproject.单例模式与多线程.序列化与反序列化的单例实现;

import java.io.Serializable;

public class MyObject implements Serializable{

    private static final long serialVersionUID = 1677649097609367196L;

    private MyObject() {
    }

    //内部类方式
    private static class MyObjctHandler {
        private static MyObject myObject = new MyObject();
    }

    public static MyObject getInstance() {
        System.out.println("调用了getInstance方法");
        return MyObjctHandler.myObject;
    }

    protected Object readResolve() {
        System.out.println("调用了readResolve方法");
        return MyObjctHandler.myObject;
    }
}
