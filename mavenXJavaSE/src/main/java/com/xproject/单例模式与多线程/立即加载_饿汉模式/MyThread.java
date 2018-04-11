package com.xproject.单例模式与多线程.立即加载_饿汉模式;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println(MyObject.getInstance().hashCode());
    }
}
