package com.xproject.类和对象属性与方法初始化顺序;

/*
当要实例化一个类时，JVM会首先加载该类，并且在加载过程中检查这个类是否有静态属性以及静态代码块，如果有，就按顺序分配内存并初始化他们，并且只在类加载的过程中初始化一次。
对于构造代码块，以及普通属性，是在类实例化时进行的，并且每次实例化都会调用，并且构造代码块先于构造方法执行（无论代码块出现在构造方法前后，总是优先于构造方法）


对于父类以及子类中的情况
会按照如下顺序加载，1、父类中的静态块、静态方法；2、子类中的静态块、静态方法；3、父类的构造块；4、父类的构造方法；5、子类的构造块；6、子类的构造方法。
 */
public class Parent {
    private static String name = "my name is jack";

    static {
        System.out.println("静态代码块：" + name);
    }

    {
        System.out.println("构造代码块");
    }
    //内部类资产
    static class property {
        String account;
        float amount;

        static {
            System.out.println("内部类property静态代码块");
        }

        public property() {
            System.out.println("内部类property的构造函数");
        }
    }

    private Parent() {
        System.out.println("Parent类的构造函数");
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent.property property = new Parent.property();
    }
}
