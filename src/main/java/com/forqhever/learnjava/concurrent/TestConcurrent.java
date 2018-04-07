package com.forqhever.learnjava.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestConcurrent {

    public static void main(String[] args) {
        Semaphore semaphore;
        CountDownLatch countDownLatch;
        CyclicBarrier cyclicBarrier;
        ConcurrentHashMap map;
        AtomicInteger count;
        ReentrantLock reentrantLock;
        ReentrantReadWriteLock readWriteLock;
        Executors.newCachedThreadPool();
    }
}
