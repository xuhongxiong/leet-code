package com.util.thread.completableFuture;

import com.xhx.test.People;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 业务场景 - 接口聚合:在进入App首页的时候,会调用多个接口,比如:查询会员等级等基本信息、根据会员、等级查询会员可享受权益列表、查询等级列表等
 * 这三个接口如果A接口需要花费2s,B接口需要花费1s,C接口需要花费2s,这个时候总的花费时间就是5s。采取异步的方式,可以让接口只花费3s(接口B的入参需要等待接口A进入)
 *
 * runAsync方法不支持返回值.适用于多个接口之间没有任何先后关系
 * supplyAsync可以支持返回值,我们一般用supplyAsync来创建
 * 比如在一个方法中,调用6个接口,接口A的结果需要作为接口B的入参,这个时候适合用带返回值的构造
 *
 * 没有指定Executor的方法会使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码。如果指定线程池,则使用指定的线程池运行。以下所有的方法都类同
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        People people = new People();
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3));*/
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("11"+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        },threadPool).thenAcceptAsync(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("22"+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                people.setId(new BigDecimal(integer + 3));
            }
        });
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                //ForkJoinPool.commonPool();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                people.setName("xhx");
            }
        },threadPool);
        // 等待所有任务都完成再返回
        CompletableFuture.allOf(completableFuture,completableFuture1).join();
        long end = System.currentTimeMillis();
        System.out.println("消耗时间为:"+(end-start));
        System.out.println(people);
        threadPool.shutdown();
    }
}
