package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    public static void run() {

        AtomicReference<String> reference = new AtomicReference<>("Initial");

        reference.updateAndGet(current -> current + " -> Updated");

        System.out.println("Value: " + reference.get());
    }
}
