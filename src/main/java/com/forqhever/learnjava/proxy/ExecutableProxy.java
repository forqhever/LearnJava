package com.forqhever.learnjava.proxy;

public class ExecutableProxy implements Executable {

    Executable executable;

    public ExecutableProxy(Executable executable) {
        this.executable = executable;
    }


    public Object execute() {
        System.out.println("静态代理：方法执行前==");
        Object object = this.executable.execute();
        System.out.println("静态代理：方法执行后--");
        return object;
    }
}
