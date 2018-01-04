package com.xproject.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {

        /*
            CountDownLatch只有一个构造器
            public CountDownLatch(int count) {  };  //参数count为计数值

            该类中最重要的三个方法
            public void await() throws InterruptedException { };   //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
            public void countDown() { };  //将count值减1

            CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
         */
        final CountDownLatch latch = new CountDownLatch(2);

        Thread thread1 = new Thread(new CountDownLatchThread(latch));
        Thread thread2 = new Thread(new CountDownLatchThread(latch));

        thread1.start();
        thread2.start();

        System.out.println("等待2个子线程执行完毕...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2个子线程已经执行完毕");
        System.out.println("继续执行主线程");

    }

}
