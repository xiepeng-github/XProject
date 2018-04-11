package com.xproject.可重入锁支持父子类继承;

public class Son extends Father{

    synchronized public void operateISonMethod() {
        try {
            while(i > 0) {
                i--;
                System.out.println("son print i=" + i);
                Thread.sleep(100);
                this.operateIFatherMehod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void operateIFatherMehod() {
        try {
            i--;
            System.out.println("sonOverwrite print i=" + i);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
