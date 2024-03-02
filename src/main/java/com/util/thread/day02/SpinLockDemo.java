package com.util.thread.day02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现一个自旋锁
 */
public class SpinLockDemo {

    static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public static void unLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t over");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpinLockDemo.lock();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                SpinLockDemo.unLock();
            }
        },"t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpinLockDemo.lock();
                SpinLockDemo.unLock();
            }
        },"t2").start();
    }
}
