package com.myprojecticaro.java_concurrency_poc.executor.rejection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Icaro Caetano
 */
public class CallerRunsPolicyExample {

    public static void run() {

        /**
         * Cria um ThreadPoolExecutor com capacidade extremamente limitada para
         * demonstrar o comportamento de rejeição de tarefas.
         *
         *     corePoolSize = 1
         *     <br>
         *     Mantém apenas uma thread ativa no pool.
         *
         *     maximumPoolSize = 1
         *     <br>
         *     O pool não cresce além de uma thread, mesmo sob carga.
         *
         *     keepAliveTime = 0 segundos
         *     <br>
         *     Não há impacto prático, pois o core e o máximo são iguais.
         *
         *     ArrayBlockingQueue com capacidade 1
         *     <br>
         *     Permite apenas uma tarefa em espera na fila.
         *
         *     AbortPolicy
         *     <br>
         *     Lança exceção quando o pool e a fila estão cheios,
         *     falhando rapidamente em situações de sobrecarga.
         */
        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.CallerRunsPolicy()
            );

        try {
            //  3 tarefas
            for (int i = 1; i <= 3; i++) {
                int taskId = i;

                System.out.println("Submitting task " + taskId +
                        " from " + Thread.currentThread().getName());

                executor.execute(() -> {
                    System.out.println("Task " + taskId + " running on " +
                        Thread.currentThread().getName());
                    sleep(1000);
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
