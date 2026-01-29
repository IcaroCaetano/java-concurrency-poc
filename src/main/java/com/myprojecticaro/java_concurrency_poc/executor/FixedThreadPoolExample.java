package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Objetivo:
 *  - Limite de concorrência
 *  - Reaproveitamento de threads
 *  - Execução em fila
 */
public class FixedThreadPoolExample {

    public static void run() {

        System.out.println("Iniciando com FixedThreadPoolExample");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Executa 5 tarefas com 2 threads em fila compartilhadas no no pool
        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " +
                        Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();

        System.out.println("Finaliza FixedThreadPoolExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
