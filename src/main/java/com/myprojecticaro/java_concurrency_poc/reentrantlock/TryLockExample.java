package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

    public static void run() {
        System.out.println();
        System.out.println("Iniciando com TryLockExample");

        ReentrantLock lock = new ReentrantLock();

        Runnable task = () -> {
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " acquired the lock");
                    sleep(500);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() +
                        " could not acquire the lock");
            }
        };

        new Thread(task, "Thread-A").start();
        new Thread(task, "Thread-B").start();

        System.out.println("Finaliza TryLockExample");
        System.out.println("********************************************************************");
        System.out.println();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
