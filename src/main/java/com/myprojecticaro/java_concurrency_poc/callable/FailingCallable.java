package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;

public class FailingCallable implements Callable<String> {

    @Override
    public String call() {
        throw new IllegalStateException("Something went wrong");
    }
}
