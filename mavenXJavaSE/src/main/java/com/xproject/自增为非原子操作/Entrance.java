package com.xproject.自增为非原子操作;

public class Entrance {
    public static void main(String[] args) {

        AutoIncrementTask autoIncrementTask = new AutoIncrementTask();
        AtomicIntegerTask atomicIntegerTask = new AtomicIntegerTask();
        Thread a = new Thread(new ThreadA(autoIncrementTask));
        Thread b = new Thread(new ThreadB(autoIncrementTask));
        Thread c = new Thread(new ThreadC(atomicIntegerTask));
        Thread d = new Thread(new ThreadD(atomicIntegerTask));
        a.start();
        b.start();

    }
}
