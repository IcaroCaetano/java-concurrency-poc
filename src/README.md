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
