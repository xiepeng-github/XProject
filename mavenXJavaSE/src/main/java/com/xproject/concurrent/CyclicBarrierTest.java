package com.xproject.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        /*
            CyclicBarrier类位于java.util.concurrent包下，CyclicBarrier提供2个构造器：
            public CyclicBarrier(int parties, Runnable barrierAction) {
            };
            public CyclicBarrier(int parties) {
            };
            参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容

            CyclicBarrier中最重要的方法就是await方法，它有2个重载版本：
            public int await() throws InterruptedException, BrokenBarrierException { };
            public int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException { };
            第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
            第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务。

         */
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for(int i=0;i<N;i++) {
            new Thread(new CyclicBarrierThread(barrier)).start();
        }
    }
}
