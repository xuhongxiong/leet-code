package com.util.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
    多个线程之间按顺序调用,实现A->B->C
三个线程启动,要求如下:
    AA打印5次,BB打印10次,CC打印15次
    接着
    AA打印5次,BB打印10次,CC打印15次
    ....来10轮
* */
public class ThreadOrderAccess {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    shareResource.add5();
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    shareResource.add10();
                }
            }
        },"线程B").start();
    }
}

class ShareResource {
    private int number = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public void add5(){
        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"结束");
            lock.unlock();
        }
    }

    public void add10(){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"结束");
            lock.unlock();
        }
    }
}
