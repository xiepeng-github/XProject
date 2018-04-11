package com.xproject.concurrent;

public class ThreadTest extends Thread{
    /*
    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count=" + count);
    }*/

    @Override
    public void run() {

        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i=" + (i + 1));
            }

            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        }catch (InterruptedException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        }
        /*
        System.out.println("Thread.currentThread().getName()= " + Thread.currentThread().getName());
        System.out.println("this.getName()= " + this.getName());*/
    }
}

class Run {

    public static void main(String [] args) {
        try {
            ThreadTest tt = new ThreadTest();
            Thread.sleep(10000);
            tt.start();
        }catch (InterruptedException e) {
            System.out.println("main 发生异常");
            e.printStackTrace();
        }

        /*
        Thread a = new Thread(tt, "A");
        Thread b = new Thread(tt, "B");
        Thread c = new Thread(tt, "C");
        Thread d = new Thread(tt, "D");
        Thread e = new Thread(tt, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/

    }
}
