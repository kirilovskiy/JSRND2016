package com.sbt.lesson14;

import java.util.concurrent.*;

public class TaskTest {
    private final static int nThreads = 5;
    public final static CountDownLatch startGate = new CountDownLatch(2);
    public final static CountDownLatch endGate = new CountDownLatch(nThreads);


    public static void waitEnd() throws InterruptedException {
        System.out.println("Поставили поток в ожидание... endGate.await()");
        endGate.await();
        System.out.println("Дождались конца");

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Runnable r = () -> {
            System.out.println("task run");
            System.out.println(Thread.currentThread().getName());
        };
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.submit(r);
        ex.shutdown();*/
        /*Runnable r = () -> {
            System.out.println("task run " + Thread.currentThread().getId());
        };
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        // scheduleAtFixedRate - запускает задачи с интервалом, не дожидаясь их завершения
        // scheduleWithFixedDelay - указанный интервал будет отсчитываться от времени завершения предыдущей задачи
        service.scheduleAtFixedRate(r, 0, 5, TimeUnit.SECONDS);
        service.shutdown();
        */

        Callable<String> callable = () -> String.valueOf(Thread.currentThread().getId());
        MyFutureRunnable futureTask =  new MyFutureRunnable(callable);
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.execute(futureTask);
        if (!futureTask.isDone()){
            System.out.println(futureTask.get());
        }
        ex.shutdown();

        /*ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.execute(new LatchExample());
            System.out.println("Отдали executor - у задачу");
            System.out.println(".........");
            System.out.println(".........");
            System.out.println(".........");
            System.out.println(".........");
            startGate.countDown();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        waitEnd();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            for (int i = 0; i < 5; i++) {
                executorService.execute(new LatchExample());
            }
        } finally {
            executorService.shutdown();
        }*/
    }
}
