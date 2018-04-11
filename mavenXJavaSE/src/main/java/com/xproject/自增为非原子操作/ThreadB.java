package com.xproject.自增为非原子操作;

public class ThreadB implements Runnable{

    private AutoIncrementTask autoIncrementTask;

    public ThreadB(AutoIncrementTask autoIncrementTask) {
        this.autoIncrementTask = autoIncrementTask;
    }

    @Override
    public void run() {
        autoIncrementTask.autoIncrement();
    }
}
