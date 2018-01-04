package com.xproject.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable{

    private CountDownLatch lacth;
    public CountDownLatchThread(CountDownLatch latch) {
        this.lacth = latch;
    }

    @Override
    public void run() {
        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
        lacth.countDown();
    }
}
