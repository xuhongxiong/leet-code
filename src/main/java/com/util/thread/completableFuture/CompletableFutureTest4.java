package com.util.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 对计算结果进行合并(thenCombine、thenAcceptBoth、runAfterBoth)
 *
 * //public <U,V> CompletableFuture<V> thenCombine
 *         //(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn)
 *         //两个CompletionStage任务都完成后,最终把两个任务的结果一起交给thenCombine来处理
 *         //先完成的先等着,等待其他分支任务
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) {
        Integer join = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 10;
            }
        }).thenCombine(CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 20;
            }
        }), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).join();
        System.out.println(join);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
