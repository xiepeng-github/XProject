package com.xproject.可重入锁支持父子类继承;

public class Entrance {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
