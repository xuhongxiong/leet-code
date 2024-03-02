package com.util.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * applyToEither:两个任务有一个执行完成,获取它的返回值,处理任务并有新的返回值
 * acceptEither:两个任务有一个执行完成,获取它的返回值,处理任务,没有新的返回值
 * runAfterEither:两个任务有一个执行完成,不需要获取 future 的结果,处理任务,也没有返回值
 */
public class CompletableFutureTest3 {
    public static void main(String[] args) {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {e.printStackTrace();}
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(2);  } catch (InterruptedException e) {e.printStackTrace();}
            return 2;
        }), r -> r).join());
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
