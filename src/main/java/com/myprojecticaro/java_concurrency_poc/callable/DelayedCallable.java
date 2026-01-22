package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;

public class DelayedCallable implements Callable<String> {

    private final long delayMillis;

    public DelayedCallable(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(delayMillis);
        return "Finished after " + delayMillis + " ms";
    }
}
