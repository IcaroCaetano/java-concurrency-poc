package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownExample {

    public static void run() {

        System.out.println("Iniciando com ExecutorShutdownExample");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();

        try {
            // Bloqueia até que todas as tarefas concluam a execução após uma solicitação
            // de desligamento, ou até que o tempo limite seja atingido,
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Finaliza ExecutorShutdownExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
