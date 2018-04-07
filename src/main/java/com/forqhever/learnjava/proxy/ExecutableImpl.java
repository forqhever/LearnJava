package com.forqhever.learnjava.proxy;

public class ExecutableImpl implements Executable {

    @Override
    public Object execute() {
        System.out.println("execute!");
        return null;
    }
}
