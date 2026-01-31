# Prova de Conceito de Concorrência em Java

![Image_Java_util_concurent.png](image/Image_Java_util_concurent.png)

Este repositório contém uma Prova de Conceito focada em Callable e Future, duas abstrações essenciais de concorrência em Java. O objetivo é fornecer uma compreensão clara e prática de como tarefas assíncronas são executadas, como os resultados são obtidos e como os erros são tratados de forma controlada.

Os exemplos são intencionalmente simples e escritos para fins de estudo, assemelhando-se bastante à forma como um desenvolvedor escreveria e raciocinaria sobre código concorrente em projetos reais.

## Objetivos

- Compreender a diferença entre Runnable e Callable

- Aprender como executar tarefas de forma assíncrona usando ExecutorService

- Obter resultados usando Future

- Lidar com exceções produzidas por tarefas assíncronas

- Trabalhar com estado e dados compartilhados de forma segura

## Structure - Where the thread pool lives

Pool Threads

Each pool thread:

- Is an operating system thread

- Created within the JVM process

- Has:

  - Its own stack (native memory)

  - Internal metadata

This stack is not located on the heap, but it counts towards the total memory consumption of the process.

````
Processo JVM
│
├── Heap
│   ├── ThreadPoolExecutor
│   ├── BlockingQueue
│   ├── Runnable / Callable
│
├── Metaspace
│   ├── Classes carregadas
│
├── Memória nativa
│   ├── Stack Thread 1
│   ├── Stack Thread 2
│   ├── Stack Thread 3
│   └── Stack Thread 4

````

### Callable

#### O que é Callable?

Callable<V> representa uma tarefa que:

- É executada de forma assíncrona

- Retorna um valor

- Pode lançar exceções verificadas ou não verificadas

````java

V call() throws Exception;
````

O Callable é conceitualmente semelhante ao Runnable, mas com duas diferenças importantes:

- Ele retorna um resultado

- Ele suporta propagação de exceções

Por isso, o Callable é preferido sempre que o resultado de uma tarefa for importante.

### Future

#### O que é Future?

Future<V> representa o resultado de uma computação assíncrona. Ele atua como um manipulador que permite ao chamador:

- Recuperar o resultado de uma tarefa

- Verificar se a tarefa foi concluída

- Cancelar a tarefa

- Lidar com falhas de execução

A operação mais comum é get(), que bloqueia até que o resultado esteja disponível.

```java

V result = future.get();
````

Se o Callable lançar uma exceção, ela será encapsulada em uma ExecutionException e relançada por get().

### ExecutorService

As tarefas do Callable não são executadas diretamente. Em vez disso, elas são submetidas a um ExecutorService, que gerencia a criação, reutilização e agendamento de threads.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

Future<String> future = executor.submit(callable);
```
O uso do ExecutorService evita o gerenciamento manual de threads e é a abordagem recomendada em sistemas de produção.

### Exemplos Incluídos nesta POC

Esta POC inclui diversas implementações de Callable, cada uma projetada para demonstrar um conceito específico:

- Callable simples que retorna um valor

- Callable com parâmetros no construtor

- Callable simulando execução atrasada

- Callable que lança uma exceção

- Callable que encapsula um Supplier

- Callable com estado compartilhado usando AtomicInteger

- Callable realizando transformação de dados

Cada exemplo é executado e testado na classe principal da aplicação usando Future.

### Tratamento de Exceções

Exceções lançadas dentro de um Callable não se propagam diretamente. Em vez disso:

- O Callable lança a exceção

- O ExecutorService a captura

- O Future a relança encapsulada em uma ExecutionException

Isso requer tratamento explícito ao chamar future.get().

#### Conceitos-chave demonstrados

- Execução assíncrona de tarefas

- Comportamento bloqueante versus não bloqueante

- Compartilhamento seguro de estado entre threads

- Separação entre definição e execução de tarefas

- Encerramento adequado do ExecutorService

#### Ordem de estudo recomendada

1. Callable vs Runnable

2. Conceitos básicos do ExecutorService

3. Future.get() e comportamento bloqueante

4. Tratamento de exceções com ExecutionException

5. Estado compartilhado e segurança de threads
