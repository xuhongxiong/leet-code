package com.util.thread;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+"获得A锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+"获得B锁");
                    }
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+"获得A锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName()+"获得B锁");
                    }
                }
            }
        },"线程B").start();
    }
}
