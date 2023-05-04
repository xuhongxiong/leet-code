package com.util.thread;

import java.util.concurrent.locks.LockSupport;

/**
(1).阻塞
 (permit默认是O,所以一开始调用park()方法,当前线程就会阻塞,直到别的线程将当前线程的permit设置为1时,
 park方法会被唤醒,然后会将permit再次设置为O并返回)
 static void park()
 static void park(Object blocker)
(2).唤醒
static void unpark(Thread thread)
 (调用unpark(thread)方法后,就会将thread线程的许可permit设置成1(注意多次调用unpark方法,不会累加,
 permit值还是1)会自动唤醒thread线程,即之前阻塞中的LockSupport.park()方法会立即返回)
 static void unpark(Thread thread)
* */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "work");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "唤醒" + "t1线程");
                LockSupport.unpark(t1);
            }
        },"t2").start();

    }
}
