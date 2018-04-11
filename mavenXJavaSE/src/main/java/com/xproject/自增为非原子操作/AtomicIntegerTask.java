package com.xproject.自增为非原子操作;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTask {
    private AtomicInteger i = new AtomicInteger(0);

    public void autoIncrement() {

        for(int j=0; j<10; j++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadName= " + Thread.currentThread().getName() + " i= " + i.incrementAndGet());
        }

        //System.out.println("ThreadName= " + Thread.currentThread().getName() + " i= " + i);
    }
}
