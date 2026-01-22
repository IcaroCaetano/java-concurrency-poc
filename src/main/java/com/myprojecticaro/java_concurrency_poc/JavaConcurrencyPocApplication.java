package com.myprojecticaro.java_concurrency_poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class JavaConcurrencyPocApplication {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);


	}

}
