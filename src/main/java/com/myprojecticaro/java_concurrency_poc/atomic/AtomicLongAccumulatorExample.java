package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.LongAdder;

public class AtomicLongAccumulatorExample {

    private static final LongAdder adder = new LongAdder();

    public static void run() {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                adder.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        join(t1, t2);

        System.out.println("Final value: " + adder.sum());
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
