package com.myprojecticaro.java_concurrency_poc;

import com.myprojecticaro.java_concurrency_poc.callable.SimpleMessageCallable;
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
			 */
			Future<String> messageFuture =
					executor.submit(new SimpleMessageCallable());

			System.out.println("SimpleMessageCallable result:");
			System.out.println(messageFuture.get());
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
