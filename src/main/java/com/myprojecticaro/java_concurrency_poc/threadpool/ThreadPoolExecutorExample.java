package com.myprojecticaro.java_concurrency_poc.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExample {

    public static void run() {

        System.out.println("Iniciando com ThreadPoolExecutorExample");

        ThreadPoolExecutor executor = CustomThreadPoolExecutor.create();

        // 10 tarefas
        for (int i = 1; i <= 10; i++) {
            executor.execute(new SimpleTask(i));
        }

        executor.shutdown();

        System.out.println("Finaliza ThreadPoolExecutorExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
