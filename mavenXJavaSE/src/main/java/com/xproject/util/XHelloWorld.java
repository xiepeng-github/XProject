package com.xproject.util;

public class XHelloWorld {

    public static void main(String[] args){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
        System.out.println(Math.round(11.4));
        System.out.println(Math.round(-11.4));
        System.out.println(Math.floor(0.5));
    }

    static void f_a() {

    }

}
