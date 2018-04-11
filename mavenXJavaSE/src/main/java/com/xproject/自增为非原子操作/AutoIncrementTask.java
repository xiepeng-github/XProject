package com.xproject.自增为非原子操作;

public class AutoIncrementTask {

    private int i;

    public void autoIncrement() {

        for(int j=0; j<10; j++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadName= " + Thread.currentThread().getName() + " i= " + i++);//非线程安全
        }


    }
}
