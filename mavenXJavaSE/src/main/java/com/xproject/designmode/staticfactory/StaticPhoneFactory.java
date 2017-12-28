package com.xproject.designmode.staticfactory;

//静态工厂(createPhone方法通常是静态的)
/*
特点
        1 它是一个具体的类，非接口 抽象类。有一个重要的create()方法，利用if或者 switch创建产品并返回。
        2 create()方法通常是静态的，所以也称之为静态工厂。
        缺点
        1 扩展性差（我想增加一种手机，除了新增一个手机产品类，还需要修改工厂类方法）。可以使用反射，增加手机产品时，无需修改工厂类静态方法，但效率差
        2 不同的产品需要不同额外参数的时候 不支持。
*/
public class StaticPhoneFactory {

    public static final int TYPE_IPHONE = 1;//iphone
    public static final int TYPE_SONY= 2;//sony

    public static Phone createPhone(int type) {
        switch (type) {
            case TYPE_IPHONE:
                return new Iphone();
            case TYPE_SONY:
                return new Sony();
            default:
                return new Iphone();
        }
    }

    public static void main(String args[]) {
        Phone newPhone = StaticPhoneFactory.createPhone(2);
        newPhone.introduce();
    }
}
