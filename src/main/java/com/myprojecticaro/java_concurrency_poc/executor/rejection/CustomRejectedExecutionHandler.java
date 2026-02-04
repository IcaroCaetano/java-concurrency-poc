package com.myprojecticaro.java_concurrency_poc.executor.rejection;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println(
            "Task rejected | Active: " +
            executor.getActiveCount() +
            " | Queue size: " +
            executor.getQueue().size()
        );
    }
}

