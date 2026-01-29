package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorExample {

    public static void run() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            System.out.println("Running task in executor");
        });

        executor.shutdown();
    }
}
