package com.util.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 业务场景:查询商品详情页的逻辑比较复杂,有些数据还需要远程调用,必然需要花费更多的时间
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) {
        /**
         1.当一个线程依赖另一个线程时,可以使用thenApply()方法来把这两个线程串行化(第二个任务依赖第一个任务的结果)
         public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
         2.它可以处理正常的计算结果,或者异常情况
         public CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action)
         3.异常的处理操作
         public CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn)
         */
        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //int a = 1/0;
                return 1;
            }
        }).thenApply(result -> {
            return result + 3;
        // whenComplete虽然得到异常信息,但是无法修改返回数据
        }).whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer integer, Throwable throwable) {
                if (throwable == null) {
                    System.out.println(Thread.currentThread().getName() + "\t result:" + integer);
                }
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            //有异常也可以往下一步走,根据带的异常参数可以进一步处理
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                //System.out.println(Thread.currentThread().getName() + "\t handle:" + integer);
                System.out.println(Thread.currentThread().getName() + "\t handle1:" + (integer +2));
                int a = 1/0;
                System.out.println(Thread.currentThread().getName() + "\t handle2:" + (integer +2));
                return integer+2;
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                System.out.println(Thread.currentThread().getName() + "\t handle3:" + integer);
                //return integer+2;
                return 2;
            }
        }).exceptionally(new Function<Throwable, Integer>() {
            // exceptionally: 同时感知异常,同时返回默认值
            @Override
            public Integer apply(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });
        System.out.println(Thread.currentThread().getName()+"\t over");

        //主线程不要立即结束,否则CompletableFuture默认使用的线程池会立即关闭,暂停几秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
