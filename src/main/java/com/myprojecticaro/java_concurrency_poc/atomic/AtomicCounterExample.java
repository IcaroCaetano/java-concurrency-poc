package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void run() {

        Runnable task = () -> {
            // 5 tarefas
            for (int i = 0; i < 5; i++) {
                int value = counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " incremented to " + value);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        join(t1, t2);
    }

    private static void join(Thread... threads) {
        for (Thread t : threads) {
            try {
               // 
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

