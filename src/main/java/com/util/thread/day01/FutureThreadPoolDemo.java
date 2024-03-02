package com.util.thread.day01;

import java.util.concurrent.*;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //m1();
        long startTime = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        FutureTask<String> task1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return "task1 over";
            }
        });
        threadPool.submit(task1);
        FutureTask<String> task2 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return "task2 over";
            }
        });
        threadPool.submit(task2);
        System.out.println(task1.get());
        System.out.println(task2.get());
        FutureTask<String> task3 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return "task3 over";
            }
        });
        threadPool.submit(task3);
        long endTime = System.currentTimeMillis();
        System.out.println("并发所需时间：" + (endTime-startTime));
        threadPool.shutdown();
    }

    private static void m1(){
        long startTime = System.currentTimeMillis();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("所需时间：" + (endTime-startTime));
    }
}
