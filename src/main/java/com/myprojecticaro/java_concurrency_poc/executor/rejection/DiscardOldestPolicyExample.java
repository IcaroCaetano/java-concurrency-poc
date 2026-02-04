package com.myprojecticaro.java_concurrency_poc.executor.rejection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DiscardOldestPolicyExample {

    public static void run() {

        /**
         * Creates a ThreadPoolExecutor with a very limited capacity in order to
         * demonstrate task rejection behavior.
         *
         * <p>
         * Configuration details:
         * </p>
         *
         * <ul>
         *   <li>
         *     corePoolSize = 1
         *     <br>
         *     The executor maintains a single worker thread at all times.
         *     This thread is responsible for executing tasks as long as the executor is running.
         *   </li>
         *
         *   <li>
         *     maximumPoolSize = 1
         *     <br>
         *     The pool is not allowed to grow beyond one thread, even under high load.
         *   </li>
         *
         *   <li>
         *     keepAliveTime = 0 seconds
         *     <br>
         *     Idle threads above the core size would be terminated immediately,
         *     but since core and max sizes are equal, this value has no practical effect.
         *   </li>
         *
         *   <li>
         *     workQueue = ArrayBlockingQueue with capacity 1
         *     <br>
         *     Only one task can wait in the queue while the single worker thread is busy.
         *     Any additional task submitted when both the worker and the queue are full
         *     will be rejected.
         *   </li>
         *
         *   <li>
         *     rejectionPolicy = AbortPolicy
         *     <br>
         *     When the executor cannot accept a new task, it throws a
         *     {@link java.util.concurrent.RejectedExecutionException},
         *     causing the submission to fail fast and making overload situations explicit.
         *   </li>
         * </ul>
         *
         * <p>
         * This configuration is intentionally restrictive and is commonly used in
         * demonstrations or tests where controlled overload and rejection behavior
         * must be observed.
         * </p>
         */
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

