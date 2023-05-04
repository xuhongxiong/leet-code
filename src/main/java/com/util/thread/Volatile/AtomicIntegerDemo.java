package com.util.thread.Volatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        atomicInteger.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            //1、如果不加睡眠3秒，会导致main线程跑完了，上面线程未跑完
            //2、使用countDownLatch解决等待时间的问题
            //Thread.sleep(3000);
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"获取到的result:"+atomicInteger.get());

    }
}
