package com.xproject.myrpc;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
  本地服务代理，服务调用方通过该代理调用远程服务
*/
public class RpcImporter <S>{//定义泛型，S可以为任何类

    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {

        /*
        Proxy.newProxyInstance()方法有三个参数：
        1. 类加载器(Class Loader)
        2. 需要实现的接口数组
        3. InvocationHandler接口。所有动态代理类的方法调用，都会交由InvocationHandler接口实现类里的invoke()方法去处理。这是动态代理的关键所在。
         */
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass.getInterfaces()[0]},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    /*
                    invoke()方法同样有三个参数：
                    1. 动态代理类的引用，通常情况下不需要它。但可以使用getClass()方法，得到proxy的Class类从而取得实例的类信息，如方法列表，annotation等。
                    2. 方法对象的引用，代表被动态代理类调用的方法。从中可得到方法名，参数类型，返回类型等等
                    3. args对象数组，代表被调用方法的参数。注意基本类型(int,long)会被装箱成对象类型(Interger, Long)
                    */

                        Socket socket = null;//客户端创建Socket对象，通过端口连接到服务器
                        ObjectOutputStream output = null;
                        ObjectInputStream input = null;

                        try{
                            socket = new Socket();
                            socket.connect(addr);

                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);
                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        }finally {

                            if(socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            if(output != null) {
                                try {
                                    output.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            if(input != null) {
                                try {
                                    input.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }


                        }
                    }
                }
        );
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8088);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost",8088));
        System.out.println(echo.echo("Are you ok?"));
    }
}
