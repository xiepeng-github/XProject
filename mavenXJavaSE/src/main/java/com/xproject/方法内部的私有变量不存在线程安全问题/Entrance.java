package com.xproject.方法内部的私有变量不存在线程安全问题;

public class Entrance {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();

        ThreadA athread = new ThreadA(numRef);
        athread.start();
        ThreadB bthread = new ThreadB(numRef);
        bthread.start();
    }
}
