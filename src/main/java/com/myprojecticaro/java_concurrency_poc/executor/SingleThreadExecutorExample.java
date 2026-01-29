package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Objetivo:
 *
 * - Execução sequencial
 * - Garantia de ordem
 * - Uso comum em processamento de eventos
 */
public class SingleThreadExecutorExample {

    public static void run() {

        System.out.println("Iniciando com SingleThreadExecutorExample");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("First task"));
        executor.execute(() -> System.out.println("Second task"));
        executor.execute(() -> System.out.println("Third task"));

        executor.shutdown();

        System.out.println("Finaliza SingleThreadExecutorExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
