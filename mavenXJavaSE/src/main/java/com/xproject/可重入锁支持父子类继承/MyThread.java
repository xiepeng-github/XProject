package com.xproject.可重入锁支持父子类继承;

public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        Son son = new Son();
        son.operateISonMethod();
    }
}
