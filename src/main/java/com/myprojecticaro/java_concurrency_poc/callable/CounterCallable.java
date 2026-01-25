package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A {@code CounterCallable} is a {@link Callable} implementation that
 * atomically increments and returns the value of a shared counter.
 * 
 * @author Icaro
 */
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
