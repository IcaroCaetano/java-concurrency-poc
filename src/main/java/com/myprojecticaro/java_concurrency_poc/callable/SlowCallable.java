package com.example.concurrency.callable;

import java.util.concurrent.Callable;

public class SlowCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Finished";
    }
}

