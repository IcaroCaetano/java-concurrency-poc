package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;

public class UppercaseCallable implements Callable<String> {

    private final String input;

    public UppercaseCallable(String input) {
        this.input = input;
    }

    @Override
    public String call() {
        return input.toUpperCase();
    }
}
