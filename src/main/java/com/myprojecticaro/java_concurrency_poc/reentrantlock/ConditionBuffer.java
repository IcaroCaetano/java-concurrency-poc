package com.myprojecticaro.java_concurrency_poc.reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBuffer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * A classe `Condition` extrai os métodos de monitoramento de objetos (`wait`, `notify` e `notifyAll`)
     * em objetos distintos para criar o efeito de múltiplos conjuntos de espera por objeto, combinando-os
     * com o uso de implementações arbitrárias de `Lock`. Enquanto um `Lock` substitui o uso de métodos e
     * instruções sincronizadas, uma `Condition` substitui o uso dos métodos de monitoramento de objetos.
     * As `Condition` (também conhecidas como filas de condição ou variáveis ​​de condição) fornecem
     * um meio para que uma thread suspenda a execução (para "esperar") até ser notificada por outra thread
     * de que alguma condição de estado pode agora ser verdadeira. Como o acesso a essas informações de estado
     * compartilhadas ocorre em threads diferentes, ele deve ser protegido; portanto, um `Lock` de alguma forma
     * é associado à condição. A principal propriedade que a espera por uma condição fornece é que ela libera
     * atomicamente o `Lock` associado e suspende a thread atual, assim como `Object.wait`.
     */
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public ConditionBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Buffer cheio. Produtor aguardando...");
                notFull.await();
            }

            queue.add(value);
            System.out.println("Produzido: " + value);

            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Buffer vazio. Consumidor aguardando...");
                notEmpty.await();
            }

            int value = queue.poll();
            System.out.println("Consumido: " + value);

            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}