package com.myprojecticaro.java_concurrency_poc.callable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SupplierCallable<T> implements Callable<T> {

    private final Supplier<T> supplier;

    public SupplierCallable(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T call() {
        return supplier.get();
    }
}
