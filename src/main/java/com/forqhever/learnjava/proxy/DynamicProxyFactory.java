package com.forqhever.learnjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory {

    private Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new DynamicHandler());
    }

    class DynamicHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理：方法执行前==");
            Object object = method.invoke(target, args);
            System.out.println("动态代理：方法执行后--");
            return object;
        }
    }
}
