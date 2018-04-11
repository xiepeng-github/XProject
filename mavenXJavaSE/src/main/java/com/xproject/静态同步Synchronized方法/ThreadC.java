package com.xproject.静态同步Synchronized方法;

public class ThreadC extends Thread{
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printC(); //对象也能调用静态方法
    }
}
