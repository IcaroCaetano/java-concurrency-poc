package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {

    private int value = 0;
    /**
     * Um bloqueio de exclusão mútua reentrante com o mesmo
     * comportamento básico e semântica do bloqueio de monitor
     * implícito acessado usando métodos e instruções sincronizadas,
     * mas com recursos estendidos.
     *
     * Um ReentrantLock pertence à thread que o bloqueou com sucesso
     * por último, mas ainda não o desbloqueou. Uma thread que invoca
     * o bloqueio retornará, adquirindo o bloqueio com sucesso, quando
     * o bloqueio não pertencer a outra thread. O método retornará
     * imediatamente se a thread atual já possuir o bloqueio. Isso pode
     * ser verificado usando os métodos isHeldByCurrentThread e getHoldCount.
     */
    private final ReentrantLock lock;

    public SharedCounter(ReentrantLock lock) {
        this.lock = lock;
    }

    public void increment() {
        lock.lock();
        try {
            value++;
            System.out.println(Thread.currentThread().getName() +
                    " incremented value to " + value);
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }
}
