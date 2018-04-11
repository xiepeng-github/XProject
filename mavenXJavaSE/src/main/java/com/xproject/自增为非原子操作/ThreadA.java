package com.xproject.自增为非原子操作;

public class ThreadA implements Runnable{

    private AutoIncrementTask autoIncrementTask;

    public ThreadA(AutoIncrementTask autoIncrementTask) {
        this.autoIncrementTask = autoIncrementTask;
    }

    @Override
    public void run() {
        autoIncrementTask.autoIncrement();
    }
}
