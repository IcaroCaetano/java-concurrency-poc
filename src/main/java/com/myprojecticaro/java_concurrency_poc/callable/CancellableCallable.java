package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;

public class CancellableCallable implements Callable<String> {

    @Override
    public String call() throws Exception {

      // laco de 1 a 10 
      // 
        try {
            for (int i = 1; i <= 10; i++) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Task interrupted, stopping execution");
                    return "Cancelled";
                }

                System.out.println("Processing step " + i);
                Thread.sleep(500);
            }

            return "Completed";

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted during sleep");
            return "Cancelled";
        }
    }
}

