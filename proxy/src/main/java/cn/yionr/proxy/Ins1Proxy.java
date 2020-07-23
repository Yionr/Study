package cn.yionr.proxy;

import cn.yionr.instances.Ins;
import cn.yionr.instances.impl.Ins1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Ins1Proxy {
    public static Ins getProxy(final Ins instance){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("ready to start");
                Object invoke = method.invoke(instance, args);
                System.out.println("end...");
                return invoke;
            }
        };
        Object o = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), h);
        return (Ins)o;
    }
}
