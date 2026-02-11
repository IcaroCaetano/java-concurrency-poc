package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetExample {

    public static void run() {

        AtomicInteger value = new AtomicInteger(10);

        boolean updated = value.compareAndSet(10, 20);

        System.out.println("Updated: " + updated);
        System.out.println("Current value: " + value.get());
    }
}

