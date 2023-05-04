package com.util.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁等待过程响应中断
 */
public class LockTest2 {
    private static Lock lock = new ReentrantLock();
    private int a = 0;
    public static void main(String[] args) throws InterruptedException {
        LockTest2 lockTest = new LockTest2();
        MyThread myThread1 = new MyThread(lockTest);
        MyThread myThread2 = new MyThread(lockTest);
        myThread1.start();
        //Thread.sleep(5);
        myThread2.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        myThread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        try {
            System.out.println(thread.getName()+"开始获取锁");
            lock.lockInterruptibly();
            System.out.println(thread.getName()+"得到了锁");
            long start = System.currentTimeMillis();
            /*if (a == 0){
                a++;
                Thread.sleep(1000);
            }*/
            Thread.sleep(4000);
            //System.out.println(thread.getName()+"a:"+a);
            /*while (System.currentTimeMillis()-start <= 64421){
            }*/
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName()+"执行了finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }
}

class MyThread extends Thread{
    private LockTest2 test = null;

    public MyThread(LockTest2 test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        } catch (Exception e){
            System.out.println(Thread.currentThread().getName()+"被中断");
            //e.printStackTrace();
        }
    }
}
