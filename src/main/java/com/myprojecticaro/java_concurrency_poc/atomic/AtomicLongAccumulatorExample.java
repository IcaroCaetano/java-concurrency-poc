package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.LongAdder;

public class AtomicLongAccumulatorExample {

    /**
     * Uma ou mais variáveis que, juntas, mantêm uma soma longa inicialmente igual a zero.
     * Quando as atualizações (método add) são disputadas entre threads, o conjunto de variáveis
     * pode crescer dinamicamente para reduzir a disputa. O método sum (ou, equivalentemente, longValue) retorna o
     * total atual combinado entre as variáveis ​​que mantêm a soma.
     *
     * Essa classe geralmente é preferível a AtomicLong quando várias threads atualizam uma soma comum que é
     * usada para fins como coleta de estatísticas, e não para controle de sincronização refinado. Sob baixa disputa
     * de atualização, as duas classes têm características semelhantes. Mas sob alta disputa, a taxa de transferência
     * esperada dessa classe é significativamente maior, à custa de maior consumo de espaço.
     */
    private static final LongAdder adder = new LongAdder();

    public static void run() {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                adder.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        join(t1, t2);

        System.out.println("Final value: " + adder.sum());
    }

    private static void join(Thread... threads) {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
