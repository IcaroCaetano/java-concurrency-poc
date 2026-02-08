package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {

    public static void run() {

        System.out.println();
        System.out.println("Iniciando com FairLockExample");
        ReentrantLock fairLock = new ReentrantLock(true);

        Runnable task = () -> {
            fairLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the fair lock");
                sleep(300);
            } finally {
                fairLock.unlock();
            }
        };

        for (int i = 1; i <= 3; i++) {
            new Thread(task, "Thread-" + i).start();
        }

        System.out.println("Finaliza FairLockExample");
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
