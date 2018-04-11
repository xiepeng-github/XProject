package com.xproject.myrpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
  RPC服务端服务发布者
*/
public class RpcExporter {

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName, int port) throws Exception {

        ServerSocket server = new ServerSocket();//ServerSocket用来侦听来自客户端的请求,服务器端创建ServerSocket对象，调用accept方法返回Socket对象
        server.bind(new InetSocketAddress(hostName, port));//Socket地址（IP地址+端口）

        try {
            while(true) {
                executor.execute(new ExporterTask(server.accept()));
            }
        }
        finally {
            server.close();
        }
    }

    private static class ExporterTask implements Runnable {

        Socket client = null;//客户端创建Socket对象，通过端口连接到服务器

        public ExporterTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            ObjectInputStream input = null;//客户端、服务器端都使用Socket中的getInputStream方法和getOutputStream方法获得输入流和输出流，进一步进行数据读写操作
            ObjectOutputStream output = null;

            try{
                input = new ObjectInputStream(client.getInputStream());
                String interfaceName = input.readUTF();
                Class<?> service = Class.forName(interfaceName);
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[])input.readObject();
                Method method = service.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service.newInstance(), arguments);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch(Exception e) {
                e.printStackTrace();
            }finally {
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

                if(client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}


