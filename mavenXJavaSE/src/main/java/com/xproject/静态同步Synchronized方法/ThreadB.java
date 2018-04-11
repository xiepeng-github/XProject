package com.xproject.静态同步Synchronized方法;

public class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printB(); //对象也能调用静态方法
    }
}
