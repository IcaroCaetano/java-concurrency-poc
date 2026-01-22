package com.myprojecticaro.java_concurrency_poc;

import com.myprojecticaro.java_concurrency_poc.callable.DelayedCallable;
import com.myprojecticaro.java_concurrency_poc.callable.SimpleMessageCallable;
import com.myprojecticaro.java_concurrency_poc.callable.SumCallable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class JavaConcurrencyPocApplication {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		try {

			/*
			 * - SimpleMessageCallable
			 * , teste simples de callable
			 */
			Future<String> messageFuture =
					executor.submit(new SimpleMessageCallable());

			System.out.println("SimpleMessageCallable result:");
			System.out.println(messageFuture.get());
			System.out.println();

			/*
			 * 2. SumCallable
			 * , Callable com estado
			 */
			Future<Integer> sumFuture =
					executor.submit(new SumCallable(10, 20));

			System.out.println("SumCallable result:");
			System.out.println(sumFuture.get());
			System.out.println();

			/*
			 * 3. DelayedCallable
			 * Simula processamento demorado
			 */
			Future<String> delayedFuture =
					executor.submit(new DelayedCallable(1000));

			System.out.println("DelayedCallable result:");
			System.out.println(delayedFuture.get());
			System.out.println();

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}


	}

}
