package com.myprojecticaro.java_concurrency_poc.reentrantlock;

public class ConditionConsumer implements Runnable {

    private final ConditionBuffer buffer;

    public ConditionConsumer(ConditionBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                buffer.consume();
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
