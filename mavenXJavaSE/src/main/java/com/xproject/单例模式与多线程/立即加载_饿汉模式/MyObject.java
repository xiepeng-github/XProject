package com.xproject.单例模式与多线程.立即加载_饿汉模式;

public class MyObject {

    private static MyObject myObject;

    private MyObject() {
    }

    public static MyObject getInstance() {

        if(myObject != null) {

        }else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MyObject.class) {
                //DCL双检查锁机制，效率相对与直接用synchronized同步getInstance方法高
                if(myObject == null) {
                    myObject = new MyObject();
                }
            }
        }

        return myObject;
    }


}
