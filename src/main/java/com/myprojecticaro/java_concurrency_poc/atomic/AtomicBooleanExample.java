package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {

    /**
     * Um valor booleano que pode ser atualizado atomicamente. Consulte a especificação
     * VarHandle para obter descrições das propriedades dos acessos atômicos.
     * Um AtomicBoolean é usado em aplicações como flags atualizadas atomicamente.
     *
     * Cada thread pode manter uma cópia local em cache da variável.
     *
     * Ela pode continuar enxergando true para sempre.
     */
    private static final AtomicBoolean running = new AtomicBoolean(true);

    public static void run() {

        Thread worker = new Thread(() -> {
            while (running.get()) {
                System.out.println("Working...");
                sleep(500);
            }
            System.out.println("Stopped.");
        });

        worker.start();

        sleep(1500);
        running.set(false);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
