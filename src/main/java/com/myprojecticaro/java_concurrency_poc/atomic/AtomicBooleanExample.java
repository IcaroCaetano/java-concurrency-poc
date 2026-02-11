package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {

    private static final AtomicBoolean running = new AtomicBoolean(true);

    public static void run() {

        Thread worker = new Thread(() -> {
            while (running.get()) {
                System.out.println("Working...");
                sleep(500);
            }
            System.out.println("Stopped.");
        });

        worker.start();

        sleep(1500);
        running.set(false);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
