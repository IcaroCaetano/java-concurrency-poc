package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample {

    public static void run() {
        ReentrantLock lock = new ReentrantLock();


        Thread worker = new Thread(() -> {
            try {
                /**
                 * Adquire o bloqueio, a menos que a thread atual seja interrompida.
                 *
                 * Adquire o bloqueio se ele não estiver sendo mantido por outra thread e retorna imediatamente,
                 * definindo a contagem de bloqueios mantidos como um.
                 * Se a thread atual já mantiver esse bloqueio, a contagem de bloqueios mantidos será incrementada
                 * em um e o método retornará imediatamente.
                 * Se o bloqueio estiver sendo mantido por outra thread, a thread atual será desabilitada para fins
                 * de agendamento de threads e permanecerá inativa até que uma das duas coisas aconteça:
                 * O bloqueio for adquirido pela thread atual; ou
                 * Alguma outra thread interromper a thread atual.
                 */
                lock.lockInterruptibly();
                try {
                    System.out.println("Worker acquired the lock");
                    Thread.sleep(2000);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Worker was interrupted while waiting for the lock");
                Thread.currentThread().interrupt();
            }
        });

        lock.lock();
        worker.start();

        sleep(500);
        worker.interrupt();
        lock.unlock();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
