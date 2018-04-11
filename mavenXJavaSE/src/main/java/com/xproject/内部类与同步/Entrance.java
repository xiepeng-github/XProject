package com.xproject.内部类与同步;

public class Entrance {

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());
        /*
        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();//实例化内部类的方法
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());*/


        PublicClass.PrivateClass privateClass = new PublicClass.PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());

    }
}
