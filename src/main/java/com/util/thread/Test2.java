package com.util.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test2 {
    volatile int a = 0;
    Lock lock = new ReentrantLock();
    void increase(){
        lock.lock();
        a++;
        lock.unlock();
    }
    @Test
    public void test(){
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            },"thread"+i).start();
        }
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(a);
    }

}
