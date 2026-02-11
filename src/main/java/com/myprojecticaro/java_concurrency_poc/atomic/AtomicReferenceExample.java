package com.myprojecticaro.java_concurrency_poc.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    public static void run() {

        System.out.println();
        System.out.println("Iniciando com AtomicReferenceExample");

        /**
         *Uma referência de objeto que pode ser atualizada atomicamente. Consulte a especificação VarHandle para
         * obter descrições das propriedades dos acessos atômicos.
         */
        AtomicReference<String> reference = new AtomicReference<>("Initial");


        /**
         * Atualiza atomicamente (com os efeitos de memória especificados por VarHandle.compareAndSet) o valor atual
         * com os resultados da aplicação da função fornecida, retornando o valor atualizado. A função deve ser livre
         * de efeitos colaterais, visto que pode ser reaplicada quando as tentativas de atualização falharem devido à
         * contenção entre threads.
         */
        reference.updateAndGet(current -> current + " -> Updated");

        System.out.println("Value: " + reference.get());

        System.out.println();
        System.out.println("Finaliza AtomicBooleanExample");
        System.out.println("********************************************************************");
        System.out.println();
    }
}
