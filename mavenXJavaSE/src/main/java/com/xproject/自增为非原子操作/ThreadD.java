package com.xproject.自增为非原子操作;

public class ThreadD implements Runnable{

    private AtomicIntegerTask atomicIntegerTask;

    public ThreadD(AtomicIntegerTask atomicIntegerTask) {
        this.atomicIntegerTask = atomicIntegerTask;
    }

    @Override
    public void run() {
        atomicIntegerTask.autoIncrement();
    }
}
