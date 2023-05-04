package com.util.thread.Volatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ClickNumber {
    int number = 1;
    public synchronized void add(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void add_atomicInteger(){
        atomicInteger.incrementAndGet();
    }

    AtomicLong atomicLong = new AtomicLong();
    public void add_atomicLong(){
        atomicLong.incrementAndGet();
    }

    LongAdder longAdder = new LongAdder();
    public void add_longAdder(){
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new LongAccumulator(new LongBinaryOperator() {
        @Override
        public long applyAsLong(long left, long right) {
            return left+right;
        }
    },1);
    public void add_longAccumulator(){
        longAccumulator.accumulate(1);
    }

    private static int size = 50;
    private static int _1w = 10000;
    public static void main(String[] args) {
        ClickNumber clickNumber = new ClickNumber();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 10*_1w; j++) {
                            clickNumber.add_longAccumulator();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //synchronized 1058
        //atomicInteger 137
        //atomicLong 137
        //longAdder 4
        //longAccumulator 15
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
