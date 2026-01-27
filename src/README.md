# POC Java Concurrency

This repository contains a Proof of Concept focused on Callable and Future, two core concurrency abstractions in Java. The goal is to provide a clear and practical understanding of how asynchronous tasks are executed, how results are retrieved, and how errors are handled in a controlled way.

The examples are intentionally simple and written for study purposes, closely resembling how a developer would write and reason about concurrent code in real projects.

## Objectives

- Understand the difference between Runnable and Callable

- Learn how to execute tasks asynchronously using ExecutorService
  
- Retrieve results using Future

- Handle exceptions produced by asynchronous tasks

- Work with state and shared data safely

### Callable

#### What is Callable?

Callable<V> represents a task that:

- Is executed asynchronously

- Returns a value

- Can throw checked or unchecked exceptions

````java
V call() throws Exception;
````

Callable is conceptually similar to Runnable, but with two important differences:

- It returns a result

- It supports exception propagation

Because of this, Callable is preferred whenever the result of a task matters.


### Future

#### What is Future?

Future<V> represents the result of an asynchronous computation. It acts as a handle that allows the caller to:

- Retrieve the result of a task

- Check if the task has completed

- Cancel the task

- Handle execution failures

The most common operation is get(), which blocks until the result is available.

````java
V result = future.get();
````
If the Callable throws an exception, it is wrapped inside an ExecutionException and rethrown by get().
