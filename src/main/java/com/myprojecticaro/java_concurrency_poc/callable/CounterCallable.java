package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A {@code CounterCallable} is a {@link Callable} implementation that
 * atomically increments and returns the value of a shared counter.
 * <p>
 * This class is designed to be used in concurrent environments where
 * multiple threads need to safely increment the same counter without
 * explicit synchronization.
 * </p>
 *
 * <p>
 * The {@link AtomicInteger} ensures that the increment operation is
 * thread-safe and free from race conditions.
 * </p>
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
