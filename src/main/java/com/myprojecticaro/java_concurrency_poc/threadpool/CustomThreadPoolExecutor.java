package com.myprojecticaro.java_concurrency_poc.threadpool;

import com.myprojecticaro.java_concurrency_poc.executor.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor {

    public static ThreadPoolExecutor create() {

        // Número mínimo de threads que o pool tenta manter ativas.
        int corePoolSize = 2;
        // Número máximo de threads que o pool pode criar.
        int maxPoolSize = 4;
        // Capacidade da fila que armazena tarefas aguardando execução.
        int queueCapacity = 2;
        // Tempo máximo que threads acima do core ficam vivas quando ociosas.
        long keepAliveTime = 5;

        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                // Cria uma ArrayBlockingQueue com a capacidade (fixa) e a política de acesso padrão especificadas.
                // ArrayBlockingQueue é uma fila bloqueante, limitada, baseada em array, usada para armazenar tarefas
                // de forma thread-safe.
                new ArrayBlockingQueue<>(queueCapacity),
                new NamedThreadFactory("custom-pool"), // uso de fabrica de trhead
                new CustomRejectedExecutionHandler()
        );
    }
}
