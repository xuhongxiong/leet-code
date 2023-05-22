package com.util.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class InterruptDemo {
    public static volatile boolean IS_INTERRUPTED = false;
    public static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    public static void main(String[] args) {
        /**
         * 比较静态方法interrupted和实例方法isInterrupted
         * 静态方法interrupted将会清除中断状态(传入的参数ClearInterrupted位true)
         *      判断线程是否被中断,并清楚当前中断状态,这个方法做了两件事
         *      (返回当前线程的中断状态 | 将当前线程的中断状态设为false)
         *      原理:假设有两个线程A、B,线程B调用了interrupt方法,这个时候我们连接调用两次isInterrupted方法,第一次会返回true,然后这个方法会将中断标识位设置位false,所以第二次调用将返回false
         *
         * 实例方法isInterrupted则不会(传入的参数ClearInterrupted为false)
         */
        /*System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());*/
        //System.out.println(Thread.currentThread().getName()+"---"+Thread.currentThread().isInterrupted());
        //System.out.println(Thread.currentThread().getName()+"---"+Thread.currentThread().isInterrupted());

        /**
         *  如何使用中断标识停止线程
         * ①. 在需要中断的线程中不断监听中断状态,一旦发生中断,就执行型对于的中断处理业务逻辑
         * ②. 三种中断标识停止线程的方式
         *
         * 通过一个volatile变量实现
         * 通过AtomicBoolean
         * 通过Thread类自带的中断API方法实现
         */
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //if (Thread.currentThread().isInterrupted()) {
                    //if (IS_INTERRUPTED) {
                    if (atomicBoolean.get()) {
                        System.out.println(Thread.currentThread().getName() + "   interrupted");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "   work");
                }
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                //t1.interrupt();
                //IS_INTERRUPTED = true;
                atomicBoolean.set(true);
            }
        },"t2").start();*/
        m5();

    }

    public static void m5(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "线程结束");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //线程的中断标志位重新设置为false,无法停下,需要再次掉interrupt()设置true
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "work");
                }
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
                t1.interrupt();
            }
        },"t2").start();
    }

    /**
     *中断为true后,并不是立刻stop程序
     */
    public static void m6(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    System.out.println(i);
                }
                System.out.println("t1.interrupt() 之后" + Thread.currentThread().isInterrupted());
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("t1.isInterrupted() --- "+t1.isInterrupted());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1.isInterrupted() 3000 --- "+t1.isInterrupted());

    }
}
