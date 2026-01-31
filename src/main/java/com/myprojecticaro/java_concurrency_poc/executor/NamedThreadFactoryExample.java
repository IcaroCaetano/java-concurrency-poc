package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamedThreadFactoryExample {

    public static void run() {

        System.out.println("Iniciando com NamedThreadFactoryExample");

        ExecutorService executor =
                Executors.newFixedThreadPool(
                        2,
                        new NamedThreadFactory("payment-worker")
                );

        for (int i = 1; i <= 4; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

        System.out.println("Finaliza NamedThreadFactoryExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
