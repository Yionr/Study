package cn.yionr;

import cn.yionr.instances.Ins;
import cn.yionr.instances.impl.Ins1;
import cn.yionr.proxy.Ins1Proxy;

import java.util.UUID;

public class main {
    public static void main(String[] args) {
//        final Ins ins = new Ins1();
//        Ins instance = Ins1Proxy.getProxy(ins);
//        instance.fun1();
        int[][] arr = {{1,2,3},{4,5,6}};
        System.out.println(UUID.randomUUID().toString());


        int i =10;
        System.out.println(i);
    }
    void s(int... a){}


}
