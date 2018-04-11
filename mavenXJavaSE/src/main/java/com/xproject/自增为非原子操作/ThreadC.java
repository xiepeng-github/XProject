package com.xproject.自增为非原子操作;

public class ThreadC implements Runnable{

    private AtomicIntegerTask atomicIntegerTask;

    public ThreadC(AtomicIntegerTask atomicIntegerTask) {
        this.atomicIntegerTask = atomicIntegerTask;
    }

    @Override
    public void run() {
        atomicIntegerTask.autoIncrement();
    }
}
