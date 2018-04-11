package com.xproject.可重入锁支持父子类继承;

public class Father {
    public int i = 10;

    synchronized public void operateIFatherMehod() {
        try {
            i--;
            System.out.println("farher print i=" + i);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
