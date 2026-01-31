package com.myprojecticaro.java_concurrency_poc.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExample {

    public static void run() {

        ThreadPoolExecutor executor = CustomThreadPoolExecutor.create();

        // 10 tarefas
        for (int i = 1; i <= 10; i++) {
            executor.execute(new SimpleTask(i));
        }

        executor.shutdown();
    }
}
