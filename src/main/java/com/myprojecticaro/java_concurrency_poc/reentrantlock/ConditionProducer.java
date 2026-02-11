package com.myprojecticaro.java_concurrency_poc.reentrantlock;

public class ConditionProducer implements Runnable {

    private final ConditionBuffer buffer;

    public ConditionProducer(ConditionBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 1;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                buffer.produce(value++);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
