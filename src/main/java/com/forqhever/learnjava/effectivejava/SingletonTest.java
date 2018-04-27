package com.forqhever.learnjava.effectivejava;

import java.io.*;

class SingletonEntity implements Serializable {

    private static final long serialVersionUID = -148135022055774053L;

    private SingletonEntity(){}

    private static final SingletonEntity singletonEntity = new SingletonEntity();

    public static SingletonEntity getInstance() {
        return singletonEntity;
    }

    public Object readResolve() {
        return singletonEntity;
    }

    private int i = 10;

    public void print() {
        System.out.println("success 2222! i: " + i);
    }
}

public class SingletonTest {

    public static void main(String[] args) throws Exception {
        SingletonEntity singletonEntity;
        singletonEntity = SingletonEntity.getInstance();
        FileOutputStream outputStream = new FileOutputStream("1.txt");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(singletonEntity);
        } finally {
            outputStream.close();
        }
        System.out.println(singletonEntity);

        FileInputStream inputStream = new FileInputStream("1.txt");
        try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            singletonEntity = (SingletonEntity) objectInputStream.readObject();
        } finally {
            inputStream.close();
        }
        singletonEntity.print();
        System.out.println(singletonEntity);
    }
}
