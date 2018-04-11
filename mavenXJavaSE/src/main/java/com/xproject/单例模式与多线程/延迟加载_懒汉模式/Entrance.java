package com.xproject.单例模式与多线程.延迟加载_懒汉模式;

import com.xproject.单例模式与多线程.延迟加载_懒汉模式.MyThread;

public class Entrance {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
