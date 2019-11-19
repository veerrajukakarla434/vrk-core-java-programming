# Java Interview Questions - Threads - Part3
## 5) Java Threads
Reference : https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/
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
### ExecutorService example with multiple threads and tasks

* In the earlier example, we created an ExecutorService that uses a single worker thread. But the real power of ExecutorService comes when we create a pool of threads and execute multiple tasks concurrently in the thread pool.

* Following example shows how you can create an executor service that uses a thread pool and execute multiple tasks concurrently -

```Java
package com.vrk.core.programs.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsThreadPoolExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task3 = () -> {
            System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };


        System.out.println("Submitting the tasks for execution...");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }
}
```

### Output
```Console
Inside : main
Creating Executor Service with a thread pool of Size 2
Submitting the tasks for execution...
Executing Task2 inside : pool-1-thread-2
Executing Task1 inside : pool-1-thread-1
Executing Task3 inside : pool-1-thread-1
```

* In the example above, we created an executor service with a fixed thread pool of size 2. A fixed thread pool is a very common type of thread pool that is frequently used in multi-threaded applications.

* In a fixed thread-pool, the executor service makes sure that the pool always has the specified number of threads running. If any thread dies due to some reason, it is replaced by a new thread immediately.

* When a new task is submitted, the executor service picks one of the available threads from the pool and executes the task on that thread. If we submit more tasks than the available number of threads and all the threads are currently busy executing the existing tasks, then the new tasks will wait for their turn in a queue.

## Thread Pool

* Most of the executor implementations use thread pools to execute tasks. A thread pool is nothing but a bunch of worker threads that exist separately from the Runnable or Callable tasks and is managed by the executor.

* Creating a thread is an expensive operation and it should be minimized. Having worker threads minimizes the overhead due to thread creation because executor service has to create the thread pool only once and then it can reuse the threads for executing any task.

* We already saw an example of a thread pool in the previous section called a fixed thread-pool.

* Tasks are submitted to a thread pool via an internal queue called the Blocking Queue. If there are more tasks than the number of active threads, they are inserted into the blocking queue for waiting until any thread becomes available. If the blocking queue is full than new tasks are rejected.


![executor-service-thread-pool-blocking-queue-example](https://www.callicoder.com/assets/images/post/large/executor-service-thread-pool-blocking-queue-example.jpg "executor-service-thread-pool-blocking-queue-example")

## ScheduledExecutorService example

* ScheduledExecutorService is used to execute a task either periodically or after a specified delay.

* In the following example, We schedule a task to be executed after a delay of 5 seconds -

```Java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
          System.out.println("Executing Task At " + System.nanoTime());
        };

        System.out.println("Submitting task at " + System.nanoTime() + " to be executed after 5 seconds.");
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
        
        scheduledExecutorService.shutdown();
    }
}
```
```Console
# Output
Submitting task at 2909896838099 to be executed after 5 seconds.
Executing Task At 2914898174612
```
* scheduledExecutorService.schedule() function takes a Runnable, a delay value, and the unit of the delay. The above program executes the task after 5 seconds from the time of submission.

* **Now let’s see an example where we execute the task periodically -**

```Java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsPeriodicExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
          System.out.println("Executing Task At " + System.nanoTime());
        };
        
        System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
        scheduledExecutorService.scheduleAtFixedRate(task, 0,2, TimeUnit.SECONDS);
    }
}
```
```Console
# Output
scheduling task to be executed every 2 seconds with an initial delay of 0 seconds
Executing Task At 2996678636683
Executing Task At 2998680789041
Executing Task At 3000679706326
Executing Task At 3002679224212
.....
```
* scheduledExecutorService.scheduleAtFixedRate() method takes a Runnable, an initial delay, the period of execution, and the time unit. It starts the execution of the given task after the specified delay and then executes it periodically on an interval specified by the period value.

* Note that if the task encounters an exception, subsequent executions of the task are suppressed. Otherwise, the task will only terminate if you either shut down the executor or kill the program.


## Java Callable and Future

### Callable

* In the previous tutorials, we used a Runnable object to define the tasks that are executed inside a thread. While defining tasks using Runnable is very convenient, it is limited by the fact that the tasks can not return a result.

* **What if you want to return a result from your tasks?**
* Well, Java provides a Callable interface to define tasks that return a result. A Callable is similar to Runnable except that it can return a result and throw a checked exception.

* Callable interface has a single method call() which is meant to contain the code that is executed by a thread. Here is an example of a simple Callable -

```Java
Callable<String> callable = new Callable<String>() {
    @Override
    public String call() throws Exception {
        // Perform some computation
        Thread.sleep(2000);
        return "Return some result";
    }
};
```
* Note that with Callable, you don’t need to surround Thread.sleep() by a try/catch block, because unlike Runnable, a Callable can throw a checked exception.

* You can also use a lambda expression with Callable like this -

```Java

Callable<String> callable = () -> {
    // Perform some computation
    Thread.sleep(2000);
    return "Return some result";
};
```

## Executing Callable tasks using ExecutorService and obtaining the result using Future

* Just like Runnable, you can submit a Callable to an executor service for execution. But what about the Callable’s result? How do you access it?

* **The submit() method of executor service submits the task for execution by a thread. However, it doesn’t know when the result of the submitted task will be available. Therefore, it returns a special type of value called a Future which can be used to fetch the result of the task when it is available.**

* The concept of Future is similar to Promise in other languages like Javascript. It represents the result of a computation that will be completed at a later point of time in future.

* Following is a simple example of Future and Callable -










