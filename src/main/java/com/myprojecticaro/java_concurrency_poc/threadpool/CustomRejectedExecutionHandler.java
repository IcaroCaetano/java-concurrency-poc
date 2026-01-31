package com.myprojecticaro.java_concurrency_poc.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Método que pode ser invocado por um ThreadPoolExecutor quando o método
 * execute não pode aceitar uma tarefa. Isso pode ocorrer quando não houver
 * mais threads ou slots de fila disponíveis porque seus limites seriam excedidos,
 * ou após o desligamento do Executor.Na ausência de outras alternativas, o método pode
 * lançar uma exceção não verificada.
 *
 * @author Icaro caetano
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected. Active threads: " + executor.getActiveCount() +
                ", Queue size: " + executor.getQueue().size()
        );
    }
}
