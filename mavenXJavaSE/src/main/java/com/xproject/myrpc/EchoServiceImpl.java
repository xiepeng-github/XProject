package com.xproject.myrpc;

/*
  服务提供方接口实现类
*/
public class EchoServiceImpl implements EchoService{


    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }

}
