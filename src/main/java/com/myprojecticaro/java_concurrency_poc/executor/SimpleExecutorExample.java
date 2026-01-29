package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Objetivo:
 *
 * - Executor executa tarefas
 * - Ele gerencia a thread
 * - O desenvolvedor não cria thread manualmente
 */
public class SimpleExecutorExample {

    public static void run() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            System.out.println("Running task in executor");
        });

        executor.shutdown();
    }
}
