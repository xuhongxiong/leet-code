package com.util.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class LockTest1 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("thread1 获取锁");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"thread1").start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread2 尝试获取锁");
                    lock.lockInterruptibly();//可中断锁
                    //lock.lock();
                    /*int count = 0;
                    while (!lock.tryLock()){
                        System.out.println(count++);
                    }*/
                    System.out.println("thread2 获取到锁");
                } catch (Exception e) {
                    System.out.println("thread2 执行被中断");
                    e.printStackTrace();
                }
            }
        }, "thread2");
        t2.start();

        Thread.sleep(1000);
        if (t2.isAlive()){
            System.out.println("执行线程的中断");
            t2.interrupt();
        } else {
            System.out.println("thread2 执行完成");
        }
    }
}
