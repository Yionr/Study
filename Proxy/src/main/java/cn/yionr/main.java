package cn.yionr;

import cn.yionr.instances.Ins;
import cn.yionr.instances.impl.Ins1;
import cn.yionr.proxy.Ins1Proxy;

public class main {
    public static void main(String[] args) {
        final Ins ins = new Ins1();
        Ins instance = Ins1Proxy.getProxy(ins);
        instance.fun1();
    }
}
