package com.xproject.方法内部的私有变量不存在线程安全问题;

public class ThreadB extends Thread{

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
