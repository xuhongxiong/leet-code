package com.util.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 持有锁时响应中断
 */
public class LockTest3 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        DemoThread demoThread1 = new DemoThread(lock1, lock2);
        DemoThread demoThread2 = new DemoThread(lock2, lock1);
        demoThread1.start();
        demoThread2.start();
        System.out.println("t1 中断");
        Thread.sleep(1000);
        demoThread1.interrupt();
        Thread.sleep(1000);

    }
}

class DemoThread extends Thread{
    private final Lock lock1;
    private final Lock lock2;

    public DemoThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"线程开始获取锁lock1");
            lock1.lockInterruptibly();
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName()+"线程开始获取锁lock2");
            lock2.lockInterruptibly();
            System.out.println(Thread.currentThread().getName()+"线程开始得到锁lock2");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"线程结束");
            try {
                lock1.unlock();
                lock2.unlock();
            } catch (Exception e){
                //e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程结束end");
        }
    }
}
