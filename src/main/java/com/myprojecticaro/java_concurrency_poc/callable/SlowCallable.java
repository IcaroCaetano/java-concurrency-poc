package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;

public class SlowCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Finished";
    }
}

