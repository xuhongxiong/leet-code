package com.util.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 *  多任务组合(allOf、anyOf)
 * ①. allOf:等待所有任务完成
 * (public static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs))
 *
 * ②. anyOf:只要有一个任务完成
 * (public static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs))
 */
public class CompletableFutureTest5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("111");
                return "111";
            }
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("222");
                return "222";
            }
        });
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("333");
                return "333";
            }
        });
        CompletableFuture<Void> completableFuture4 = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
        completableFuture4.get();

        //CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(completableFuture1, completableFuture2, completableFuture3);
        //System.out.println(completableFuture.get());
        System.out.println("over");



    }
}
