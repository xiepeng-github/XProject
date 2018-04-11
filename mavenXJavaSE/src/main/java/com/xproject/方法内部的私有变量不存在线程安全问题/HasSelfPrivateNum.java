package com.xproject.方法内部的私有变量不存在线程安全问题;

public class HasSelfPrivateNum {

    /*
    局部变量（方法内部的私有变量）是线程安全的，如下段代码中的num这个私有变量是线程安全的，
    原因是在new HasSelfPrevateNum()这个类的时候它只会为类中的属性成员变量开辟空间，
    而方法只在方法区开辟一个内存空间并且只存一份是共用的代码段（变量在堆区，引用在栈区），
    而方法中的私有变量不会先开辟出内存空间，而是等调用时在对应调用线程中为方法中的变量申请空间，
    所以有几个线程调用则每个线程就会在自己的线程空间的栈为局部变量申请几个引用同时在堆中为变量再申请对应的空间（即方法内的私有变量有几个线程就在栈中申请几个引用，在堆中申请几个空间），
    所以多线程在调用时只会处理自己线程内的方法的私有变量，因此，方法内的私有变量是线程安全的。
     */
    public void addI(String username) {
        try {
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }

            System.out.println(username + " num=" + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


