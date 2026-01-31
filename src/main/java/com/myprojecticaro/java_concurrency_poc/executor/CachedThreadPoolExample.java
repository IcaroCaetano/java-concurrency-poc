package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    public static void run() {

        System.out.println("Iniciando com CachedThreadPoolExample");

        // Cria um pool de threads que cria novas threads conforme necessário
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

        System.out.println("Finaliza CachedThreadPoolExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
