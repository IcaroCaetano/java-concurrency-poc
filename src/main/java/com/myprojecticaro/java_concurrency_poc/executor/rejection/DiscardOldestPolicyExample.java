package com.myprojecticaro.java_concurrency_poc.executor.rejection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DiscardOldestPolicyExample {

    public static void run() {

     ThreadPoolExecutor executor = createExecutor();
        
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

    /**
     * Creates a ThreadPoolExecutor configured to demonstrate the
     * DiscardOldestPolicy rejection behavior.
     *
     * The pool has a single worker thread and a queue with capacity 1.
     * When both are full, the oldest queued task is discarded in favor
     * of the newly submitted task.
     */
    private static ThreadPoolExecutor createExecutor() {
        return new ThreadPoolExecutor(
            1, // corePoolSize = 1
            1, // maximumPoolSize = 1
            0, // keepAliveTime = 0 seconds
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.DiscardOldestPolicy()
        );
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

