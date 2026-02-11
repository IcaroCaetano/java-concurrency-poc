package com.myprojecticaro.java_concurrency_poc.reentrantlock;

public class ConditionWithReentrantLockExample {

    public static void run() {

        ConditionBuffer buffer = new ConditionBuffer(3);

        Thread producer = new Thread(new ConditionProducer(buffer), "Producer");
        Thread consumer = new Thread(new ConditionConsumer(buffer), "Consumer");

        producer.start();
        consumer.start();
    }
}

