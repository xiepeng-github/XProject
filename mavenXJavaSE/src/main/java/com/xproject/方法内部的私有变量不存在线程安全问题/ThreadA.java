package com.xproject.方法内部的私有变量不存在线程安全问题;

public class ThreadA extends Thread{

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
