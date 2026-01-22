package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterCallable implements Callable<Integer> {

    private final AtomicInteger counter;

    public CounterCallable(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() {
        return counter.incrementAndGet();
    }
}
