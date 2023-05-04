package com.util.thread.Volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Volatile_demo3 {

    public static void main(String[] args) {
        AutoResource autoResource = new AutoResource();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    autoResource.numberPlusPlus();
                    autoResource.addAtomicInteger();
                }
            },String.valueOf(i)).start();
        }
        //默认有两个线程，主线程和gc线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("number:"+autoResource.number);
        System.out.println("atomicInteger:"+autoResource.atomicInteger.get());
    }
}

class AutoResource {
    volatile int number = 0;
    public void numberPlusPlus(){
        number++;
    }
    //使用AtomicInteger保证原子性
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomicInteger(){
        atomicInteger.getAndIncrement();
    }
}
