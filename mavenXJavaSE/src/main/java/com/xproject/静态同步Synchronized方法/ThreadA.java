package com.xproject.静态同步Synchronized方法;

public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printA(); //对象也能调用静态方法
    }
}
