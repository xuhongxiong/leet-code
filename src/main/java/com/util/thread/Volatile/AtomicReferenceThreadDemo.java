package com.util.thread.Volatile;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用AtomicReference来实现自旋锁案例
 */
public class AtomicReferenceThreadDemo {
    static AtomicReference<Thread> reference = new AtomicReference<>();
    static Thread thread;
    public static void lock(){
        thread = Thread.currentThread();
        System.out.println(thread.getName()+"coming");
        reference.compareAndSet(null,thread);
    }

    public static void unLock(){
        System.out.println(thread.getName()+"over");
        reference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomicReferenceThreadDemo.lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AtomicReferenceThreadDemo.unLock();
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomicReferenceThreadDemo.lock();
                AtomicReferenceThreadDemo.unLock();
            }
        },"线程B").start();
    }
}
