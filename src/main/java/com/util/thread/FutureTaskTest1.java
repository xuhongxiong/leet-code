package com.util.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class FutureTaskTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        //阻塞
        Integer integer = futureTask.get();
        //过时不候
        //futureTask.get(2L, TimeUnit.SECONDS);
        //轮询
        /*while (true){
            if (futureTask.isDone()){
                break;
            } else {
                System.out.println("阻塞中");
            }
        }*/
        System.out.println(integer);
    }
}

class MyCallable implements Callable<Integer> {

    //call方法只会调用一次
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += i;
        }
        System.out.println("call");
        return sum;
    }
}
