package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleReentrantLockExample {

    public static void run() {
        ReentrantLock lock = new ReentrantLock();
        SharedCounter counter = new SharedCounter(lock);

        Runnable task = counter::increment;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        join(t1, t2);
    }

    private static void join(Thread... threads) {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
