package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetExample {

    public static void run() {

        System.out.println();
        System.out.println("Iniciando com CompareAndSetExample");

        AtomicInteger value = new AtomicInteger(10);

        /**
         * Porque evita esse problema clássico:
         *
         * if (value == 10) {
         *     value = 20;
         * }
         *
         *
         * Entre o if e a atribuição, outra thread pode alterar o valor.
         *
         * compareAndSet resolve isso usando uma instrução de hardware chamada:
         *
         * CAS — Compare And Swap
         */
        boolean updated = value.compareAndSet(10, 20);

        System.out.println("Updated: " + updated);
        System.out.println("Current value: " + value.get());

        System.out.println();
        System.out.println("Finaliza CompareAndSetExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}

