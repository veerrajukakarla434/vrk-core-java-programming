# Java Interview Questions - Threads - Part3
## 5) Java Threads

### Java ExecutorService and Thread Pools Tutorial
 
* We know how to create threads in Java by extending the Thread class or implementing the Runnable interface.

* While it is easy to create one or two threads and run them, it becomes a problem when your application requires creating 20 or 30 threads for running tasks concurrently.

* Also, it won’t be exaggerating to say that large multi-threaded applications will have hundreds, if not thousands of threads running simultaneously. So, it makes sense to separate thread creation and management from the rest of the application.

#### Executors, A framework for creating and managing threads.

* **Executors framework helps you with -**

* **Thread Creation:** 
  * It provides various methods for creating threads, more specifically a pool of threads, that your application can use to run tasks concurrently.

* **Thread Management:** 
  * It manages the life cycle of the threads in the thread pool. You don’t need to worry about whether the threads in the thread pool are active or busy or dead before submitting a task for execution.

* **Task submission and execution:** 
  * Executors framework provides methods for submitting tasks for execution in the thread pool, and also gives you the power to decide when the tasks will be executed. For example, You can submit a task to be executed now or schedule them to be executed later or make them execute periodically.
  
  
* Java Concurrency API defines the following three executor interfaces that covers everything that is needed for creating and managing threads -

* **Executor** - 
  * A simple interface that contains a method called execute() to launch a task specified by a Runnable object.

* **ExecutorService** - 
  * A sub-interface of Executor that adds functionality to manage the lifecycle of the tasks. 
  * It also provides a submit() method whose overloaded versions can accept a Runnable as well as a Callable object.
  * Callable objects are similar to Runnable except that the task specified by a Callable object can also return a value.

* **ScheduledExecutorService*** - 
  * A sub-interface of ExecutorService. It adds functionality to schedule the execution of the tasks.  

* Apart from the above three interfaces, The API also provides an Executors class that contains factory methods for creating different kinds of executor services.

* Refer  List of Executors class Methods : https://www.javatpoint.com/java-executors


### Callable and Future

* Another important advantage of the Executor framework was the Callable interface. It’s similar to the Runnable interface with two benefits:

  * It’s call() method returns a result after the thread execution is complete.
  * When we send a Callable object to an executor, we get a Future object’s reference. We can use this object to query the status of thread and the result of the Callable object.

### Creating ExecutorService instances

* ExecutorService is an interface and it’s implementations can execute a Runnable or Callable class in an asynchronous way. Note that invoking the run() method of a Runnable interface in a synchronous way is simply calling a method.

* We can create an instance of ExecutorService in following ways:

* **Executors class:**- Executors is a utility class that provides factory methods for creating the implementations of the interface.

```Java
//Executes only one thread
ExecutorService es = Executors.newSingleThreadExecutor(); 
 
//Internally manages thread pool of 2 threads
ExecutorService es = Executors.newFixedThreadPool(2); 
 
//Internally manages thread pool of 10 threads to run scheduled tasks
ExecutorService es = Executors.newScheduledThreadPool(10); 
```

#### ExecutorService example

* In the following example, we first create an ExecutorService with a single worker thread, and then submit a task to be executed inside the worker thread.

```Java
package com.vrk.core.programs.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };

        System.out.println("Submit the task specified by the runnable to the executor service.");
        executorService.submit(runnable);
    }
}
```
```Console
# Output
Inside : main
Creating Executor Service...
Creating a Runnable...
Submit the task specified by the runnable to the executor service.
Inside : pool-1-thread-1
```

* The above example shows how to create an executor service and execute a task inside the executor. We use the **Executors.newSingleThreadExecutor()** method to create an **ExecutorService** that uses a single worker thread for executing tasks. If a task is submitted for execution and the thread is currently busy executing another task, then the new task will wait in a queue until the thread is free to execute it.

* If you run the above program, you will notice that the program never exits, because, the executor service keeps listening for new tasks until we shut it down explicitly.

### Shutting down the ExecutorService

* ExecutorService provides two methods for shutting down an executor -

* **shutdown()** - when shutdown() method is called on an executor service, it stops accepting new tasks, waits for previously submitted tasks to execute, and then terminates the executor.

* **shutdownNow()** - this method interrupts the running task and shuts down the executor immediately.

* Let’s add shutdown code at the end of our program so that it exits gracefully -

```Java
System.out.println("Shutting down the executor");
executorService.shutdown();
```
Now the output

```Console
Inside : main
Creating Executor Service .....
Creating a Runnable...
Submit the task specified by the runnable to the executor service.
Inside : pool-1-thread-1
Shutting down the executor
```

