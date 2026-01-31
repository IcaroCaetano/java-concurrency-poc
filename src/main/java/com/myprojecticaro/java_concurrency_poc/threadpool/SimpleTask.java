package com.myprojecticaro.java_concurrency_poc.threadpool;

public class SimpleTask implements Runnable {

    private final int taskId;

    public SimpleTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Executing task " + taskId + " on " + Thread.currentThread().getName());

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task " + taskId + " interrupted");
        }
    }
}
