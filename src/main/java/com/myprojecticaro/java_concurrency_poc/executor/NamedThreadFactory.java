package com.myprojecticaro.java_concurrency_poc.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * O uso de fábricas de threads remove a vinculação fixa de chamadas para `new Thread`,
 * permitindo que os aplicativos usem subclasses de threads especiais,
 */
public class NamedThreadFactory implements ThreadFactory {

    private final String prefix;
    private final AtomicInteger counter = new AtomicInteger(1);

    public NamedThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {

        return new Thread(r, prefix + "-" + counter.getAndIncrement());
    }
}
