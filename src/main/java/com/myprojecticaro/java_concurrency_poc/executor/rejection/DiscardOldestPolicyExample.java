package com.myprojecticaro.java_concurrency_poc.executor.rejection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DiscardOldestPolicyExample {

    public static void run() {

        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy()
            );

        try {
            for (int i = 1; i <= 4; i++) {
                int taskId = i;

                System.out.println("Submitting task " + taskId);

                executor.execute(() -> {
                    sleep(1000);
                    System.out.println("Task " + taskId + " executed");
                });
            }
        } finally {
            executor.shutdown();
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

