package com.xproject.单例模式与多线程.延迟加载_懒汉模式;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println(MyObject.getInstance().hashCode());
    }
}
