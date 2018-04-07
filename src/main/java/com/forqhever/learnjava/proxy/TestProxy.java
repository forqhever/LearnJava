package com.forqhever.learnjava.proxy;

public class TestProxy {

    private static void staticProxy() {
        Executable executable = new ExecutableImpl();
        Executable executableProxy = new ExecutableProxy(executable);
        executableProxy.execute();
    }

    private static void dynamicProxy() {
        Executable executable = new ExecutableImpl();
        Executable executableProxy = (Executable)new DynamicProxyFactory(executable).getProxyInstance();
        executableProxy.execute();
    }

    private static void cglibProxy() {
        Executable executable = new ExecutableImpl();
        Executable executableProxy = (Executable)new CglibProxyFactory(executable).getProxyInstance();
        executableProxy.execute();
    }

    public static void main(String[] args) {
        staticProxy();
        dynamicProxy();
        cglibProxy();
    }
}
